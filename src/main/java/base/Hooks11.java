//package base;
//
//import Utilities.ExtentManager;
//import Utilities.ReadingPropertiesFile;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.ITestResult;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//
//public class Hooks11 {
//
//	public static WebDriver driver;
//	ReadingPropertiesFile propObj= new ReadingPropertiesFile();
//    public static ExtentReports extent;
//    public static ExtentTest test;
//
//    @Before
//    public void setUp(Method method) throws IOException {
//		String browser = propObj.readFromPropertiesFile("browser");
//		WebDriverManager.chromedriver().setup();
//		// Setting  options to false so it will run without headless mode
//		// If we make it true then it will run the test code in headless mode
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		//options.setHeadless(false);
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//
//		driver.get(propObj.readFromPropertiesFile("url"));
//
//        extent = ExtentManager.getInstance("reports//Extent_demo.html");
//
//        test = extent.startTest(method.getName());
//    }
//
//    @After
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.SUCCESS)
//            test.log(LogStatus.PASS, "Test case got passed");
//        else if (result.getStatus() == ITestResult.FAILURE) {
//// ScreenShots.takeScreenShot(driver, result.getName());
//            test.log(LogStatus.FAIL, "Test case got failed");
//        }
//        extent.flush();
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//}
