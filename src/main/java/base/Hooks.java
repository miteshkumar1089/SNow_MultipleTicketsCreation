package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LoginPage;
import Utilities.ReadingPropertiesFile;
 
public class Hooks {
 
	public static WebDriver driver;
	ReadingPropertiesFile propObj= new ReadingPropertiesFile();
 
    @Before
    public void setUp() throws IOException {
		String browser = propObj.readFromPropertiesFile("browser");
		WebDriverManager.chromedriver().setup();
		// Setting  options to false so it will run without headless mode
		// If we make it true then it will run the test code in headless mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.setHeadless(false);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get(propObj.readFromPropertiesFile("url"));
    }
 
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
