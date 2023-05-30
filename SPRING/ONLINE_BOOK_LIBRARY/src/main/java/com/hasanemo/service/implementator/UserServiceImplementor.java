package com.hasanemo.service.implementator;

import com.hasanemo.config.JwtService;
import com.hasanemo.entity.Role;
import com.hasanemo.entity.User;
import com.hasanemo.model.AuthenticationResponse;
import com.hasanemo.model.LoginRequestModel;
import com.hasanemo.model.RegisterRequestModel;
import com.hasanemo.repository.RoleRepository;
import com.hasanemo.repository.UserRepository;
import com.hasanemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementor implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    @Override
    public AuthenticationResponse register(RegisterRequestModel registerRequestModel) {

        List<String> rolesToBeConverted = registerRequestModel.getRoleList();
        List<Role> convertedRole = new ArrayList<>();

        for (String roleName : rolesToBeConverted) {
            Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);
            if (roleOptional.isPresent()) {
                Role roleObj = roleOptional.get();
                convertedRole.add(roleObj);
            }
        }

        User user = User.builder()
                .email(registerRequestModel
                        .getEmail()).firstName(registerRequestModel.getFirstName()).lastName(registerRequestModel.getLastName()).address(registerRequestModel.getAddress()).password(passwordEncoder.encode(registerRequestModel.getPassword())).roles(convertedRole).build();
        userRepository.save(user);
        return AuthenticationResponse.builder().token(jwtService.generateToken(user)).build();
    }

    public AuthenticationResponse login(LoginRequestModel loginRequestModel) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequestModel.getEmail(),
                        loginRequestModel.getPassword()
                )
        );
        User user = userRepository.findByEmail(loginRequestModel.getEmail());
        userRepository.save(user);
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

}
