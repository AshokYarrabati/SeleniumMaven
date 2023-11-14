package scripts;
import Utility.UIBase;
import com.automation.orangeHRM.DashBoardPage;
import com.automation.orangeHRM.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends UIBase  {

    @Test(dataProvider ="testData" )
    public void doLogin(String uname, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(uname);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.validateDashBoardPageLoaded();
    }

    @DataProvider(name="testData")
    public Object[][] sendTestDataToTC(){

        Object[][] object=new Object[3][2];
        object[0][0]="Admin";
        object[0][1]="admin123";
        object[1][0]="Admin";
        object[1][1]="admin";
        object[2][0]="Admin123";
        object[2][1]="admin123";
        return object;


    }
}
