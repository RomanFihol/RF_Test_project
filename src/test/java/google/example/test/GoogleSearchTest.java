package google.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private final String testValue = "Youtube";
    private final String expectedUrl = "https://www.youtube.com/";

    @Test(description = "Open YouTube and compare URLs")
    public void testSearchResult() {
        openBaseUrl()
                .rejectAllCookies()
                .inputValue(testValue)
                .clickTheFirstElement();
        Assert.assertEquals(getCurrentUrl(), expectedUrl);
    }

    @Test(description = "Check age before open URL", enabled = false)
    public void testAge(String birthDate){

    }
}
