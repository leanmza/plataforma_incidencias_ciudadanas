package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.request.UsuarioRequestDTO;
import com.grupoMonster.inciApp.dto.request.UsuarioUpdateRequestDTO;
import com.grupoMonster.inciApp.model.Role;
import com.grupoMonster.inciApp.model.Usuario;
import com.grupoMonster.inciApp.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService implements IUsuarioService {

    private static final String DEFAULT_ROLE = "USER";

    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    private IRoleService roleService;


    @Override
    public List<Usuario> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Usuario save(UsuarioRequestDTO userDTO) {
        Usuario user = new Usuario();

        //Se asigna automaticamente el rol user a todos los usuarios nuevos, solo los admin pueden cambiar el rol
        Role defaultRole = roleService.findByName(DEFAULT_ROLE)
                .orElseThrow(()-> new RuntimeException("No existe el rol por defecto " + DEFAULT_ROLE));

        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encriptPassword(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setDni(userDTO.getDni());
        user.setTelefono(userDTO.getTelefono());
        user.setDireccion(userDTO.getDireccion());
        user.setFechaNacimiento(userDTO.getFechaNacimiento());
        /*
        user.setLocalidad //todo hacer entidad, repo, service, controller
        user.setDepartamento //todo hacer entidad, repo, service, controller
        user.setProvincia //todo hacer entidad, repo, service, controller
         */

        user.setRolesList(new HashSet<>(Set.of(defaultRole)));
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setAccountNotLocked(true);
        user.setCredentialNotExpired(true);

        return userRepo.save(user);
    }

    @Override
    public Usuario update(String id, UsuarioUpdateRequestDTO userDTO) {
        Usuario updatedUser = findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));


        updatedUser.setName(userDTO.getName());
        updatedUser.setLastname(userDTO.getLastname());
        if (!userDTO.getPassword().isBlank() || userDTO.getPassword().isEmpty()) {
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
        return userRepo.save(updatedUser);
    }

    //Se va a hacer un soft delete (lógico), se cambia isEnabled a false
    @Override
    public Usuario delete(String id) {
        Usuario deletedUser = findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        deletedUser.setEnabled(false);

        return userRepo.save(deletedUser);

    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
