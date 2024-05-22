package web.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CertainSmartphoneProductPage extends BasePage {

    public static final By BTN_ADD_TO_CART = By.xpath("//a[contains(@id,'buy_link')]");
    public static final By CLOSE_POP_UP_BTN = By.xpath("//a[text()='Закрыть']");
    public static final By BTN_CART = By.xpath("//a[contains(@class,'button--basket')]");

    public void addProductToCart() {
        findElement(BTN_ADD_TO_CART).click();
    }

    public void closeAddedToCartPopUp() {
        findElement(CLOSE_POP_UP_BTN).click();
    }

    public void openCart() {
        findElement(BTN_CART).click();
    }

}
