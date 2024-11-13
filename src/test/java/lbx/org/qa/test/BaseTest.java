package lbx.org.qa.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lbx.org.qa.example.google.page.GoogleSearch;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

    @Parameters("baseUrl")
    @BeforeClass
    public void setUp(@Optional("https://www.google.com/") String baseUrl) {
        Configuration.baseUrl = baseUrl;
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}


