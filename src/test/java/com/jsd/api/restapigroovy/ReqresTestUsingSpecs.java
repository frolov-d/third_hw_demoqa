package com.jsd.api.restapigroovy;

import com.jsd.api.restapigroovy.Models.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jsd.api.restapigroovy.Specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresTestUsingSpecs {

    @Test
    void userDataArraySizeTest() {
        UserResponseData data = given()
                .spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .spec(response)
                .log().body()
                .extract().as(UserResponseData.class);

        List<UserModel> userModelList = data.getData();
        assertEquals(6, userModelList.size());
    }

    @Test
    void updateUserTest() {
        UpdatedUserModel updatedUser = new UpdatedUserModel();
        updatedUser.setName("morpheus");
        updatedUser.setJob("zion resident");

        UpdatedUserModel data = given()
                .spec(request)
                .when()
                .body(updatedUser)
                .put("/users/2")
                .then()
                .spec(response)
                .log().body()
                .extract().as(UpdatedUserModel.class);

        assertEquals("morpheus", data.getName());
        assertEquals("zion resident", data.getJob());
    }

    @Test
    void deleteUserTest() {
        given()
                .spec(request)
                .when()
                .delete("/users/2")
                .then()
                .spec(responseDelete)
                .log().body()
                .statusCode(204);
    }

    @Test
    void loginWithIncorrectEmailTest() {
        LoginBodyModel loginBody = new LoginBodyModel();
        loginBody.setEmail("incorrect@reqres.in");
        loginBody.setPassword("cityslicka");

        BadRequestModel badRequestResponse = given()
                .spec(request)
                .when()
                .body(loginBody)
                .post("/login")
                .then()
                .spec(responseWrongEmail)
                .log().body()
                .extract().as(BadRequestModel.class);

        assertEquals("user not found", badRequestResponse.getError());
    }

    @Test
    public void checkSingleLastNameUsingGroovy() {
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .spec(response)
                .log().body()
                .body("data.findAll{it.last_name =~/./}.last_name.flatten()",
                        hasItem("Bluth"));
    }
}