import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.constants.Constants;
import web.pages.*;

public class XiStoreTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginModal loginModal = new LoginModal();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();
    private final SmartphoneProductsPage smartphoneProductsPage = new SmartphoneProductsPage();
    private final CertainSmartphoneProductPage certainSmartphoneProductPage = new CertainSmartphoneProductPage();
    private final CartPage cartPage = new CartPage();


    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта и пароль)")
    public void testXiStoreLogin() {
        homePage.clickOnPersonalCabinetIcon();
        loginModal.doXiStoreLogin(Constants.LOGIN, Constants.PASSWORD);
        homePage.refreshPage();
        homePage.clickOnPersonalCabinetIcon();
        Assertions.assertEquals(Constants.LOGIN, homePage.getUserName());
    }

    @Test
    @DisplayName("Проверка входа с некорректными данными (электронная почта) и корректными данными (пароль)")
    public void testXiStoreWrongMail() {
        homePage.clickOnPersonalCabinetIcon();
        loginModal.doXiStoreLogin(Constants.WRONG_LOGIN, Constants.PASSWORD);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с корректными данными (электронная почта) и некорректными данными (пароль)")
    public void testXiStoreWrongPassword() {
        homePage.clickOnPersonalCabinetIcon();
        loginModal.doXiStoreLogin(Constants.LOGIN, Constants.WRONG_PASSWORD);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с некорректными данными (электронная почта и пароль)")
    public void testXistoreWrongMailPassword() {
        homePage.clickOnPersonalCabinetIcon();
        loginModal.doXiStoreLogin(Constants.WRONG_LOGIN, Constants.WRONG_PASSWORD);
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Проверка входа с пустыми полями данных (электронная почта и пароль)")
    public void testXistoreEmptyFieldsMailPassword() {
        homePage.clickOnPersonalCabinetIcon();
        loginModal.doXiStoreLogin("", "");
        Assertions.assertEquals(Constants.TEXT_OF_ERROR_MASSAGE, loginModal.getLabelError());
    }

    @Test
    @DisplayName("Поиск товара в поле (Что хотите купить) ")
    public void testProductSearch() {
        homePage.doSearchByProductName(Constants.NAME_PRODUCT_FOR_SEARCH);
        searchResultsPage.checkSearchResultPageIsDisplayed();
        Assertions.assertTrue(searchResultsPage
                .checkSearchResultsContainSearchQuery(Constants.NAME_PRODUCT_FOR_SEARCH));

    }

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addProductToCart() {
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


