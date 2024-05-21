import com.config.XiStoreApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import web.constants.Constants;
import web.pages.*;

@SpringBootTest(classes = {XiStoreApplication.class})
public class XiStoreTest extends BaseTest {

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginModal loginModal;

    @Autowired
    private SearchResultsPage searchResultsPage;

    private final SmartphoneProductsPage smartphoneProductsPage = new SmartphoneProductsPage();
    private final CertainSmartphoneProductPage certainSmartphoneProductPage = new CertainSmartphoneProductPage();
    private final CartPage cartPage = new CartPage();

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;

    @Value("ppp")
    private String wrongLogin;

    @Value("10293847")
    private String wrongPassword;


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
    @DisplayName("Проверка входа с некорректными данными (электронная почта) и корректными данными (пароль)")
    public void testXiStoreWrongMail() {
        homePage.openHomePage();
        homePage.clickOnPersonalCabinetIcon();
        homePage.clickOnLoginWithOtherOption();
        loginModal.doXiStoreLogin(wrongLogin, password);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта) и некорректными данными (пароль)")
    public void testXiStoreWrongPassword() {
        homePage.openHomePage();
        homePage.clickOnPersonalCabinetIcon();
        homePage.clickOnLoginWithOtherOption();
        loginModal.doXiStoreLogin(login, wrongPassword);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с некорректными данными (электронная почта и пароль)")
    public void testXistoreWrongMailPassword() {
        homePage.openHomePage();
        homePage.clickOnPersonalCabinetIcon();
        homePage.clickOnLoginWithOtherOption();
        loginModal.doXiStoreLogin(wrongLogin, wrongPassword);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с пустыми полями данных (электронная почта и пароль)")
    public void testXistoreEmptyFieldsMailPassword() {
        homePage.openHomePage();
        homePage.clickOnPersonalCabinetIcon();
        homePage.clickOnLoginWithOtherOption();
        loginModal.doXiStoreLogin("", "");
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Поиск товара в поле (Что хотите купить) ")
    public void testProductSearch() {
        homePage.openHomePage();
        homePage.doSearchByProductName(Constants.NAME_PRODUCT_FOR_SEARCH);
        searchResultsPage.checkSearchResultPageIsDisplayed();
        Assertions.assertTrue(searchResultsPage
                .isQueryPresentInSearchResults(Constants.NAME_PRODUCT_FOR_SEARCH));

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
        String productInCartName = cartPage.getItemInCartName();
        Assertions.assertEquals(firstProductItemName, productInCartName);
    }
}


