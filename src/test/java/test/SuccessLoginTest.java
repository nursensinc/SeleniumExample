package test;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SuccessLoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "Success Login Test")
    @Description("This test verifies valid login functionality")
    public void loginTest() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.checkCreateAccountPage();
        loginPage.enterUserInfo("1111111111111111");
        loginPage.enterUserPassword("12345");
        Thread.sleep(1000);
    }
}
