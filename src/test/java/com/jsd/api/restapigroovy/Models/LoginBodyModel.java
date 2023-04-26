package com.jsd.api.restapigroovy.Models;

import lombok.Data;

@Data
public class LoginBodyModel {
    private String email;
    private String password;
}