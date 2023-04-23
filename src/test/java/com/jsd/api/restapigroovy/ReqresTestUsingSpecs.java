package com.jsd.api.restapigroovy;

import com.jsd.api.restapigroovy.Models.UpdatedUser;
import com.jsd.api.restapigroovy.Models.UserData;
import com.jsd.api.restapigroovy.Models.UserResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsd.api.restapigroovy.Specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresTestUsingSpecs {

    @Test
    void dataArraySizeTest() {

        UserResponse data = given()
                .spec(request)
                .when()
                .get("/users?page=2")
                .then()
                .extract().as(UserResponse.class);

        List<UserData> userList = data.getData();
        assertEquals(6, userList.size());
    }

    @Test
    void updateUserTest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");

        UpdatedUser data = given()
                .spec(request)
                .when()
                .body(requestBody)
                .put("/users/2")
                .then()
                .statusCode(200)
                .extract().as(UpdatedUser.class);

        assertEquals("morpheus", data.getName());
        assertEquals("zion resident", data.getJob());
    }

    @Test
    void testDataArrayContainsColorsTest() {
        List<String> expectedColors = Arrays.asList("cerulean", "fuchsia rose", "true red",
                "aqua sky", "tigerlily", "blue turquoise");

        request
                .when()
                .get("/unknown")
                .then()
                .body("data.name", hasItems(expectedColors.toArray()));
    }
}
