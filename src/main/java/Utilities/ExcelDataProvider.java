package Utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
	
    @DataProvider(name = "excelData")
    public Object[][] getDataFromExcel() throws IOException {
        String excelFilePath = "C://Users//miteshkumar//IdeaProjects//SNow_MultipleTicketsCreation//src//main//resources//data//excelData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
 
        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][1]; // Catalog Item, Service Group and category columns
 
        int dataIndex = 0;
 
        for (int i = 1; i < rowCount; i++) { // Skip header row
            Row row = sheet.getRow(i);
            String status = row.getCell(1).toString(); // Status column
            if ("yes".equalsIgnoreCase(status)) {
                data[dataIndex][0] = row.getCell(0).toString(); // catalog item
//                data[dataIndex][1] = row.getCell(1).toString(); // service group
//                data[dataIndex][2] = row.getCell(2).toString(); // category
                dataIndex++;
            }else {
                System.out.println("Skipping entry at row " + (i + 1) + " as status is 'false'.");
                // Optionally handle the 'false' case, like logging or adding a placeholder
            }
        }
 
        workbook.close();
        fileInputStream.close();
 
        // If no data is selected, skip the test
        if (dataIndex == 0) {
            System.out.println("All statuses are set to 'false', no data to run the test.");
            return new Object[0][0];
        }
 
        // Resize the array to fit the actual number of data rows
        Object[][] trimmedData = new Object[dataIndex][1];
        System.arraycopy(data, 0, trimmedData, 0, dataIndex);
 
        return trimmedData;
    }
}
