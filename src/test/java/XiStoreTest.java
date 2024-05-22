import com.config.XiStoreApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import web.pages.*;

import java.util.List;

import static web.constants.Constants.PRODUCT_FOR_SEARCH;

@SpringBootTest(classes = {XiStoreApplication.class})
public class XiStoreTest extends BaseTest {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginModal loginModal;

    @Autowired
    private SearchResultsPage searchResultsPage;

    @Autowired
    private SmartphoneProductsPage smartphoneProductsPage;

    @Autowired
    private CertainSmartphoneProductPage certainSmartphoneProductPage;

    @Autowired
    private final CartPage cartPage = new CartPage();

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;

    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта и пароль)")
    public void testXiStoreLogin() {
        homePage.openHomePage();
        homePage.clickOnPersonalCabinetIcon();
        homePage.clickOnLoginWithOtherOption();
        loginModal.doXiStoreLogin(login, password);
        homePage.refreshPage();
        homePage.clickOnPersonalCabinetIcon();

        Assertions.assertEquals(login, homePage.getUserName());
    }

    @Test
    @DisplayName("Поиск товара в поле (Что хотите купить) ")
    public void testProductSearch() {
        homePage.openHomePage();
        homePage.doSearchByProductName(PRODUCT_FOR_SEARCH);
        searchResultsPage.checkSearchResultPageIsDisplayed();
        List<String> items = searchResultsPage.getSearchResultItemNames();

        Assertions.assertTrue(items.stream()
                .anyMatch(item->item.contains(PRODUCT_FOR_SEARCH.toLowerCase())));

    }

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addProductToCart() {
        homePage.openHomePage();
        homePage.clickOnPhoneMenuItem();
        smartphoneProductsPage.checkSmartphoneProductsPageIsDisplayed();
        String firstProductItemName = smartphoneProductsPage.getFirstProductItemName();
        smartphoneProductsPage.clickOnFirstProductItem();
        certainSmartphoneProductPage.addProductToCart();
        certainSmartphoneProductPage.closeAddedToCartPopUp();
        certainSmartphoneProductPage.openCart();
        cartPage.checkCartPageIsDisplayed();

        Assertions.assertEquals(firstProductItemName, cartPage.getItemInCartName());
    }
}


