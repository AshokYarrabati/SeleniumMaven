package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelUtils {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream inputStream;
    String filePath;
    public ExcelUtils(String filePath){
        try {
            this.filePath=filePath;
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet("LoginCredentials");
        }catch (Exception e){
            ReporterLog.logFail("Unable to create workbook object");
        }
    }
    public Map<String, String > getTestData() throws IOException {
        Map<String, String> data = new LinkedHashMap<>();
        try {
            //workbook = new XSSFWorkbook(inputStream);
            //sheet = workbook.getSheet("LoginCredentials");
            int rows = sheet.getLastRowNum()-sheet.getFirstRowNum();

            for(int i =1;i<=rows;i++){
                int colCount = sheet.getRow(i).getPhysicalNumberOfCells();
                for( int j=1;j<colCount;j++){
                    String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                    data.put(sheet.getRow(i).getCell(0).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());
                    System.out.println(cellValue);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeWorkBookObject(filePath);
        }
        return data;
    }

    public void closeWorkBookObject(String filePath) throws IOException {
        ExcelUtils utils = new ExcelUtils(filePath);
        utils.inputStream.close();
    }
}
