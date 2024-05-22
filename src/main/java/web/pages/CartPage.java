package web.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends BasePage {
    private static final By CART_PAGE = By.id("basket_form_container");
    private static final By ITEM_IN_CART = By.xpath("(//div[@class='bx_ordercart_itemtitle mbw-name'])/a");

    public CartPage checkCartPageIsDisplayed() {
        checkElementIsDisplayed(CART_PAGE);
        return this;
    }

    public String getItemInCartName() {
        return findElement(ITEM_IN_CART).getText();
    }
}
