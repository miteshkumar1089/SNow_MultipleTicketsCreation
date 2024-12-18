package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.OrderGuideFirstPage;
import Utilities.ExcelDataProvider;
import base.basePage;

public class orderGuideFirstPage extends basePage {

	loginPage login;
	OrderGuideFirstPage ogFirstPage;

	// @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
	
//	@DataProvider(name = "CatalogProvider")
//	public Object[][] getDataFromDataprovider() {
//		return new Object[][] { { "Access to a public folder"}, { "Report a Stolen Device"}, { "Access to Network"} };
//	}
	@Test
	public void validatingUserIsAbleToFillDetailsInOrderGuideFirstPage(String catalogSearch) throws IOException, InterruptedException {
		login = new loginPage();
		login.validateUserIsAbletoLogin();

		ogFirstPage = new OrderGuideFirstPage(driver);

		data.cssvalue = ogFirstPage.issueDetailsCSSValue();
		System.out.println(data.cssvalue);
		System.out.println(ogFirstPage.issueDetailsAttributeValue());
		ogFirstPage.getRequestor("Mkumar6");
		ogFirstPage.getMultilingual("yes", "Bengali");
		ogFirstPage.getSource("Outbound Call");
		ogFirstPage.getReportedFor("251383634");
		ogFirstPage.getSite("X001@X001");
		ogFirstPage.addDescription("First Test Case");
		ogFirstPage.getCatalog(catalogSearch);
		//ogFirstPage.getAreaOfSupport("Software");
		//ogFirstPage.getTechApp("Z Scaler");
		ogFirstPage.clickNextButton();

	}
}
