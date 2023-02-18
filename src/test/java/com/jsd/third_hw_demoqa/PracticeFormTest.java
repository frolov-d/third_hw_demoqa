package com.jsd.third_hw_demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @Test
    void initialTest() {
        System.out.println("Initial test");
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
//        executeJavaScript("document.body.style.zoom='80%'");
//        $("[id=firstName]").setValue("F");
//        id = #, class = .
        $("#firstName").setValue("F");
        $("#lastName").setValue("D");
        $(By.cssSelector("label[for='gender-radio-1']")).click();
        $("#userNumber").setValue("0123456789");
//        $(By.id("submit")).hover();
        $("#submit").click();
    }
}
