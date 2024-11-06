package google.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {

    private final SelenideElement searchFiled = $("#APjFqb");
    private final SelenideElement rejectCookies = $("#W0wltc");
    private final SelenideElement cookiesWindow = $("#CXQnmb");
    private final SelenideElement youTubeButton = $x("//div[@class='wM6W7d']/span[contains(text(), 'YouTube')]");

    @Step("Reject cookies if visible")
    public GoogleSearch rejectAllCookies() {
        if (cookiesWindow.isDisplayed()) {
            rejectCookies.shouldBe(Condition.interactable).click();
            return this;
        }
        return null;
    }

    @Step("Put the value into the search field")
    public SearchResultsPage inputValue(String value) {
        searchFiled.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue(value).pressEnter();
        return page(SearchResultsPage.class);
    }
}
