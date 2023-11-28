package tests;

import Utility.ConfigReader;
import Utility.UIBase;
import learning.OrangeHRMDashBoardPage;
import learning.OrangeHRMLoginPage;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginValidationTest extends UIBase {

    Properties properties = ConfigReader.getProperties();
    OrangeHRMLoginPage loginPage;
    OrangeHRMDashBoardPage dashBoardPage;

    @Test(testName = "Validate login to Orange HRM is successful")
    public void loginToOrangeHRMApplication(){
        loginPage = new OrangeHRMLoginPage(driver);
        dashBoardPage = new OrangeHRMDashBoardPage(driver);
        loginPage.doLogin(properties.getProperty("userName"),properties.getProperty("password"));
    }

    @Test(testName = "validate dashboard page is loaded",dependsOnMethods = "loginToOrangeHRMApplication")
    public void validateDashBoardPageLoaded(){
        dashBoardPage.ValidateAdminNameDisplayed();
    }
}
