package web.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HomePage extends BasePage{
    @Value("${app.host}")
    private String url;
    private static final By PERSONAL_CABINET_ICON = By.xpath("//div[contains(@class,'block--user')]");
    private static final By MAIL_LINK = By.xpath("//a[@href='/personal/']/span");
    private static final By LOGIN_WITH_OTHER_OPTION = By.xpath("//a[@href='#modalLoginByEmail']");
    private static final By SEARCH_FIELD = By.id("title-search-input");
    private static final By SEARCH_BTN = By.className("input-search-button");
    private static final By PHONE_MENU_ITEM = By.xpath("(//a[@href='/catalog/telefony/'])[2]");

    public void openHomePage() {
        openPage(url);
    }

    public void clickOnPersonalCabinetIcon() {
        waitElementToBeClickable(PERSONAL_CABINET_ICON).click();
    }

    public void clickOnLoginWithOtherOption() {
        waitElementToBeClickable(LOGIN_WITH_OTHER_OPTION).click();
    }

    public String getUserName() {
        return findElement(MAIL_LINK).getText();
    }

    private void inputQueryInSearchField(String query) {
        findElement(SEARCH_FIELD).sendKeys(query);
    }

    private void submitSearchQuery() {
        findElement(SEARCH_BTN).click();
    }

    public void doSearchByProductName(String productName) {
        inputQueryInSearchField(productName);
        submitSearchQuery();
    }

    public void clickOnPhoneMenuItem() {
        findElement(PHONE_MENU_ITEM).click();
    }
}
