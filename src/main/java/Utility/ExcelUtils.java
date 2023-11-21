package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public void getTestData(){
        try {
            FileInputStream inputStream = new FileInputStream(FilePath.excelPath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet("LoginCredentials");
            int rows = sheet.getPhysicalNumberOfRows();

            for(int i =0;i<rows;i++){
                int colCount = sheet.getRow(i).getPhysicalNumberOfCells();
                for( int j=1;j<colCount;j++){
                    String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                    System.out.println(cellValue);
                }
            }

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
