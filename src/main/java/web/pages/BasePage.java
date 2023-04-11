package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.driver.DriverSetup;
import web.driver.wait.CustomFluentWait;

import java.util.List;

public class BasePage {

    public WebElement findElement(By by) {
        CustomFluentWait.getCustomFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return DriverSetup.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        CustomFluentWait.getCustomFluentWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return DriverSetup.getDriver().findElements(by);
    }

    public boolean checkElementIsDisplayed(By by) {
        return findElement(by).isDisplayed();
    }
    public WebElement waitElementToBeClickable(By by) {
        CustomFluentWait.getCustomFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        return DriverSetup.getDriver().findElement(by);
    }

    public void refreshPage() {
        DriverSetup.getDriver().navigate().refresh();
    }
}
