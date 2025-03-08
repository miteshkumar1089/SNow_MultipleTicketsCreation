package testCases;

import Pages.*;
import base.basePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class specificFormCreateTicket extends basePage {
    LoginPage login;
    OrderGuideFirstPage ogFirstPage;
    OrderGuideNextPage ogNextPage;
    SubmittedTicketPage ticketPage;
    //SpecificsBrokenKeyMouOrderGuideNextPage specific;
    SpecificTicketCreationAccessToOSYDApps specificItem;
    SpecificTicketCreationProviderAssignement specificItem2;
    SpecificsBrokenKeyMouOrderGuideNextPage specificItem3;
    SpecificsEmailPassResetOrderGuideNextPage specificItem4;


    @BeforeMethod
    public void preRequisites() throws IOException, InterruptedException {
        login = new LoginPage(driver);
        ogFirstPage = new OrderGuideFirstPage(driver);
        ogNextPage = new OrderGuideNextPage(driver);
        ticketPage = new SubmittedTicketPage(driver);

        login.fillingLoginDetails("Mkumar6", "Default@1234");
        test.log(LogStatus.INFO, "User fill the login Credential as " + "UserID :-" + "Mkumar6" + " and Password :- " + "*****1234");
        data.currentURL = driver.getCurrentUrl();
        Assert.assertEquals(data.currentURL, data.expectedURL, "Not landed to home page");

        data.cssvalue = ogFirstPage.issueDetailsCSSValue();
        System.out.println(data.cssvalue);
        System.out.println(ogFirstPage.issueDetailsAttributeValue());
        ogFirstPage.getRequestor("Mkumar6");
        ogFirstPage.getMultilingual("yes", "Bengali");
        ogFirstPage.getSource("Outbound Call");
        ogFirstPage.getReportedFor("251383634");
        ogFirstPage.getSite("X001@X001");
        ogFirstPage.addDescription("First Test Case");

    }

    @AfterMethod
    public void postRequisites(){
        ogNextPage.submitTicket();
        test.log(LogStatus.INFO, "Validating the testcases");
        String ticketNumber = ticketPage.getTicketNumber();
        System.out.println(ticketNumber);
        test.log(LogStatus.INFO, ticketNumber);

    }

    @Test (enabled=true)
    public void validateThatUserIsAbleToSubmitSpecificFormForAccessToOSYDApps() throws IOException, InterruptedException {

        specificItem = new SpecificTicketCreationAccessToOSYDApps(driver);
        test.log(LogStatus.INFO,"Ticket created for catalog item - Access to OSYD Apps");
        ogFirstPage.getCatalog("Access to OSYD Apps");
        ogFirstPage.clickNextButton();
        specificItem.getDataReportName("ALC");
        specificItem.clickDateRequested();
        specificItem.clickDesiredDate();
        specificItem.clickDueDate();
        specificItem.clickDesiredDueDate();
    }

    @Test (enabled=false)
    public void validateThatUserIsAbleToSubmitSpecificFormForProviderAssignment() throws IOException, InterruptedException {

        specificItem2 = new SpecificTicketCreationProviderAssignement(driver);
        test.log(LogStatus.INFO,"Ticket created for catalog item - Provider Assignment");
        ogFirstPage.getCatalog("Provider Assignment");
        ogFirstPage.clickNextButton();
        specificItem2.getCategory("Provider can't bill");
        specificItem2.getSubCategory("Provider can't bill because of duplicate services");
        specificItem2.getSchoolAge("Preschool");
    }

   @Test(enabled=false)
    public void validatingUserIsAbleToSubmitSpecificFormForBrokenMouse() throws IOException, InterruptedException {

        specificItem3 = new SpecificsBrokenKeyMouOrderGuideNextPage(driver);
        test.log(LogStatus.INFO,"Ticket created for catalog item - Broken keyboard or Mouse");
        ogFirstPage.getCatalog("Broken keyboard or Mouse");
        ogFirstPage.clickNextButton();
        specificItem3.inputDev("Mouse");
        specificItem3.brokenMouse("Yes");
        specificItem3.securityDev("Yes");
        specificItem3.securityKey("Testing for Security key name");
        specificItem3.osOption("Mac 10.10x");
    }


    @Test(enabled=false)
    public void validatingUserIsAbleToSubmitSpecificFormForEmailPasswordReset() throws IOException, InterruptedException {

        specificItem4 = new SpecificsEmailPassResetOrderGuideNextPage(driver);
        test.log(LogStatus.INFO,"Ticket created for catalog item - Email Password Reset");
        ogFirstPage.getCatalog("Email Password Reset");
        ogFirstPage.clickNextButton();
        specificItem4.userID("Yes");
        specificItem4.lastLoginTime("Testing for lastLogin time");
        specificItem4.deviceOp("No");
        specificItem4.browserOp("Yes");
    }
}