package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpecificTicketCreationProviderAssignement {
    WebDriver driver;
    WebDriverWait wait;

    public static By Category = By.xpath("//select[@id='IO:600667db93ce8250ce3abc1a6aba10f0']");
    public static By SubCategory = By.xpath("//select[@id='IO:fc76231f93ce8250ce3abc1a6aba105f']");
    public static By SchoolAge = By.xpath("//select[@id='IO:cf17a75f93ce8250ce3abc1a6aba10d0']");

    public SpecificTicketCreationProviderAssignement(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    }
    public void getCategory(String categoryChoice) throws InterruptedException {
        Select selectCategory = new Select(driver.findElement(Category));
        selectCategory.selectByVisibleText(categoryChoice);
        Thread.sleep(2000);
    }

    public void getSubCategory(String SubcategoryChoice) throws InterruptedException {
        Thread.sleep(2000);
        Select selectSubCategory = new Select(driver.findElement(SubCategory));
        selectSubCategory.selectByVisibleText(SubcategoryChoice);
        Thread.sleep(1000);
    }

    public void getSchoolAge(String SchoolAgeChoice) throws InterruptedException {
        Thread.sleep(2000);
        Select selectSchoolAge = new Select(driver.findElement(SchoolAge));
        selectSchoolAge.selectByVisibleText(SchoolAgeChoice);
        Thread.sleep(1000);
    }
}
