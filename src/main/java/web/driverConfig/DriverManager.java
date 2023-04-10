package web.driverConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.constants.Constants;

import java.time.Duration;

public class DriverManager {
    private final static BrowserConfig CONFIG = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    private static final Logger LOGGER = LogManager.getLogger();

    private DriverManager() {
    }

    public static WebDriver setUpDriver() {
        LOGGER.info("Driver creation ...");
        WebDriverManager manager = WebDriverManager.getInstance(CONFIG.browser());
        WebDriver driver;
        if (CONFIG.browser().equalsIgnoreCase("CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else {
            driver = manager.create();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
        LOGGER.info("Driver was created and properties were set");
        return driver;
    }
}
