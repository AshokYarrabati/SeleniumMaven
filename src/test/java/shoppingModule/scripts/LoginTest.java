package shoppingModule.scripts;

import Utility.ConfigReader;
import Utility.UIBase;
import com.automation.orangeHRM.DashBoardPage;
import com.automation.orangeHRM.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends UIBase {

    Properties properties;

    @Test(testName = "Login to the Orange HRM application")
    public void loginToApplication(){
        System.out.println("Thread===>"+Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(Tdriver.get());
        properties = ConfigReader.getProperties();
        loginPage.enterUserName(properties.getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperties().getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Test(testName = "Validate Dashboard page is loaded",dependsOnMethods = "loginToApplication")
    public void validateDashBoardPage(){
        System.out.println("Thread===>"+Thread.currentThread().getId());
        DashBoardPage boardPage = new DashBoardPage(Tdriver.get());
        boardPage.validateDashBoardPageLoaded();
    }

    @Test(enabled = false,testName="Apply Leave Scenario",dependsOnMethods = "{validateDashBoardPage}")
    public void applyLeave(){
        System.out.println("Applying leave");
    }



}
