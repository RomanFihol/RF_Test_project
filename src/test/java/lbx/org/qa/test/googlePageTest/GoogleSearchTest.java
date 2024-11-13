package lbx.org.qa.test.googlePageTest;

import io.qameta.allure.Step;
import lbx.org.qa.test.BaseTest;
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

    private final String testValue = "Youtube";
    private final String expectedUrl = "https://www.youtube.com/";


    @DataProvider(name = "dates of birth")
    public static Object[][] birthDatesProvider() {
        return new Object[][]{
                {"01-31-1990"}, // wrong format
                {"06-11-2005"}, // valid data
                {"14-11-2006"}, // one day less than 18
                {"12-11-2006"}, // one day more than 18
                {"01-01-2123"}, // future date
                {"13-11-2006"} // 18 ages
        };
    }

    @Test(dataProvider = "dates of birth", description = "Check age before open URL")
    public void testAge(String birthDate) {
        if (dateUtils.checkAge(dateUtils.calculateAge(birthDate))) {
            googleSearch.openBaseUrl();  // open google.com
            googleSearch.rejectAllCookies(); // reject cookies if visible
            googleSearch.inputValue(testValue); // put the text to search field
            searchResultsPage.clickFirstElement(); // click on the first element from search results
            compareURLs(); // Compare current and expected URLs
        }
    }

    @Step("Compare current and expected URLs")
    public void compareURLs() {
        assertEquals(getCurrentUrl(), expectedUrl);
    }
}


