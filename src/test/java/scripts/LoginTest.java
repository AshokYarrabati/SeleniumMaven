package scripts;

import Utility.ConfigReader;
import Utility.UIBase;
import com.automation.orangeHRM.DashBoardPage;
import com.automation.orangeHRM.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends UIBase {

    @Test(testName = "Login to the Orange HRM application",priority = 0,groups = "{smoke}")
    public void loginToApplication(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(ConfigReader.getProperties().getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperties().getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test(testName = "Validate Dashboard page is loaded",priority = 1,groups = "{Regression}")
    public void validateDashBoardPage(){
        DashBoardPage boardPage = new DashBoardPage(driver);
        boardPage.validateDashBoardPageLoaded();
    }

    @Test(testName="Apply Leave Scenario")
    public void applyLeave(){

    }



}
