package learning;

import Utility.AbstractPage;
import Utility.ReporterLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OrangeHRMLoginPage extends AbstractPage {

    @FindBy(how= How.NAME,name = "username")
    private WebElement userName;
    @FindBy(how = How.NAME, name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public OrangeHRMLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        Reporter.log("WebElements initialized for this page");
        ReporterLog.logInfo("WebElements initialized for Login page");
    }

    public void typeUserName(String name){
        try{
            waitForElementToBeDisplayedUSingFluentWait(userName);
            userName.sendKeys(name);
        }catch (Exception e){
            e.printStackTrace();
            Reporter.log("Unable to enter username");
            ReporterLog.logFail("Unable to enter username");
        }

    }

    public void typePassword(String userPassword){
        try {
            password.sendKeys(userPassword);
        }catch (Exception e){
            e.printStackTrace();
            Reporter.log("Unable to enter Password");
            ReporterLog.logFail("Unable to enter password");
        }
    }

    public void selectLoginButton(){
        try {
            clickUsingJSE(loginBtn);
        }catch(Exception e){
            e.printStackTrace();
            Reporter.log("Unable to Click login button");
            ReporterLog.logFail("Unable to click login button");
        }
    }

    public void doLogin(String user, String password){
        typeUserName(user);
        typePassword(password);
        selectLoginButton();
    }
}
