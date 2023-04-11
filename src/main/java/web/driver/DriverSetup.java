package web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static web.constants.Constants.IMPLICIT_WAIT_TIMEOUT;
import static web.constants.Constants.PAGE_LOAD_TIMEOUT;

public class DriverSetup {
    private static WebDriver driver;

    private DriverSetup(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
    public static void close(){
        if (driver!= null) {
            driver.quit();
            driver = null;
        }
    }
}
