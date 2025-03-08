package Pages.Others;

import Utilities.ReadingPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TechApp {
    static WebDriver driver;
    WebDriverWait wait;
    ReadingPropertiesFile propObj= new ReadingPropertiesFile();

    public static By techAppName= By.xpath("//*[contains(@aria-label,'name')]");
    public static By techApp= By.xpath("//tbody//tr//td[3]");
    public static By techAppCode= By.xpath("//tbody//tr//td[4]");
    public static By businessOwner= By.xpath("//tbody//tr//td[5]");
    public static By displayInPortal= By.xpath("//tbody//tr//td[6]");
    public static By manufacturer= By.xpath("//tbody//tr//td[7]");

    public static By status= By.xpath("//tbody//tr//td[8]");

    public static By ownedByTeam= By.xpath("//tbody//tr//td[9]");
    public static By autoRoute= By.xpath("//tbody//tr//td[10]");
    public static By productTechnology= By.xpath("//tbody//tr//td[12]");
    public static By technicalOwner= By.xpath("//tbody//tr//td[13]");
    public static By areaOfSupport= By.xpath("//tbody//tr//td[14]");

    public TechApp(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    }
    public void techAppRefTable() throws IOException {

        driver.get(propObj.readFromPropertiesFile("technologyAppReferences"));
    }

    public void searchTechApp(String techApplication) throws IOException {

        driver.findElement(techAppName).sendKeys(techApplication, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(techApp));
    }

    // Method to get cell values from the resulting row
//    public static List<String> getRowValues() {
//        WebElement row = driver.findElement(By.xpath("//table[@id='u_technology_app_reference_table']//tbody//tr")); // Replace with actual table XPath
//        List<WebElement> cells = row.findElements(By.tagName("td"));
//        return cells.stream().map(WebElement::getText).toList();
//    }
}
