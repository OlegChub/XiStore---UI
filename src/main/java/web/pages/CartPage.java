package web.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private static final By CART_PAGE_TITLE = By.xpath("//h3[contains(text(),'Товары в корзине')]");
    private static final By ITEM_IN_CART = By.xpath("(//div[@class='bx_ordercart_itemtitle mbw-name'])/a");


    public CartPage checkCartPageIsDisplayed() {
        checkElementIsDisplayed(CART_PAGE_TITLE);
        return this;
    }

    public String getItemInCartName() {
        return findElement(ITEM_IN_CART).getText();
    }
}
