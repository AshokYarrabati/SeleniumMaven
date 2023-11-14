package com.automation.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class DashBoardPage {

    WebDriver driver;
    By leaveRequest = By.xpath("//p[text()=' (13) Leave Requests to Approve']");
    By dashBoard = By.xpath("//h6[text()='Dashboard']");

    public DashBoardPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnLeaveRequest(){
        driver.findElement(leaveRequest).click();
    }

    public void validateDashBoardPageLoaded(){
        try {
            WebElement element = driver.findElement(dashBoard);
            Assert.assertTrue(element.isDisplayed(), "Dash board is did not display");
            Reporter.log("DashBoard is displayed", true);
        }catch(NoSuchElementException e){
            Reporter.log("Dashboard page is not displayed for invalid credentials");
        }
    }
}
