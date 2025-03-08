package base;

import Utilities.DataFactory;
import Utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LoginPage;
import Utilities.ReadingPropertiesFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    public static WebDriver driver;
    public ExtentReports extent;
    public static ExtentTest test;
    ReadingPropertiesFile propObj= new ReadingPropertiesFile();

    @Before
    public void setUp(Scenario scenario) throws IOException {
        String browser = propObj.readFromPropertiesFile("browser");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(propObj.readFromPropertiesFile("url"));

        extent = ExtentManager.getInstance("reports//Extent_demo.html");

        // ✅ Start Extent Test for the scenario
        test = extent.startTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(LogStatus.FAIL, "Test case failed: " + scenario.getName());
        } else {
            test.log(LogStatus.PASS, "Test case passed: " + scenario.getName());
        }

        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
