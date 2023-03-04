package com.jsd.page_object_registartion_form.pages;

import com.codeborne.selenide.SelenideElement;
import com.jsd.page_object_registartion_form.components.CalendarComponent;
import com.jsd.page_object_registartion_form.components.ConfirmationForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ConfirmationForm confirmationForm = new ConfirmationForm();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userGenderInput =  $("#genterWrapper");
    private final SelenideElement userNumberInput =  $("#userNumber");
    private final SelenideElement userBirthDateInput =  $("#dateOfBirthInput");
    private final SelenideElement userSubjectsInput =   $("#subjectsInput");
    private final SelenideElement userHobbyInput = $("#hobbiesWrapper");
    private final SelenideElement userPictureUpload = $("#uploadPicture");
    private final SelenideElement userCurrentAddressInput = $("#currentAddress");
    private final SelenideElement userState = $("#state");
    private final SelenideElement userCity = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton =  $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserMobileNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month,String year) {
        userBirthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setUserHobby(String value) {
        userHobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserPicture(String value) {
        userPictureUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserStateAndCity(String state, String city) {
        userState.click();
        stateCityWrapper.$(byText(state)).click();
        userCity.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public RegistrationPage verifyResult(String key, String value) {
        confirmationForm.verifySubmissionDetails(key, value);
        return this;
    }
}
