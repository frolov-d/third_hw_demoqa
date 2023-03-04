package com.jsd.page_object_registartion_form.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {

    private SelenideElement modalHeader = $(".modal-header");
    private SelenideElement firstNameLastNameRow = $("table tbody tr:nth-child(1) td:nth-child(2)");
    private SelenideElement emailRow = $("table tbody tr:nth-child(2) td:nth-child(2)");
    private SelenideElement genderRow = $("table tbody tr:nth-child(3) td:nth-child(2)");
    private SelenideElement mobileRow = $("table tbody tr:nth-child(4) td:nth-child(2)");
    private SelenideElement dobRow = $("table tbody tr:nth-child(5) td:nth-child(2)");
    private SelenideElement subjectsRow = $("table tbody tr:nth-child(6) td:nth-child(2)");
    private SelenideElement hobbiesRow = $("table tbody tr:nth-child(7) td:nth-child(2)");
    private SelenideElement uploadedPictureRow = $("table tbody tr:nth-child(8) td:nth-child(2)");
    private SelenideElement currentAddressRow = $("table tbody tr:nth-child(9) td:nth-child(2)");
    private SelenideElement stateAndCityRow = $("table tbody tr:nth-child(10) td:nth-child(2)");

    public void verifySubmissionDetails(String firstNameLastName, String email, String gender, String mobile,
                                        String dob, String subjects, String hobbies, String uploadedPicture,
                                        String currentAddress, String stateAndCity) {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        firstNameLastNameRow.shouldHave(exactText(firstNameLastName));
        emailRow.shouldHave(exactText(email));
        genderRow.shouldHave(exactText(gender));
        mobileRow.shouldHave(exactText(mobile));
        dobRow.shouldHave(exactText(dob));
        subjectsRow.shouldHave(exactText(subjects));
        hobbiesRow.shouldHave(exactText(hobbies));
        uploadedPictureRow.shouldHave(exactText(uploadedPicture));
        currentAddressRow.shouldHave(exactText(currentAddress));
        stateAndCityRow.shouldHave(exactText(stateAndCity));
    }
}
