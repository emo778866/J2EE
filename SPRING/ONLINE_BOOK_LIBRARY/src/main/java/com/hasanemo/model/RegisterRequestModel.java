package com.hasanemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestModel {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private List<String> roleList;

}
