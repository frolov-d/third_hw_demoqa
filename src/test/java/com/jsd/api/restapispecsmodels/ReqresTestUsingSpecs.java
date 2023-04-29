package com.jsd.api.restapispecsmodels;

import com.jsd.api.restapispecsmodels.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;


import static com.jsd.api.restapispecsmodels.Specs.*;
import static com.jsd.api.restapispecsmodels.helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("restapi")
public class ReqresTestUsingSpecs {

    @Test
    @DisplayName("Checking that the Data array has 6 elements")
    void userDataArraySizeTest() {
        UserResponseData data = step("Make request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(request)
                        .when()
                        .get("/users?page=2")
                        .then()
                        .spec(response)
                        .log().body()
                        .extract().as(UserResponseData.class));

        List<UserModel> userModelList = data.getData();
        step("Verify response", () -> assertEquals(6, userModelList.size()));
    }

    @Test
    @DisplayName("Update user test")
    void updateUserTest() {
        UpdatedUserModel updatedUser = new UpdatedUserModel();
        updatedUser.setName("morpheus");
        updatedUser.setJob("zion resident");

        UpdatedUserModel data = step("Make request", () ->
                given()
                        .spec(request)
                        .when()
                        .body(updatedUser)
                        .put("/users/2")
                        .then()
                        .spec(response)
                        .log().body()
                        .extract().as(UpdatedUserModel.class));

        step("Verify user's name", () -> assertEquals("morpheus", data.getName()));
        step("Verify user's job", () -> assertEquals("zion resident", data.getJob()));
    }

    @Test
    @DisplayName("Delete user test")
    void deleteUserTest() {
        step("Make request", () ->
                given()
                        .spec(request)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(responseDelete)
                        .log().body()
                        .statusCode(204));
    }

    @Test
    @DisplayName("Negative email test")
    void loginWithIncorrectEmailTest() {
        LoginBodyModel loginBody = new LoginBodyModel();
        loginBody.setEmail("incorrect@reqres.in");
        loginBody.setPassword("cityslicka");

        BadRequestModel badRequestResponse = step("Make request", () ->
                given()
                        .spec(request)
                        .when()
                        .body(loginBody)
                        .post("/login")
                        .then()
                        .spec(responseWrongEmail)
                        .log().body()
                        .extract().as(BadRequestModel.class));

        step("Verify response", () -> assertEquals(
                "user not found", badRequestResponse.getError()));
    }

    @Test
    @DisplayName("Checking single last name using Groovy")
    public void checkSingleLastNameUsingGroovy() {
        step("Make request", () ->
                given()
                        .spec(request)
                        .when()
                        .get("/users")
                        .then()
                        .spec(response)
                        .log().body()
                        .body("data.findAll{it.last_name =~/./}.last_name.flatten()",
                                hasItem("Bluth")));
    }
}