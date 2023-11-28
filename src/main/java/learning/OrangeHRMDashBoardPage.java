package learning;

import Utility.AbstractPage;
import Utility.ReporterLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrangeHRMDashBoardPage extends AbstractPage {

    @FindBy(xpath = "//p[text()='Paul Collings']")
    WebElement adminName;

    public OrangeHRMDashBoardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void ValidateAdminNameDisplayed(){
        waitForElementToBeDisplayedUSingFluentWait(adminName);
        ReporterLog.attachScreenshot(getScreenshot());
        Assert.assertTrue(adminName.isDisplayed(),"Admin name is not displayed");
        ReporterLog.logPass("Admin name is shown up");
    }
}
