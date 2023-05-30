package com.bjitacademy.securityModule.service.impl;

import com.bjitacademy.securityModule.entity.UserEntity;
import com.bjitacademy.securityModule.model.UserRequestModel;
import com.bjitacademy.securityModule.repository.UserRepository;
import com.bjitacademy.securityModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(requestModel.getPassword())
                .build();
        userRepository.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
        // return hidePassword(requestModel);
    }

//    public ResponseEntity<Object> hidePassword(UserRequestModel requestModel) {
//        UserEntity userEntity = UserEntity.builder()
//                .email(requestModel.getEmail())
//                .userName(requestModel.getUserName())
//                .firstName(requestModel.getFirstName())
//                .lastName(requestModel.getLastName())
//                .build();
//        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
//    }

}
