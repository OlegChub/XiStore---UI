package web.pages;

import org.openqa.selenium.By;

public class SmartphoneProductsPage extends BasePage {

    private static final By SMARTPHONE_PRODUCT_PAGE_TITLE = By.xpath("//h1[text()='Смартфоны']");
    private static final By SMARTPHONE_ITEMS = By.className("search__page_item-name");

    public SmartphoneProductsPage checkSmartphoneProductsPageIsDisplayed() {
        checkElementIsDisplayed(SMARTPHONE_PRODUCT_PAGE_TITLE);
        return this;
    }

    public String getFirstProductItemName() {
        return findElements(SMARTPHONE_ITEMS).get(0).getText();
    }

    public void clickOnFirstProductItem() {
        findElements(SMARTPHONE_ITEMS).get(0).click();
    }
}
