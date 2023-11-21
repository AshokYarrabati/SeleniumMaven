package shoppingModule.scripts;

import Utility.ExcelUtils;
import org.testng.annotations.Test;

public class ReadTestDataFromExcel {
    
    @Test(testName="Read test data from excel sheet")
    public void getTestDataFromExcel(){

        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.getTestData();

    }
}
