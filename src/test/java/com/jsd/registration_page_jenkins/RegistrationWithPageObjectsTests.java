package com.jsd.registration_page_jenkins;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("Registration")
public class RegistrationWithPageObjectsTests extends TestBaseExtended {

    @DisplayName("Registration form test with PageObject")
    @Test
    void fillFormTest() {
        step("Fill the form", () -> {
            registrationPage.openPage()
                    .removeBanners()
                    .setFirstName("F")
                    .setLastName("D")
                    .setUserEmail("test@test.com")
                    .setUserGender("Male")
                    .setUserMobileNumber("0123456789")
                    .setBirthDate("31", "October", "1990")
                    .setUserSubjects("M")
                    .setUserHobby("Sports")
                    .setUserPicture("pictures/photo_2023-02-16_19-03-31.jpg")
                    .setUserCurrentAddress("planet Earth")
                    .setUserStateAndCity("NCR", "Delhi")
                    .submitForm();
        });

        step("Verify results", () -> {
            registrationPage.verifyResult("Student Name", "F D")
                    .verifyResult("Student Email", "test@test.com")
                    .verifyResult("Gender", "Male")
                    .verifyResult("Mobile", "0123456789")
                    .verifyResult("Date of Birth", "31 October,1990")
                    .verifyResult("Subjects", "Maths")
                    .verifyResult("Hobbies", "Sports")
                    .verifyResult("Picture", "photo_2023-02-16_19-03-31.jpg")
                    .verifyResult("Address", "planet Earth")
                    .verifyResult("State and City", "NCR Delhi");

        });
    }
}