package lbx.org.qa.example.utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;

@Slf4j
public class CustomScreenshotListener implements TestLifecycleListener {

    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED) {
            makeScreenshot();
        }
    }

    @Attachment(
            value = "Failure Screenshot",
            type = "image/png"
    )
    private byte[] makeScreenshot() {
        byte[] result = null;
        try {
            result = Selenide.screenshot(OutputType.BYTES);
        } catch (Exception e) {
            log.warn("Screenshot has not been created");
        }
        return result;
    }
}
