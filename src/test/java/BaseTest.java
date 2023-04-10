
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import web.driver.DriverProvider;

public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @BeforeEach
    public void beforeTestActions() {
        LOGGER.info("Test is starting ... ");
    }

    @AfterEach
    public void afterTestActions() {
        DriverProvider.quitDriver();
        LOGGER.info("Test is finished");
    }

}
