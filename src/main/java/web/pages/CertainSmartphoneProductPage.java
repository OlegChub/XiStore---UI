package web.pages;

import org.openqa.selenium.By;

//TODO

public class CertainSmartphoneProductPage extends BasePage {

//    public static final By BTN_CATALOG_PHONE = By.xpath("(//a[@href='/catalog/telefony/'])[2]");
//    public static final By SELECTION_PHONE = By.xpath("(//div[@class='accessories__block']/div)[1]");
//    public static final By NAME_PHONE = By.xpath("//*[@id='bx_2369550383_88441']/div/div[1]/div[3]/div[1]/div[1]/div[1]/h1");
    public static final By BTN_ADD_TO_CART = By.xpath("//a[@id='bx_2369550383_88441_buy_link']");
    public static final By BTN_CLOSE_POP_UP = By.xpath("//a[@class='close js-close-popapBuy']");

    public static final By BTN_CART = By.xpath("//a[@class='top-panel-basket-link']");


//    public static final By BTN_CLOSE = By.xpath("//a[@class='close js-close-popapBuy']");
//    public static final By BTN_INPUT_CART = By.xpath("//a[@class='top-panel-basket-link']");
//    public static final By NAME_PHONE_IN_CART = By.xpath("//div[@class='bx_ordercart_itemtitle mbw-name']");

    public void addProductToCart() {
        findElement(BTN_ADD_TO_CART).click();
    }
    public void closeAddedToCartPopUp() {
        findElement(BTN_CLOSE_POP_UP).click();
    }

    public void openCart() {
        findElement(BTN_CART).click();
    }




}
