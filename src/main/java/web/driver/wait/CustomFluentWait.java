package web.driver.wait;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import web.constants.Constants;
import web.driver.DriverSetup;

import java.time.Duration;

public class CustomFluentWait {
    private static FluentWait customFluentWait;

    private CustomFluentWait() {
    }

    public static FluentWait getCustomFluentWait() {
        if (customFluentWait == null) {
            customFluentWait = new FluentWait(DriverSetup.getDriver())
                    .withTimeout(Duration.ofSeconds(Constants.FLUENT_WAIT_TIMEOUT))
                    .pollingEvery(Duration.ofSeconds(Constants.FLUENT_WAIT_POLLING_TIME))
                    .ignoring(NoSuchElementException.class);
        }
        return customFluentWait;
    }

}
