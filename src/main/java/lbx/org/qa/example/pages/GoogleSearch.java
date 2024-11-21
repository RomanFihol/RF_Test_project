package lbx.org.qa.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearch extends BasePage {

    private final SelenideElement searchFiled = $("#APjFqb");
    private final SelenideElement rejectCookies = $("#W0wltc");
    private final SelenideElement cookiesWindow = $("#CXQnmb");

    @Step("Reject cookies if visible")
    public GoogleSearch rejectGoogleCookies() {
        if (cookiesWindow.isDisplayed()) {
            rejectCookies.shouldBe(Condition.interactable).click();
        }
        return this;
    }

    @Step("Put the value '{value}' into the search field")
    public GoogleSearch inputValue(String value) {
        searchFiled.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(value).pressEnter();
        return this;
    }
}
