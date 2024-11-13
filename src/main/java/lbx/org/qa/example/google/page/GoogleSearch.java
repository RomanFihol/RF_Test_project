package lbx.org.qa.example.google.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {

    private final SelenideElement searchFiled = $("#APjFqb");
    private final SelenideElement rejectCookies = $("#W0wltc");
    private final SelenideElement cookiesWindow = $("#CXQnmb");


    @Step
    public void openBaseUrl() {
        open(Configuration.baseUrl);
        new GoogleSearch();
    }

    @Step("Reject cookies if visible")
    public void rejectAllCookies() {
        if (cookiesWindow.isDisplayed()) {
            rejectCookies.shouldBe(Condition.interactable).click();
        }
    }

    @Step("Put the value into the search field")
    public void inputValue(String value) {
        searchFiled.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(value).pressEnter();
        new SearchResultsPage();
    }
}
