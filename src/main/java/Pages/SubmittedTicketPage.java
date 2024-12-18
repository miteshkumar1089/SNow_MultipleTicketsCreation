package Pages;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class SubmittedTicketPage {
 
	WebDriver driver;
	WebDriverWait wait;
 
	public static By ticketIDIncident = By.xpath("//input[@id='sys_readonly.incident.number']");
	public static By ticketIDRequest = By.xpath("//input[@id='sys_readonly.sc_req_item.number']");
 
	public SubmittedTicketPage(WebDriver driver) {
 
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));
 
	}
 
	public String getTicketNumber() {
		String str1="";
 
		try {
			str1 = driver.findElement(ticketIDIncident).getAttribute("value");
			return str1;
 
		} catch (NoSuchElementException e) {
			try {
				str1 = driver.findElement(ticketIDRequest).getAttribute("value");
				return str1;
			} catch (NoSuchElementException ex) {
			}
		}
 
		return str1;
 
	}
}