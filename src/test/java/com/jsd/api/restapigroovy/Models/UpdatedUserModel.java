package com.jsd.api.restapigroovy.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedUserModel {

    private String name;
    private String job;
}
