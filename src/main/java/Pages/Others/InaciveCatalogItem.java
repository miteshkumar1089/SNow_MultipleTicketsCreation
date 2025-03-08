package Pages.Others;

import Utilities.ReadingPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class InaciveCatalogItem {
    WebDriver driver;
    WebDriverWait wait;
    ReadingPropertiesFile propObj= new ReadingPropertiesFile();

    public static By catalogField= By.xpath("//input[@id='sc_cat_item_table_header_search_control']");
    public static By catItem= By.xpath("//a[@class='linked formlink']");
    public static By activeChkbox= By.xpath("//input[@name='sc_cat_item_producer.active']");

    public InaciveCatalogItem(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds((10)));

    }
    public void maintainItemTable() throws IOException {

    driver.get(propObj.readFromPropertiesFile("maintainItemTable"));
}

    public void searchCatalog(String catalog) throws IOException {

        driver.findElement(catalogField).sendKeys(catalog,Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catItem));
        driver.findElement(catItem).click();
    }
    public String activeStatus() throws IOException {

       String activeActualVal= driver.findElement(activeChkbox).getAttribute("value");
       return activeActualVal;
    }

}
