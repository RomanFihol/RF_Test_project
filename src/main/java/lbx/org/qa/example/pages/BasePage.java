package lbx.org.qa.example.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;

public class BasePage {
    @Attachment(value = "Current URL", type = "text/plain")
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
