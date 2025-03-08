package testCases.others;

import Pages.Others.TechApp;
import Utilities.others.TechAppDataProvider;
import base.basePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class techApplication extends basePage {
    WebDriver driver;
    TechApp techApplication;

    @Test(dataProvider = "techAppDataExcel", dataProviderClass = TechAppDataProvider.class)
    public void validateTableValues(String searchValue, String expectedCol1, String expectedCol2, String expectedCol3) throws IOException {
        // Step 1: Search for the value
        techApplication.searchTechApp(searchValue);

        // Step 2: Get cell values from the resulting row
//        List<String> actualValues = TechApp.getRowValues();

//        // Step 3: Validate the values with assertions
//        Assert.assertEquals(actualValues.get(0), expectedCol1, "Column 1 value mismatch!");
//        Assert.assertEquals(actualValues.get(1), expectedCol2, "Column 2 value mismatch!");
//        Assert.assertEquals(actualValues.get(2), expectedCol3, "Column 3 value mismatch!");
//    }

    }}
