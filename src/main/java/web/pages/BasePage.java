package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    @Autowired
    private WebDriver driver;

    public void openPage(String url) {
        driver.navigate().to(url);
    }

    public WebElement findElement(By by) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver.findElement(by));

    }

    public List<WebElement> findElements(By by) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver.findElements(by));
    }

    public boolean checkElementIsDisplayed(By by) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).until(driver1 -> driver.findElement(by).isDisplayed());
    }

    public WebElement waitElementToBeClickable(By by) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
