package google.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private final ElementsCollection searchResultsList = $$("h3.LC20lb.MBeuO.DKV0Md");
    @Step("Click on the first element in the list of search results")
    public void clickTheFirstElement() {
        searchResultsList.first().click();
    }
}
