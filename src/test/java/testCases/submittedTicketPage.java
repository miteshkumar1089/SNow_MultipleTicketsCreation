package testCases;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.OrderGuideNextPage;
import Pages.SubmittedTicketPage;
import Utilities.ExcelDataProvider;
import base.basePage;

public class submittedTicketPage extends basePage{	
	
	
	SubmittedTicketPage ticketPage;
	orderGuideNextPage ogNextPage;
		
//	@DataProvider(name = "CatalogProvider")
//	public Object[][] getDataFromDataprovider() {
//		return new Object[][] { { "Access to a public folder"}, { "Report a Stolen Device"}, { "Access to Network"} };
//	}
//	@Test(dataProvider = "CatalogProvider")
	
	@Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
	public void validatingUserIsAbleToFillDetailsAndSubmitInOrderGuideNextPage(String catalogSearch) throws IOException, InterruptedException {
		test.log(LogStatus.INFO,"Ticket created for catalog item " + catalogSearch);
		ticketPage= new SubmittedTicketPage(driver);
		ogNextPage=new orderGuideNextPage();
		ogNextPage.validatingUserIsAbleToFillDetailsAndSubmitInOrderGuideNextPage(catalogSearch);
		String ticketNumber= ticketPage.getTicketNumber();
		System.out.println(ticketNumber);
		test.log(LogStatus.INFO,ticketNumber);
	}

}

