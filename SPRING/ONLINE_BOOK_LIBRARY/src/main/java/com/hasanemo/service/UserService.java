package com.hasanemo.service;

import com.hasanemo.model.AuthenticationResponse;
import com.hasanemo.model.LoginRequestModel;
import com.hasanemo.model.RegisterRequestModel;

public interface UserService {

    AuthenticationResponse register(RegisterRequestModel registerRequestModel);

    AuthenticationResponse login(LoginRequestModel loginRequestModel);

}
