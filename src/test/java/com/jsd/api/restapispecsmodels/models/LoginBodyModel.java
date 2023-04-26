package com.jsd.api.restapispecsmodels.models;

import lombok.Data;

@Data
public class LoginBodyModel {
    private String email;
    private String password;
}