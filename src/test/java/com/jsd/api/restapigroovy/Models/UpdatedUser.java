package com.jsd.api.restapigroovy.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedUser {

    private String name;
    private String job;

//    for some mysterious reason Lombok didn't work
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
