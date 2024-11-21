package lbx.org.qa.example.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private final ElementsCollection searchResultsList = $$("h3.LC20lb.MBeuO.DKV0Md");

    @Step("Click on the first element in the list of search results")
    public SearchResultsPage clickFirstElement() {   // This method clicks on the first element from the search list
        searchResultsList.first().click();
        return this;
    }
}
