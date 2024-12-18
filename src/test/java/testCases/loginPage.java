package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.basePage;
import Pages.LoginPage;

public class loginPage extends basePage {
	
	LoginPage login;
	
	@Test
	public void validateUserIsAbletoLogin() throws IOException {
		
		login=new LoginPage(driver);
		login.fillingLoginDetails("Mkumar6", "Default@1234");
				
		data.currentURL= driver.getCurrentUrl();
		data.expectedURL= "https://nycdoedev2.service-now.com/com.glideapp.servicecatalog_cat_item_guide_view.do?v=1&sysparm_initial=true&sysparm_guide=1a602a171bfb2c10ec6254ea234bcbf6";
		Assert.assertEquals(data.currentURL, data.expectedURL, "Not landed to home page");
		
	}
}
