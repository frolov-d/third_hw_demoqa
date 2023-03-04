package com.jsd.page_object_registartion_form;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
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
    }
}