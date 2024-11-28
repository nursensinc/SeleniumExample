package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static base.BaseTest.driver;

public class DriverUtils {

    public static WebDriverWait waitSecond(long second) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        return wait;
    }


    public void assertEquals(String actual, String excepted, String message) {
        Assert.assertEquals(actual, excepted, message);
    }

    public void sendKeys(String value, By by) {
        WebElement send = driver.findElement(by);
        send.click();
        send.sendKeys(value);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToTab(Integer targetTabNumber) {
        int tabNumber = targetTabNumber - 1;

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        if (tabNumber >= 0 && tabNumber < tabs.size()) {
            driver.switchTo().window(tabs.get(tabNumber));
        } else {
            System.out.println("Invalid tab number.");
        }
    }

    public void waitForElement(By by, long second) {
        waitSecond(second).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
