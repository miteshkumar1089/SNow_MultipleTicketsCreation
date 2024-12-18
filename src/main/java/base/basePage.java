package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import Utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.DataFactory;
import Utilities.ReadingPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {

	public static WebDriver driver;
	ReadingPropertiesFile propObj = new ReadingPropertiesFile();

	public static DataFactory data = new DataFactory();

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void setUp() throws IOException {

		String browser = propObj.readFromPropertiesFile("browser");

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			//options.setHeadless(false);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// Setting  options to false so it will run without headless mode
			// If we make it true then it will run the test code in headless mode
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.setHeadless(false);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		extent = ExtentManager.getInstance("reports//Extent_demo.html");


		driver.get(propObj.readFromPropertiesFile("url"));
	}

	@BeforeMethod
	public void startTest(Method method) {
		test = extent.startTest(method.getName());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if (result.getStatus() == ITestResult.FAILURE) {
// ScreenShots.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, "Test case got failed");
		}
		extent.flush();

	}

	@AfterMethod
	public void Logff() {
		driver.quit();
	}

}


