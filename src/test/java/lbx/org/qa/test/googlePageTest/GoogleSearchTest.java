package lbx.org.qa.test.googlePageTest;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lbx.org.qa.example.google.page.YouTubeMainPage;
import lbx.org.qa.test.BaseTest;
import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lbx.org.qa.example.google.page.GoogleSearch;
import lbx.org.qa.example.google.page.SearchResultsPage;
import lbx.org.qa.example.utils.DateUtils;

import static org.testng.Assert.assertEquals;


public class GoogleSearchTest extends BaseTest {

    DateUtils dateUtils = new DateUtils();
    GoogleSearch googleSearch = new GoogleSearch();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    YouTubeMainPage youTubeMainPage = new YouTubeMainPage();

    private final String testValue = "Youtube";
    private final String expectedUrl = "https://www.youtube.com/";


    @DataProvider(name = "dates of birth")
    public static Object[][] birthDatesProvider() {
        return new Object[][]{
                {"01-31-1990"}, // wrong format
                {"06-11-2005"}, // valid data
                {"19-11-2006"}, // one day less than 18
                {"17-11-2006"}, // one day more than 18
                {"01-01-2123"}, // future date
                {"18-11-2006"}  // 18 ages
        };
    }

    @Step("Validate age")
    public Boolean validateAge(String birthDay) {
        Boolean ageIscorrect = dateUtils.checkAge(dateUtils.calculateAge(birthDay));
        return ageIscorrect;
    }

    @Step("Compare current and expected URLs")
    public void compareURLs() {
        try {
            assertEquals(getCurrentUrl(), expectedUrl);
        } catch (AssertionError e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test(dataProvider = "dates of birth", description = "Check age before open URL")
    public void testAge(String birthDate) {
        if (validateAge(birthDate)) {
            googleSearch.openBaseUrl();  // open google.com
            googleSearch.rejectGoogleCookies(); // reject cookies if visible
            googleSearch.inputValue(testValue); // put the text to search field
            searchResultsPage.clickFirstElement(); // click on the first element from search results
            youTubeMainPage.rejectYoutubeCookies();  // reject cookies on the main YouTube page
            compareURLs();  // Compare current and expected URLs
        }
    }
}


