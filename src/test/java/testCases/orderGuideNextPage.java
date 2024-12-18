package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.OrderGuideFirstPage;
import Pages.OrderGuideNextPage;
import base.basePage;

public class orderGuideNextPage extends basePage{
	
	orderGuideFirstPage ogFirstPage;
	OrderGuideNextPage ogNextPage;
	
	// @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
//	@DataProvider(name = "CatalogProvider")
//	public Object[][] getDataFromDataprovider() {
//		return new Object[][] { { "Access to a public folder"}, { "Report a Stolen Device"}, { "Access to Network"} };
//	}
   @Test
	public void validatingUserIsAbleToFillDetailsAndSubmitInOrderGuideNextPage(String catalogSearch) throws IOException, InterruptedException {
		
		ogFirstPage= new orderGuideFirstPage();
		ogFirstPage.validatingUserIsAbleToFillDetailsInOrderGuideFirstPage(catalogSearch);
		
		ogNextPage= new OrderGuideNextPage(driver);
		
		ogNextPage.submitTicket();
	}
	
}
