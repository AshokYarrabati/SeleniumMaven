package shoppingModule.scripts;

import Utility.ConfigReader;
import Utility.ExcelUtils;
import Utility.FilePath;
import Utility.UIBase;
import com.automation.orangeHRM.DashBoardPage;
import com.automation.orangeHRM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class ReadTestDataFromExcel {

    @Test(testName = "LogintoApp with different creds", dataProvider = "DataSupply")
    public void getTestDataFromExcel(String uname, String password) {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            //Tdriver.set(driver);
            driver.get(ConfigReader.getProperties().getProperty("URL"));
            driver.manage().window().maximize();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName(uname);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
            DashBoardPage dashBoardPage = new DashBoardPage(driver);
            dashBoardPage.validateDashBoardPageLoaded();
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @DataProvider(name = "DataSupply")
    public Object[][] doLoginWithDifferentSets() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils(FilePath.excelPath);
        Map<String, String> mapData = excelUtils.getTestData();
        for (Map.Entry<String, String> data : mapData.entrySet()) {
            getTestDataFromExcel(data.getKey(), data.getValue());
        }
        return null;

    }
}
