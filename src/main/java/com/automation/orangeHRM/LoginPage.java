package com.automation.orangeHRM;
import Utility.AbstractPage;
import Utility.ReporterLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;

public class LoginPage extends AbstractPage {

    WebDriver driver;
    By nameField = By.name("username");
//    By passwordField = By.xpath("//input[@name='password']");
//    By loginButton = By.cssSelector("button[type='submit']");

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void enterUserName(Object uName){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(11));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        userName.sendKeys(String.valueOf(uName));//page factory
        Reporter.log("UserName is entered as "+uName,true);
        ReporterLog.logInfo("USername entered as"+uName);
        verifyElementIsDisplayed(userName);
    }

    public void enterPassword(Object pass){
       // driver.findElement(passwordField).sendKeys(password);
        password.sendKeys(String.valueOf(pass));
        Reporter.log("password is entered as "+pass,true);
        ReporterLog.logInfo("password entered as"+pass);
        ReporterLog.attachScreenshot(getScreenshot());
    }

    public void clickLoginButton(){
        loginBtn.click();
        Reporter.log("clicked on login button "+loginBtn.toString(),true);
        ReporterLog.logInfo("clicked on login button");
    }

}
