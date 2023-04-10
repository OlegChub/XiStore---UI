package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private static final By SEARCH_PAGE_TITLE = By.xpath("//h1[text()='ПОИСК В МАГАЗИНЕ']");
    private static final By SEARCH_RESULT_ITEMS = By.className("search__page_item-name");

    public SearchResultsPage checkSearchResultPageIsDisplayed() {
        checkElementIsDisplayed(SEARCH_PAGE_TITLE);
        return this;
    }

    public boolean checkSearchResultsContainSearchQuery(String query) {
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
        List<WebElement> webElementList = getSearchResultItems();
        for (WebElement webElement : webElementList) {
            SearchResultItemNames.add(webElement.getText().toLowerCase());
        }
        System.out.println(SearchResultItemNames.get(2));
        return SearchResultItemNames;
    }

}
