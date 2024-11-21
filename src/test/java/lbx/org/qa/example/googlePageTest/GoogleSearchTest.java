package lbx.org.qa.example.googlePageTest;

import io.qameta.allure.Step;
import lbx.org.qa.example.BaseTest;
import lbx.org.qa.example.exceptions.UnderAgeException;
import lbx.org.qa.example.pages.GoogleSearch;
import lbx.org.qa.example.pages.SearchResultsPage;
import lbx.org.qa.example.pages.YouTubeMainPage;
import lbx.org.qa.example.utils.DateUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleSearchTest extends BaseTest {

    private final String testValue = "Youtube";
    private final String expectedUrl = "https://www.youtube.com/";

    @DataProvider(name = "dates of birth")
    public static Object[][] birthDatesProvider() {
        return new Object[][]{
                {"1990-21-12"},  // wrong format
                {DateUtils.getDate20YearsAgo()},  // valid data
                {DateUtils.getFutureDate()},  // future date
                {DateUtils.getAgeMoreThan18()},  // one day more than 18
                {DateUtils.getAgeEqual18()},  // 18 ages
                {DateUtils.getAgeLessThan18()}  // one day less than 18
        };
    }

    @Step
    public boolean checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Birthday can not be negative");
        } else if (age < 18) {
            throw new UnderAgeException("Your age is less then 18");
        } else {
            return true;
        }
    }

    @Step("Validate age")
    public boolean validateAge(String birthDay) {
        DateUtils dateUtils = new DateUtils();
        return checkAge(dateUtils.calculateAge(birthDay));
    }

    @Test(dataProvider = "dates of birth", description = "Check age before open URL")
    public void testAge(String birthDate) {
        if (validateAge(birthDate)) {
            new GoogleSearch()
                    .rejectGoogleCookies()  //  reject cookies if visible
                    .inputValue(testValue);  //  put the text to search field
            new SearchResultsPage()
                    .clickFirstElement();  // click on the first element from search results
            YouTubeMainPage youTubeMainPage = new YouTubeMainPage();
            youTubeMainPage.rejectYoutubeCookies();  // reject cookies on the main YouTube page
            assertEquals(youTubeMainPage.getCurrentUrl(), expectedUrl);  // Compare current and expected URLs
        }
    }
}
