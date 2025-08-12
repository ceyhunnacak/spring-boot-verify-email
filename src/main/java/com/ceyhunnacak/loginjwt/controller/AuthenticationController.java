package com.ceyhunnacak.loginjwt.controller;

import com.ceyhunnacak.loginjwt.dto.LoginUserDto;
import com.ceyhunnacak.loginjwt.dto.RegisterUserDto;
import com.ceyhunnacak.loginjwt.dto.VerifyUserDto;
import com.ceyhunnacak.loginjwt.model.User;
import com.ceyhunnacak.loginjwt.responses.LoginResponse;
import com.ceyhunnacak.loginjwt.service.AuthenticationService;
import com.ceyhunnacak.loginjwt.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) throws AuthenticationException {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwt = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwt, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody VerifyUserDto verifyUserDto) throws AuthenticationException {
        try {
            authenticationService.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resend(@RequestParam String email) throws AuthenticationException {
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code resend successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
