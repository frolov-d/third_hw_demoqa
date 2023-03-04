package com.jsd.page_object_registartion_form;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("F")
                .setLastName("D")
                .setUserEmailInput("test@test.com")
                .setUserGenderInput("Male")
                .setUserNumberInput("0123456789")
                .setBirthDate("31", "October", "1990")
                .setUserSubjectsInput("M")
                .setUserHobbyInput("Sports")
                .setUserPictureUploadInput("pictures/photo_2023-02-16_19-03-31.jpg")
                .setUserCurrentAddressInput("planet Earth")
                .setUserStateAndCity("NCR", "Delhi")
                .submitForm();

        confirmationPage.verifySubmissionDetails("F D", "test@test.com", "Male",
                "0123456789", "31 October,1990", "Maths", "Sports",
                "photo_2023-02-16_19-03-31.jpg", "planet Earth", "NCR Delhi");
    }
}