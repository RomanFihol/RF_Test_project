package lbx.org.qa.test;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.baseUrl;


public class BaseTest {

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        File screenshot = Screenshots.takeScreenShotAsFile();
        if (screenshot != null) {
            try {
                return FileUtils.readFileToByteArray(screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    @Attachment(value = "Current URL", type = "text/plain")
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @BeforeClass
    public void defineBaseUrl() {
        baseUrl = System.getProperty("baseUrl");
    }



    @AfterClass
    public void closeDriver() {
        Selenide.closeWebDriver();
    }
}




