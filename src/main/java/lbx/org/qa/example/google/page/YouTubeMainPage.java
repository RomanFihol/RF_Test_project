package lbx.org.qa.example.google.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class YouTubeMainPage {

    private final SelenideElement youTubecookies = $x("//span[contains(text(),'Reject all')]");
    private final SelenideElement youTubeCookiesWindow = $("#dialog");

    @Step(value = "Reject cookies before using YouTube")
    public void rejectYoutubeCookies() {
        if (youTubeCookiesWindow.isDisplayed()) {
            Selenide.executeJavaScript("arguments[0].click()", youTubecookies);
        }
    }

}
