import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.driver.DriverManager;

import javax.annotation.PostConstruct;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    @Autowired
    private DriverManager driverManager;;

    @BeforeEach
    @PostConstruct
    protected void setUp() {
        LOGGER.info("Test is starting ... ");
        driverManager.getDriver();
    }

    @AfterEach
    protected void closeBrowser() {
        LOGGER.info("Test has finished");
        driverManager.closeDriver();
    }

}
