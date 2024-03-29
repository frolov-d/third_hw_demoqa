package com.jsd.registration_page_jenkins;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.jsd.page_object_registartion_form.utils.RandomUtils.getRandomCity;
import static com.jsd.page_object_registartion_form.utils.RandomUtils.getRandomValue;
import static com.jsd.page_object_registartion_form.utils.TestData.*;
import static io.qameta.allure.Allure.step;

@Tag("Registration")
public class RegistrationWithFakerTests extends TestBaseExtended {

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = getRandomValue(GENDER);
    String userMobileNumber = faker.phoneNumber().subscriberNumber(10);
    String userDayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    String userMonthOfBirth = getRandomValue(MONTHS);
    String userYearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2100));
    String userSubjects = getRandomValue(SUBJECTS);
    String userHobby = getRandomValue(HOBBIES);
    String userPicture = "pictures/photo_2023-02-16_19-03-31.jpg";
    String userAddress = faker.address().fullAddress();
    String userState = getRandomValue(STATES);
    String userCity = getRandomCity(userState);

    @DisplayName("Registration form test with PageObject with Faker")
    @Test
    void fillFormTest() {
        step("Fill the form", () -> {
            registrationPage.openPage()
                    .removeBanners()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setUserGender(userGender)
                    .setUserMobileNumber(userMobileNumber)
                    .setBirthDate(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                    .setUserSubjects(userSubjects)
                    .setUserHobby(userHobby)
                    .setUserPicture(userPicture)
                    .setUserCurrentAddress(userAddress)
                    .setUserStateAndCity(userState, userCity)
                    .submitForm();
        });

        step("Verify results", () -> {
            registrationPage.verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", userGender)
                    .verifyResult("Mobile", userMobileNumber)
                    .verifyResult("Date of Birth", userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                    .verifyResult("Subjects", userSubjects)
                    .verifyResult("Hobbies", userHobby)
                    .verifyResult("Picture", userPicture.substring("pictures/".length()))
                    .verifyResult("Address", userAddress)
                    .verifyResult("State and City", userState + " " + userCity);
        });
    }
}