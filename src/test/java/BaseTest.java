import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.driver.DriverManager;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    @Autowired
    private DriverManager driverManager;;

    @BeforeEach
    public void beforeTestActions() {
        LOGGER.info("Test is starting ... ");
    }

    @AfterEach
    public void afterTestActions() {
        driverManager.closeDriver();
        LOGGER.info("Test has finished");
    }

}
