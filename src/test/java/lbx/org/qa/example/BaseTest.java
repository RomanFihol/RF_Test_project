package lbx.org.qa.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.baseUrl;


public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = System.getProperty("browser");
        baseUrl = System.getProperty("baseUrl");
    }

    @BeforeMethod
    public void openPage() {
        Selenide.open(baseUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.webdriver().driver().close();
    }
}
