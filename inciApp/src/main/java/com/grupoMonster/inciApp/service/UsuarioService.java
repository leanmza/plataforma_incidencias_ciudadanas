package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.PasswordRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.exception.DuplicateResourceException;
import com.grupoMonster.inciApp.mapper.IUserMapper;
import com.grupoMonster.inciApp.model.*;
import com.grupoMonster.inciApp.repository.IUsuarioRepository;
import com.grupoMonster.inciApp.service.imp.*;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioService implements IUsuarioService {

    private static final String DEFAULT_ROLE = "USER";

    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ILocalidadService localidadService;

    @Autowired
    private IDepartamentoService departamentoService;

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private IUserMapper userMapper;


    @Override
    public List<UsuarioResponseDTO> findAll() {
        List<Usuario> usuarios = userRepo.findAll();
        return userMapper.toListUsuarioResponse(usuarios);
    }

    @Override
    public UsuarioResponseDTO findById(String id) {
        Usuario usuario = findUsuario(id);
        return userMapper.toUsuarioResponse(usuario);
    }


    @Override
    public UsuarioResponseDTO save(UsuarioRequestDTO userDTO) {
        if (userRepo.existsByUsername(userDTO.getUsername())) {
            throw new DuplicateResourceException(
                    "El nombre de usuario " + userDTO.getUsername() + " ya esta registrado");
        }

        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateResourceException(
                    "El email ya esta registrado"
            );
        }

        Usuario user = userMapper.toUsuario(userDTO);

        //Se asigna automaticamente el rol user a todos los usuarios nuevos, solo los admin pueden cambiar el rol
        Role defaultRole = roleService.findByName(DEFAULT_ROLE)
                .orElseThrow(() -> new RuntimeException("No existe el rol por defecto " + DEFAULT_ROLE));

        Provincia provincia = provinciaService.findProvincia(userDTO.getIdProvincia());
        Departamento departamento = departamentoService.findDepartamento(userDTO.getIdDepartamento());
        Localidad localidad = localidadService.findLocalidad(userDTO.getIdLocalidad());


        user.setPassword(encriptPassword(userDTO.getPassword()));

        user.setLocalidad(localidad);
        user.setDepartamento(departamento);
        user.setProvincia(provincia);

        user.setRolesList(new HashSet<>(Set.of(defaultRole)));
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setAccountNotLocked(true);
        user.setCredentialNotExpired(true);

        userRepo.save(user);
        return userMapper.toUsuarioResponse(user);
    }

    @Override
    public UsuarioResponseDTO update(String id, UsuarioUpdateRequestDTO userDTO) {
        Usuario updatedUser = findUsuario(id);


        updatedUser.setName(userDTO.getName());
        updatedUser.setLastname(userDTO.getLastname());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            updatedUser.setPassword(encriptPassword(userDTO.getPassword()));
        }
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setDni(userDTO.getDni());
        updatedUser.setTelefono(userDTO.getTelefono());
        updatedUser.setDireccion(userDTO.getDireccion());
        updatedUser.setFechaNacimiento(userDTO.getFechaNacimiento());
        /*
        updatedUser.setLocalidad //todo hacer entidad, repo, service, controller
        updatedUser.setDepartamento //todo hacer entidad, repo, service, controller
        updatedUser.setProvincia //todo hacer entidad, repo, service, controller
         */
        userRepo.save(updatedUser);
        return userMapper.toUsuarioResponse(updatedUser);
    }

    //Se va a hacer un soft delete (lógico), se cambia isEnabled a false
    @Override
    public UsuarioResponseDTO delete(String id) {
        Usuario deletedUser = findUsuario(id);

        deletedUser.setEnabled(false);
        userRepo.save(deletedUser);
        return userMapper.toUsuarioResponse(deletedUser);

    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Usuario findByUsername(String username) {
        return userRepo.findUserEntityByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    }

    @Override
    public UsuarioResponseDTO findMe(Authentication authentication) {
        Usuario usuario = findByUsername(authentication.getName());
        return userMapper.toUsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponseDTO updateMe(Authentication authentication, UsuarioUpdateRequestDTO usuarioUpdateRequestDTO) {

        Usuario updatedUsuario = findByUsername(authentication.getName());

        updatedUsuario.setName(usuarioUpdateRequestDTO.getName());
        updatedUsuario.setLastname(usuarioUpdateRequestDTO.getLastname());

        updatedUsuario.setEmail(usuarioUpdateRequestDTO.getEmail());
        updatedUsuario.setDni(usuarioUpdateRequestDTO.getDni());
        updatedUsuario.setTelefono(usuarioUpdateRequestDTO.getTelefono());
        updatedUsuario.setDireccion(usuarioUpdateRequestDTO.getDireccion());
        updatedUsuario.setFechaNacimiento(usuarioUpdateRequestDTO.getFechaNacimiento());

        userRepo.save(updatedUsuario);
        return userMapper.toUsuarioResponse(updatedUsuario);
    }

    @Override
    public void changePassword(Authentication authentication, PasswordRequestDTO passwordRequestDTO) {
        Usuario user = findByUsername(authentication.getName());

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(passwordRequestDTO.currentPassword(), user.getPassword())){
            throw  new IllegalArgumentException("La contraseña actual es incorrecta");
        }

        if(passwordRequestDTO.currentPassword().equals(passwordRequestDTO.newPassword())){
            throw new IllegalArgumentException("La nueva contraseña no puede ser igual a la actual");
        }
        user.setPassword(encriptPassword(passwordRequestDTO.newPassword()));
        userRepo.save(user);
    }

    private Usuario findUsuario(String id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
