package com.jsd.api.restapigroovy.models;

import lombok.Data;

@Data
public class LoginBodyModel {
    private String email;
    private String password;
}