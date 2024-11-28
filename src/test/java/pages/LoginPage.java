package pages;

import utils.DriverUtils;

import static pageConstants.LoginPageConstants.*;

public class LoginPage extends DriverUtils {

    public void checkCreateAccountPage() {
        findElement(CORPORATE_LOGIN_BTN).click();
        System.out.println(getCurrentUrl());
        assertEquals(getCurrentUrl(), "https://param.com.tr/hesap-olustur", "The page could not be loaded");
    }

    public void clickLogin() {
        waitForElement(LOGIN_BUTTON, 10);
        findElement(LOGIN_BUTTON).click();
    }

    public void enterUserInfo(String userInfo) {

        switchToTab(2);
        waitForElement(USER_ID_INPUT, 10);
        sendKeys(userInfo, USER_ID_INPUT);
    }

    public void enterUserPassword(String password) {
        waitForElement(PASSWORD_INPUT, 10);
        sendKeys(password, PASSWORD_INPUT);
    }
}
