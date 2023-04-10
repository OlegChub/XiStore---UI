package web.constants;

import web.helpers.ConfigSetUp;
import web.helpers.UserAuthConfig;

public class Constants {
    public static final int FLUENT_WAIT_TIMEOUT = 30;
    public static final int FLUENT_WAIT_POLLING_TIME = 1;
    public static final int IMPLICIT_WAIT_TIMEOUT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 60;
    public static final String HOME_URL = ConfigSetUp.getHost();
    public static final String LOGIN = UserAuthConfig.getUserName();
    public static final String PASSWORD = UserAuthConfig.getPassword();
    public static final String WRONG_LOGIN = "ppp";
    public static final String WRONG_PASSWORD = "10293847";
    public static final String TEXT_OF_ERROR_MASSAGE = "Неверный логин или пароль.";
    public static final String NAME_PRODUCT_FOR_SEARCH = "Xiaomi Redmi Note 11";

}
