package com.grupoMonster.inciApp.controller;

import com.grupoMonster.inciApp.dto.AuthLoginRequestDTO;
import com.grupoMonster.inciApp.service.UserDetailsServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthenticationController {
    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthLoginRequestDTO userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }


}
