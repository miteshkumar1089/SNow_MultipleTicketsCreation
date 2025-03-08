package StepDefinition;

import Pages.*;
import Utilities.DataFactory;
import base.Hooks;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static base.basePage.test;

public class specificsForm {

    public static DataFactory data = new DataFactory();

    public WebDriver driver = Hooks.getDriver();
    ExtentTest test = Hooks.test;  // Get ExtentTest instance from Hooks
    OrderGuideFirstPage ogFirstPage= new OrderGuideFirstPage(driver);

    SpecificTicketCreationAccessToOSYDApps specificItem= new SpecificTicketCreationAccessToOSYDApps(driver);
    SpecificTicketCreationProviderAssignement specificItem2 = new SpecificTicketCreationProviderAssignement(driver);
    SpecificsBrokenKeyMouOrderGuideNextPage specificItem3 = new SpecificsBrokenKeyMouOrderGuideNextPage(driver);
    SpecificsEmailPassResetOrderGuideNextPage specificItem4 = new SpecificsEmailPassResetOrderGuideNextPage(driver);

    @Then("User fills specifics details for {string} item")
    public void user_fills_specifics_details_for_item(String catalogItem) throws InterruptedException {

        if (catalogItem.equalsIgnoreCase("Access to OSYD Apps")) {
            specificItem.getDataReportName("ALCs");
            specificItem.clickDateRequested();
            specificItem.clickDesiredDate();
            specificItem.clickDueDate();
            specificItem.clickDesiredDueDate();
        } else if (catalogItem.equalsIgnoreCase("Provider Assignment")) {
            specificItem2.getCategory("Provider can't bill");
            specificItem2.getSubCategory("Provider can't bill because of duplicate services");
            specificItem2.getSchoolAge("Preschool");
        } else if (catalogItem.equalsIgnoreCase("Broken keyboard or Mouse")) {
            specificItem3.inputDev("Mouse");
            specificItem3.brokenMouse("Yes");
            specificItem3.securityDev("Yes");
            specificItem3.securityKey("Testing for Security key name");
            specificItem3.osOption("Mac 10.10x");
        } else if (catalogItem.equalsIgnoreCase("Email Password Reset")) {
            specificItem4.userID("Yes");
            specificItem4.lastLoginTime("Testing for lastLogin time");
            specificItem4.deviceOp("No");
            specificItem4.browserOp("Yes");
        }
    }

    @Then("User validates tech app")
    public void user_validates_tech_app() throws InterruptedException {
       data.techAppMandatoryFlag= ogFirstPage.getTechAppFlag();
       data.techAppValue= ogFirstPage.getTechAppValue();
       WebElement technologyApplication= ogFirstPage.techAppField();

        if(data.techAppMandatoryFlag.equalsIgnoreCase("false"))
        {
            System.out.println("Tech App field is not mandatory to fill");
        }
        else if (data.techAppMandatoryFlag.equalsIgnoreCase("true") && (!data.techAppValue.isEmpty()))
        {
            System.out.println("Tech App field is auto-filled");
        }
        else
        {
            Select selectAreaOfSupport = new Select(ogFirstPage.setAreaOfSupportValue());
            Thread.sleep(2000);
            selectAreaOfSupport.selectByVisibleText("Hardware");
            Thread.sleep(2000);
            technologyApplication.sendKeys("Apple TV");
            technologyApplication.sendKeys(Keys.ENTER);
        }

    }
}