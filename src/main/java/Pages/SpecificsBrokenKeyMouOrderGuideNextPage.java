package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpecificsBrokenKeyMouOrderGuideNextPage {

	WebDriver driver;
	WebDriverWait wait;

	public static By inputDevice= By.xpath("//select[@id='IO:69fc18398708b01053e97778cebb3534']"); // Mouse

	public static By brokenMouse= By.xpath("//select[@id='IO:7d6c54398708b01053e97778cebb3568']"); // Yes

	public static By SecurityDevice= By.xpath("//select[@id='IO:0bde1cb98708b01053e97778cebb3548']"); // Yes

	public static By securityKeyLocation= By.xpath("//input[@id='IO:8b5f54b98708b01053e97778cebb35c1']");

	public static By os= By.xpath("//select[@id='IO:691d50798708b01053e97778cebb3537']"); // Mac 10.10x

	public static By saveAndSubmit= By.cssSelector("#next_page");

	public SpecificsBrokenKeyMouOrderGuideNextPage(WebDriver driver){

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

	}

	public void inputDev(String inputDeviceName) throws InterruptedException {

		Select inputDeviceOptions = new Select(driver.findElement(inputDevice));
		inputDeviceOptions.selectByValue(inputDeviceName);
		Thread.sleep(2000);

	}
	public void brokenMouse(String brokenMouseName) throws InterruptedException {
		Thread.sleep(2000);
		Select brokenMouseOptions = new Select(driver.findElement(brokenMouse));
		brokenMouseOptions.selectByValue(brokenMouseName);

	}

	public void securityDev(String securityDeviceName) throws InterruptedException {
		Thread.sleep(2000);
		Select SecurityDeviceOptions = new Select(driver.findElement(SecurityDevice));
		SecurityDeviceOptions.selectByValue(securityDeviceName);

	}

	public void securityKey(String securityKeyName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(securityKeyLocation).sendKeys(securityKeyName);

	}

	public void osOption(String osOptionName) throws InterruptedException {
		Thread.sleep(2000);
		Select osOptions = new Select(driver.findElement(os));
		osOptions.selectByValue(osOptionName);

	}
}