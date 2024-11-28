package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.AllureReport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;


public class BaseTest {
    protected String url = "https://param.com.tr/";
    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuiteSetup() {
        System.out.println("BeforeSuite: Setting up Allure reports directory...");
        // Create or clean the directory for Allure results
        String allureResultsPath = "target/allure-results";
        File allureResultsDir = new File(allureResultsPath);

        try {
            if (allureResultsDir.exists()) {
                System.out.println("Cleaning existing Allure results...");
                Files.walk(Paths.get(allureResultsPath))
                        .map(Path -> Path.toFile())
                        .forEach(File::delete);
            }
            Files.createDirectories(Paths.get(allureResultsPath));
            System.out.println("Allure results directory is ready.");
        } catch (IOException e) {
            System.err.println("Failed to prepare Allure results directory: " + e.getMessage());
        }
    }

    @BeforeTest
    @Step("Initializing the test suite")
    public void setupTestSuite() {
        System.out.println("BeforeTest: Initializing the test suite...");
    }


    @BeforeMethod
    @Step("Launching the browser and navigating to the login page")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    @Step("Closing the browser after test completion")
    public void teardown() {
        System.out.println("AfterMethod: Ending the test...");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    @Step("Cleaning up after the test suite")
    public void teardownTestSuite() {
        System.out.println("AfterTest: Test suite completed...");
    }

    @AfterSuite
    @Step("Cleaning up the overall test environment")
    public void afterSuiteCleanup() {
        AllureReport.generateAllureReport();
        System.out.println("AfterSuite: Cleaning up the test environment...");
    }
}
