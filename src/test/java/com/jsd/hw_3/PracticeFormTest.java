package com.jsd.hw_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("F");
        $("#lastName").setValue("D");
        $("#userEmail").setValue("test@test.com");
//        $(By.cssSelector("label[for='gender-radio-1']")).click();
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__month-select").selectOption("October");
//        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__year-select").selectOption("1990");
//        $(By.cssSelector("div.react-datepicker__day[aria-label='Choose Wednesday, October 31st, 1990']")).click();
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("M").pressEnter();
//        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

//        File fileToUpload = new File("src/test/resources/pictures/photo_2023-02-16_19-03-31.jp");
//        $("#uploadPicture").uploadFile(fileToUpload);
        $("#uploadPicture").uploadFromClasspath("pictures/photo_2023-02-16_19-03-31.jpg");

        $("#currentAddress").setValue("planet Earth");
        $("#state").click();
//        $("#react-select-3-option-0").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
//        $("#react-select-4-option-0").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(exactText("F D"));
        $("table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(exactText("test@test.com"));
        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(exactText("Male"));
        $("table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(exactText("0123456789"));
        $("table tbody tr:nth-child(5) td:nth-child(2)").shouldHave(exactText("31 October,1990"));
        $("table tbody tr:nth-child(6) td:nth-child(2)").shouldHave(exactText("Maths"));
        $("table tbody tr:nth-child(7) td:nth-child(2)").shouldHave(exactText("Sports, Reading, Music"));
        $("table tbody tr:nth-child(8) td:nth-child(2)").shouldHave(exactText("photo_2023-02-16_19-03-31.jpg"));
        $("table tbody tr:nth-child(9) td:nth-child(2)").shouldHave(exactText("planet Earth"));
        $("table tbody tr:nth-child(10) td:nth-child(2)").shouldHave(exactText("NCR Delhi"));

    }
}