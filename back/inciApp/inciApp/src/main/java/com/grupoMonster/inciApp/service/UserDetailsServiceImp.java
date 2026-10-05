package com.grupoMonster.inciApp.service;

import com.grupoMonster.inciApp.dto.AuthLoginRequestDTO;
import com.grupoMonster.inciApp.dto.AuthResponseDTO;
import com.grupoMonster.inciApp.model.Usuario;
import com.grupoMonster.inciApp.repository.IUsuarioRepository;
import com.grupoMonster.inciApp.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepo.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + "was not found"));

        List<GrantedAuthority> authorityList = new ArrayList<>();

        usuario.getRolesList()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority(("ROLE_".concat(role.getRole())))));

        usuario.getRolesList().stream()
                .flatMap(role -> role.getPermissionsList().stream())
                .forEach(permission -> authorityList.add((new SimpleGrantedAuthority(permission.getPermission()))));

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                usuario.isEnabled(),
                usuario.isAccountNotExpired(),
                usuario.isAccountNotLocked(),
                usuario.isCredentialNotExpired(),
                authorityList);
    }

    public AuthResponseDTO loginUser(AuthLoginRequestDTO authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.autheticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtils.createToken(authentication);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(username, "login ok", accessToken, true);
        return  authResponseDTO;
    }

    public Authentication autheticate (String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if(userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }
}
