package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpecificTicketCreationAccessToOSYDApps {
    WebDriver driver;
    WebDriverWait wait;

    public static By OSYDDataReportName = By.xpath("//input[@id='sys_display.IO:b91e224f1bc87810ec6254ea234bcb4e']");
    public static By DateRequested = By.xpath("//tbody/tr[@id='element.IO:ce6ea68f1bc87810ec6254ea234bcb27']/td[1]/div[1]/div[1]/div[2]/span[1]/span[1]/a[1]/span[1]");
    public static By DesiredDateRequested = By.xpath("//a[@id='GwtDateTimePicker_day15']");
    public static By DueDate = By.xpath("//tbody/tr[@id='element.IO:baae264f1bc87810ec6254ea234bcb57']/td[1]/div[1]/div[1]/div[2]/span[1]/span[1]/a[1]/span[1]");
    public static By DesiredDueDate = By.xpath("//a[@id='GwtDateTimePicker_day16']");
    public static By DocumentLibrary = By.xpath("//input[@id='IO:4fdeea8f1bc87810ec6254ea234bcb3f']");

    public SpecificTicketCreationAccessToOSYDApps(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    }

    public void getDataReportName(String text) {

        driver.findElement(OSYDDataReportName).sendKeys(text);
        driver.findElement(OSYDDataReportName).sendKeys(Keys.ENTER);

    }

    public void clickDateRequested() throws InterruptedException {
        driver.findElement(DateRequested).click();
        Thread.sleep(2000);
    }

    public void clickDesiredDate() throws InterruptedException {
        driver.findElement(DesiredDateRequested).click();
        Thread.sleep(2000);
    }

    public void clickDueDate() throws InterruptedException {
        driver.findElement(DueDate).click();
        Thread.sleep(2000);
    }

    public void clickDesiredDueDate() throws InterruptedException {
        driver.findElement(DesiredDueDate).click();
        Thread.sleep(3000);
    }

    public void getDocumentLibrary(String text) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(DocumentLibrary).sendKeys(text);
        Thread.sleep(2000);
    }

}






