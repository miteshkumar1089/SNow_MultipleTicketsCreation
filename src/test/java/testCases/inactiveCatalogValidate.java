package testCases;

import Pages.InaciveCatalogItem;
import Pages.LoginPage;
import base.basePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class inactiveCatalogValidate extends basePage {

    loginPage login;
    InaciveCatalogItem inactiveCatItem;

    @Test
    public void validateCatalogItem() throws IOException {

        login = new loginPage();
        login.validateUserIsAbletoLogin();

        inactiveCatItem = new InaciveCatalogItem(driver);

        inactiveCatItem.maintainItemTable();
        inactiveCatItem.searchCatalog("Unknown Incident Type");
        String activeActualValue= inactiveCatItem.activeStatus();
        String activeExpectedValue= "false";
        Assert.assertEquals(activeActualValue,activeExpectedValue,"Catalog Item is not set inactive");
    }

}
