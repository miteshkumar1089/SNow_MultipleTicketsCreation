package Pages;

import java.io.IOException;
import java.time.Duration;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ReadingPropertiesFile;

import static base.basePage.test;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ReadingPropertiesFile propObj= new ReadingPropertiesFile();
	
	public static By userName= By.cssSelector("input.form-control");
	public static By password= By.cssSelector("input.form-control[type='password']");
	public static By submitButton= By.cssSelector(".btn.btn-primary");
	
	public LoginPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));
        
	}
	
	public void fillingLoginDetails(String userID, String passwd) throws IOException 
	{
		driver.findElement(userName).sendKeys(userID);
		test.log(LogStatus.INFO,"User passing their credentials");
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(submitButton).click();
		driver.get(propObj.readFromPropertiesFile("CreateIncidentRequestedItemUrl"));
	}

}
