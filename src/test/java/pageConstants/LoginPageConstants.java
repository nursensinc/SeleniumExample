package pageConstants;

import org.openqa.selenium.By;

public class LoginPageConstants {
    public static final By LOGIN_BUTTON = By.id("menu_login");
    public static final By CORPORATE_LOGIN_BTN = By.cssSelector(".bireysel-hesap-olustur-alt > div > div > div:nth-of-type(1) > div  > div > a");
    public static final By USER_ID_INPUT = By.cssSelector("[name='userCardNo']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Şifre']");
}
