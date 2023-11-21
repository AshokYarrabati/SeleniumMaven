package shoppingModule.scripts;

import Utility.ConfigReader;
import Utility.UIBase;
import com.automation.orangeHRM.DashBoardPage;
import com.automation.orangeHRM.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends UIBase {

    @Test(testName = "Login to the Orange HRM application",groups = "{smoke}")
    @Parameters({"username"})
    public void loginToApplication(String uName){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(uName);
        loginPage.enterPassword(ConfigReader.getProperties().getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test(testName = "Validate Dashboard page is loaded",dependsOnMethods = "loginToApplication")
    public void validateDashBoardPage(){
        DashBoardPage boardPage = new DashBoardPage(driver);
        boardPage.validateDashBoardPageLoaded();
    }

    @Test(enabled = false,testName="Apply Leave Scenario",dependsOnMethods = "{validateDashBoardPage}")
    public void applyLeave(){
        System.out.println("Applying leave");
    }



}
