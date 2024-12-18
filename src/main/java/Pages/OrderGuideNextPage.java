package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderGuideNextPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public static By saveAndSubmit= By.cssSelector("#next_page");
	
	public OrderGuideNextPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));
        
	}
	
	public void submitTicket() {
		driver.findElement(saveAndSubmit).click();
	}
	
	
}
