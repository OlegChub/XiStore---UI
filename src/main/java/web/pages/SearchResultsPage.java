package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchResultsPage extends BasePage {
    private static final By SEARCH_PAGE_TITLE = By.xpath("//h1[contains(text(),'Результаты поиска')]");
    private static final By SEARCH_RESULT_ITEMS = By.className("search__page_item-name");

    public SearchResultsPage checkSearchResultPageIsDisplayed() {
        checkElementIsDisplayed(SEARCH_PAGE_TITLE);
        return this;
    }

    public boolean isQueryPresentInSearchResults(String query) {
        List<String> searchResultItemNames = getSearchResultItemNames();
        for (String itemName : searchResultItemNames) {
            if (itemName.contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private List<WebElement> getSearchResultItems() {
        return findElements(SEARCH_RESULT_ITEMS);
    }

    private List<String> getSearchResultItemNames() {
        List<String> SearchResultItemNames = new ArrayList<>();
        for (WebElement webElement : getSearchResultItems()) {
            SearchResultItemNames.add(webElement.getText().toLowerCase());
        }
        return SearchResultItemNames;
    }

}
