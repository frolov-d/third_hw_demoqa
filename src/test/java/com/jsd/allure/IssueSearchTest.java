package com.jsd.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueSearchTest {

    private static final String REPOSITORY = "frolov-d/third_hw_demoqa";
    private static final int ISSUE = 1;

    @DisplayName("Test with a pure Selenide (with a Listener)")
    @Owner("Dmitry F")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }

    @DisplayName("Test with Lambda steps")
    @Owner("Dmitry F")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open("https://github.com");
        });
        step("Find the repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Click on the repository link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open the Issues tab", () -> {
            $("#issues-tab").click();
        });
        step("Check for the presence of an Issue with the specified number " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @DisplayName("Test with the @Step annotation")
    @Owner("Dmitry F")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}
