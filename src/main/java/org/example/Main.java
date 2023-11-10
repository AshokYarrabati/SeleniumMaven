package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //WebDriverManager.chromedriver().setup();
        WebDriver webDriver=new ChromeDriver();
        //to navigate to URL
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //to maxmimoze the browser
        webDriver.manage().window().maximize();
        //wait for certain period of time
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
       //finding element on page
       WebElement username= webDriver.findElement(By.name("username"));
       //for edit boxes we should use send keys to enter the data in input field
        username.sendKeys("Admin");
        username.clear();
        String errorMessage =webDriver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText();
        System.out.println("Error message displayed on console as"+errorMessage);
        username.sendKeys("Admin");
       // webDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
       WebElement password = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
       password.sendKeys("admin123");
       //here we are calling click method directly
       webDriver.findElement(By.xpath("//button[@type='submit']")).click();
       //here storing the WebElement ref and calling te mehtod on top of it
        WebElement login = webDriver.findElement(By.xpath("//button[@type='submit']"));
        login.click();


       //xpath Synatx-->//htmlelement[@attributename=attributeValue]
    }
}