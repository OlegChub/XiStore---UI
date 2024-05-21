package web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@Configuration
public class DriverManager {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    @Value("${browser}")
    private String browser;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public WebDriver getDriver() {
        switch (browser.toLowerCase()) {
            case "edge":
                LOGGER.info("Setting up Edge driver");
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*")));
                break;

            case "firefox":
                LOGGER.info("Setting up Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver(new FirefoxOptions().addArguments("--remote-allow-origins=*")));
                break;
            case "chrome":
            default:
                LOGGER.info("Setting up Chrome driver");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")));
                break;
        }
        LOGGER.info("Setting up options");
        driver.get().manage().deleteAllCookies();
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        LOGGER.info("Driver has been set up");
        return driver.get();
    }

    public void closeDriver() {
        if (driver.get() == null) {
            return;
        }
        driver.get().quit();
        driver.remove();
        LOGGER.info("Driver is closed");
    }
}
