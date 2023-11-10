package com.automation.orangeHRM;
import Utility.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends AbstractPage {

    WebDriver driver;
    By nameField = By.name("username");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.cssSelector("button[type='submit']");

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void enterUserName(String uName){
        userName.sendKeys(uName);//page factory
        verifyElementIsDisplayed(nameField);
        WebElement elm =driver.findElement(nameField);//by code
    }

    public void enterPassword(String pass){
       // driver.findElement(passwordField).sendKeys(password);
        password.sendKeys(pass);
        try {
            getScreenshot();
        }catch (Exception e){

        }
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}
