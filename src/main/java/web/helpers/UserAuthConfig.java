package web.helpers;

import common.config.UserCredentials;
import org.aeonbits.owner.ConfigFactory;

public class UserAuthConfig {
    private UserAuthConfig() {
    }

    private static UserCredentials userCredentials = ConfigFactory.create(UserCredentials.class, System.getProperties());

    public static String getUserName() {
        return userCredentials.login();
    }

    public static String getPassword() {
        return userCredentials.password();
    }

}
