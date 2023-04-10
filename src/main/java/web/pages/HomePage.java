package web.pages;

import org.openqa.selenium.By;
import web.driver.DriverProvider;

import static web.constants.Constants.HOME_URL;


public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = HOME_URL;
    private static final By PERSONAL_CABINET_ICON = By.className("navigation-cabinet");
    private static final By MAIL_LINK = By.xpath("//span[@href='/personal/']");
    private static final By SEARCH_FIELD = By.id("title-search-input");
    private static final By SEARCH_BTN = By.className("input-search-button");

    private static final By PHONE_MENU_ITEM = By.xpath("(//a[@href='/catalog/telefony/'])[2]");
    private static final By SHOW_ALL_MENU_ITEM = By.xpath("//span[text()='Смотреть всё из раздела']");


    public HomePage openHomePage() {
        DriverProvider.getDriver().get(HOME_PAGE_URL);
        return this;
    }

    public void clickOnPersonalCabinetIcon() {
        waitElementToBeClickable(PERSONAL_CABINET_ICON).click();
    }

    public String getUserName() {
        return findElement(MAIL_LINK).getText();
    }

    private void inputQueryInSearchField(String query) {
        findElement(SEARCH_FIELD).sendKeys(query);
    }

    private void submitSearchQuery() {
        findElement(SEARCH_BTN).click();
        ;
    }

    public void doSearchByProductName(String productName) {
        inputQueryInSearchField(productName);
        submitSearchQuery();
    }

    public void clickOnPhoneMenuItem() {
        findElement(PHONE_MENU_ITEM).click();
    }

    public void clickOnShowAllMenuItem() {
        findElement(SHOW_ALL_MENU_ITEM).click();
    }

}
