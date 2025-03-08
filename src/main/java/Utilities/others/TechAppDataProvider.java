package Utilities.others;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TechAppDataProvider {
        public static List<Object[]> getExcelData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header
                Row row = sheet.getRow(i);
                Object[] rowData = new Object[row.getLastCellNum()];
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    rowData[j] = row.getCell(j).toString();
                }
                data.add(rowData);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "tableData")
    public Object[][] getData() {
        List<Object[]> data = TechAppDataProvider.getExcelData("C://Users//miteshkumar//IdeaProjects//SNow_MultipleTicketsCreation//src//main//resources//data//techAppDataExcel.xlsx", "Sheet1");
        return data.toArray(new Object[0][0]);
    }
        }
 

