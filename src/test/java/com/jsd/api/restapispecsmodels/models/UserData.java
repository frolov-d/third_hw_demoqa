package com.jsd.api.restapispecsmodels.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

    @JsonProperty("data")
    private UserModel userModel;
}
