package com.jsd.api.restapigroovy;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.containsString;

public class Specs {

    public static RequestSpecification request = with()
            .baseUri("https://reqres.in/")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

/*
    public static ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("success"))
            .build();
*/
}
