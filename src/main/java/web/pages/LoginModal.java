package web.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginModal extends HomePage {
    private static final By LOGIN_MODAL = By.id("modalLoginByEmail");
    private static final By LOGIN_FIELD = By.xpath("//input[@name='USER_LOGIN']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By BTN_SUBMIT = By.xpath("//input[@value='ВОЙТИ']");
    private static final By WRONG_LOGIN_POPUP = By.xpath("//p//font[@class='errortext'][1]");

    private LoginModal checkLoginModalIsDisplayed() {
        checkElementIsDisplayed(LOGIN_MODAL);
        return this;
    }

    public void doXiStoreLogin(String login, String password) {
        checkLoginModalIsDisplayed();
        inputLogin(login);
        inputPassword(password);
        submit();
    }

    public void inputLogin(String login) {
        findElement(LOGIN_FIELD).sendKeys(login);
    }

    public void inputPassword(String password) {
        findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void submit() {
        findElement(BTN_SUBMIT).click();
    }

    public String getLabelError() {
        return findElement(WRONG_LOGIN_POPUP).getText();
    }

}
