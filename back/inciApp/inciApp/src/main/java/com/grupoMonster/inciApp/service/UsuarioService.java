package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.dto.response.UsuarioResponseDTO;
import com.grupoMonster.inciApp.mapper.IUserMapper;
import com.grupoMonster.inciApp.model.*;
import com.grupoMonster.inciApp.repository.IUsuarioRepository;
import com.grupoMonster.inciApp.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        Usuario user = new Usuario();

        //Se asigna automaticamente el rol user a todos los usuarios nuevos, solo los admin pueden cambiar el rol
        Role defaultRole = roleService.findByName(DEFAULT_ROLE)
                .orElseThrow(()-> new RuntimeException("No existe el rol por defecto " + DEFAULT_ROLE));

        Provincia provincia = provinciaService.findProvincia(userDTO.getIdProvincia());
        Departamento departamento = departamentoService.findDepartamento(userDTO.getIdDepartamento());
        Localidad localidad = localidadService.findLocalidad(userDTO.getIdLocalidad());


        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encriptPassword(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setDni(userDTO.getDni());
        user.setTelefono(userDTO.getTelefono());
        user.setDireccion(userDTO.getDireccion());
        user.setFechaNacimiento(userDTO.getFechaNacimiento());
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
        return  userRepo.findUserEntityByUsername(username)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

    }

    private Usuario findUsuario(String id) {
        return userRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Usuario no encontrado"));
    }
}
