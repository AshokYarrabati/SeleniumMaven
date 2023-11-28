package com.automation.orangeHRM;

import Utility.AbstractPage;
import Utility.ReporterLog;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class DashBoardPage extends AbstractPage {

    WebDriver driver;
    By leaveRequest = By.xpath("//p[text()=' (13) Leave Requests to Approve']");
    By dashBoard = By.xpath("//h6[text()='Dashboard']");

    public DashBoardPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void clickOnLeaveRequest(){
        driver.findElement(leaveRequest).click();
    }

    public void validateDashBoardPageLoaded(){
        try {
            WebElement element = driver.findElement(dashBoard);
            Assert.assertTrue(element.isDisplayed(), "Dash board is did not display");
            ReporterLog.attachScreenshot(getScreenshot());
            Reporter.log("DashBoard is displayed", true);
            ReporterLog.logPass("DashBoard is displayed");
        }catch(NoSuchElementException e){
            Reporter.log("Dashboard page is not displayed for invalid credentials");
            ReporterLog.logFail("DashBoard page did not display");
        }
    }
}
