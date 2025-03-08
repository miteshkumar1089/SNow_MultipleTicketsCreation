package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpecificsEmailPassResetOrderGuideNextPage {

    WebDriver driver;
    WebDriverWait wait;

    public static By userId= By.xpath("//select[@id='IO:bfa921e68fdb51503f19a26e1171a451']"); // Yes

    public static By lastTimeLogin= By.xpath("//input[@id='IO:a5bb252a8fdb51503f19a26e1171a49f']");

    public static By differentDevice= By.xpath("//select[@id='IO:748ca16a8fdb51503f19a26e1171a425']"); // No

    public static By differentBrowser= By.xpath("//select[@id='IO:fb1d256a8fdb51503f19a26e1171a4e4']"); //Yes

    public static By saveAndSubmit= By.cssSelector("#next_page");

    public SpecificsEmailPassResetOrderGuideNextPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    }

    public void userID(String userIDname) throws InterruptedException {
        Thread.sleep(1000);

        Select userIdOptions = new Select(driver.findElement(userId));
        userIdOptions.selectByValue(userIDname);

    }

    public void lastLoginTime(String lastLogin) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(lastTimeLogin).sendKeys(lastLogin);
    }

    public void deviceOp(String deviceName) throws InterruptedException {
        Thread.sleep(2000);
        Select deviceOptions = new Select(driver.findElement(differentDevice));
        deviceOptions.selectByValue(deviceName);

    }
    public void browserOp(String browserName) throws InterruptedException {
        Thread.sleep(2000);
        Select browserOptions = new Select(driver.findElement(differentBrowser));
        browserOptions.selectByValue(browserName);

    }

}