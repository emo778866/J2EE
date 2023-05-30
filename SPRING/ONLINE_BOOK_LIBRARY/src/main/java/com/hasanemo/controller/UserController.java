package com.hasanemo.controller;


import com.hasanemo.model.AuthenticationResponse;
import com.hasanemo.model.LoginRequestModel;
import com.hasanemo.model.RegisterRequestModel;
import com.hasanemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequestModel registerRequestModel) {
        return ResponseEntity.ok(userService.register(registerRequestModel));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestModel loginRequestModel) {
        return ResponseEntity.ok(userService.login(loginRequestModel));
    }

}

