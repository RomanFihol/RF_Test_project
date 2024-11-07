package google.example.test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import google.example.GoogleSearch;
import org.testng.annotations.BeforeClass;



public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1240x1200";
        Configuration.baseUrl = "https://www.google.com/";
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public GoogleSearch openBaseUrl() {
        Selenide.open(Configuration.baseUrl);
        return new GoogleSearch();
    }
}


