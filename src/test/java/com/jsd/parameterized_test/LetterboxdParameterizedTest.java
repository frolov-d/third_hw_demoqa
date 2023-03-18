package com.jsd.parameterized_test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LetterboxdParameterizedTest {

    @BeforeEach
    void setup() {
        Selenide.open("https://letterboxd.com/");
    }

    @CsvSource(value = {
            "The Godfather,        Found at least 250 matches for “The Godfather”",
            "Белое солнце пустыни, Found 1 match for “Белое солнце пустыни”"
    })
    @ParameterizedTest(name = "Searching for {0} should return {1}")
    @Tag("WEB")
    void searchShouldReturnMatchingText(String testData, String expectedText) {
        $("#search-q").setValue(testData).pressEnter();
        $("#content").shouldHave(Condition.text(expectedText));
    }

    @ValueSource(strings = {
            "Alien", "Gladiator"
    })
    @ParameterizedTest(name = "Searching for {0} should return more than 10 results")
    @Tag("WEB")
    void searchResultsShouldBeGreaterThan10(String testData) {
        $("#search-q").setValue(testData).pressEnter();
        $$("ul.results li").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @CsvFileSource(resources = "/testdata/firstSearchResultsShouldContainExpectedText.csv")
    @ParameterizedTest(name = "Searching for {0} should return {1}")
    @Tag("WEB")
    void firstSearchResultsShouldContainExpectedText(String testData, String expectedText) {
        $("#search-q").setValue(testData).pressEnter();
        $("span.film-title-wrapper a").shouldHave(Condition.text(expectedText));
    }

    static Stream<Arguments> firstSearchResultShouldContainTheExactDirector() {
        return Stream.of(
                Arguments.of("Midsommar", "Ari Aster"),
                Arguments.of("Hardcore Henry", "Ilya Naishuller")
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "Searching for {0} should return {1} as a director")
    @Tag("WEB")
    void firstSearchResultShouldContainTheExactDirector(String testData, String expectedText) {
        $("#search-q").setValue(testData).pressEnter();
        $("p.film-metadata a").shouldHave(Condition.text(expectedText));
    }
}
