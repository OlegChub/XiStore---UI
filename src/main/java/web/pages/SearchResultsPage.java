package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchResultsPage extends BasePage {
    @Autowired
    private WebDriver driver;

    @PostConstruct
    public void initSearchResultsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Результаты поиска')]")
    private WebElement searchPageTitle;

    @FindBy(className = "search__page_item-name")
    private List<WebElement> searchResultItems;

    public SearchResultsPage checkSearchResultPageIsDisplayed() {
        searchPageTitle.isDisplayed();
        return this;
    }

    public List<String> getSearchResultItemNames() {
        List<String> searchResultItemNames = new ArrayList<>();
        for (WebElement webElement : searchResultItems) {
            searchResultItemNames.add(webElement.getText().toLowerCase());
        }
        return searchResultItemNames;
    }

}
