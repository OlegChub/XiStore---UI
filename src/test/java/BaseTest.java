import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import web.driver.DriverSetup;

import static web.constants.Constants.HOME_URL;

public class BaseTest {

    @BeforeEach
    public void beforeTestActions() {
        DriverSetup.getDriver().get(HOME_URL);
    }

    @AfterEach
    public void afterTestActions() {
        DriverSetup.close();
    }

}
