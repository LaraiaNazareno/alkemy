package com.example.alktest.auth.controller;


import com.example.alktest.auth.dto.AuthenticationRequest;
import com.example.alktest.auth.dto.AuthenticationResponse;
import com.example.alktest.auth.dto.UserDTO;
import com.example.alktest.auth.service.UserDetailsCustomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    private UserDetailsCustomServiceImpl userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UserDTO user) throws Exception {
        this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authRequest) throws Exception {


       AuthenticationResponse authRes = new AuthenticationResponse(this.userDetailsService.createToken(authRequest));

           //    this.userDetailsService.createToken(authRequest);

        return ResponseEntity.ok().body(new AuthenticationResponse(authRes.getJwt()));
    }
}
