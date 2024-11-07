package google.example.test;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.DateUtils.calculateAge;

public class GoogleSearchTest extends BaseTest {

    private final String testValue = "Youtube";
    private final String expectedUrl = "https://www.youtube.com/";
    String a = "21-04-1991";

    @DataProvider(name = "dates of birth")
    public static Object[][] birthDatesProvider() {
        return new Object[][]{
                {"01-31-1990"}, // wrong format
                {"06-11-2005"}, // valid data
                {"08-11-2006"}, // one day less than 18
                {"06-11-2006"}, // one day more than 18
                {"01-01-2123"}  // future date
        };
    }

    @Test(dataProvider = "dates of birth", description = "Check age before open URL")
    public void testAge(String birthDate) {
        if (calculateAge(birthDate) < 18) {
            throw new SkipException("The URL cannot be opened because you are under 18 years of age.");
        } else {
            openBaseUrl()   // open google.com
                    .rejectAllCookies() // reject cookies if visible
                    .inputValue(testValue)  // put the text to search field
                    .clickTheFirstElement(); // click on the first element from search results
            Assert.assertEquals(getCurrentUrl(), expectedUrl);
        }
    }
}
