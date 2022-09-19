package com.textileValley.authentication.controller;

import com.textileValley.authentication.entity.AuthenticationEntity;
import com.textileValley.authentication.util.AuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationUtil authenticationUtil;
    @PostMapping("/validate")
    public String generateToken(@RequestBody AuthenticationEntity authRequest) throws Exception {
        return "fgf";
    }
}
