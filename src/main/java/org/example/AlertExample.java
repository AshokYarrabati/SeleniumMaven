package org.example;

import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertExample {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        //driver.findElement(By.id("OKTab")).click();
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.id("Textbox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert name is "+alert.getText());
        driver.findElement(By.id("demo")).sendKeys("Demo");
        alert.dismiss();
        String text= driver.findElement(By.id("demo")).getText();
        System.out.println("text displayed as "+text);
        if(text.equals("You Pressed Cancel")){
            System.out.println("Text matched expected displayed--->Pass");
        }
    }
}
