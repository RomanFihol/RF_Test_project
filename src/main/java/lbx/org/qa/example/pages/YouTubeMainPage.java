package lbx.org.qa.example.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YouTubeMainPage extends BasePage {

    private final SelenideElement youTubeCookies = $x("//span[contains(text(),'Reject all')]");
    private final SelenideElement youTubeCookiesWindow = $("#dialog");

    @Step(value = "Reject cookies before using YouTube")
    public YouTubeMainPage rejectYoutubeCookies() {
        if (youTubeCookiesWindow.isDisplayed()) {
            youTubeCookies.click(ClickOptions.usingJavaScript());
        }
        return this;
    }
}
