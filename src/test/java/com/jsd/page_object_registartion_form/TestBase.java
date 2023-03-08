package com.jsd.page_object_registartion_form;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.jsd.page_object_registartion_form.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
