package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;
import java.util.Set;


public class HandlingMultipleTabs {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("(//a[@title='MNC'])[2]")).click();
        Set<String> allHandles = driver.getWindowHandles();
//        Alert alert = driver.switchTo().alert();
//        driver.findElement(By.id("userName")).sendKeys("Admin");
//        driver.findElement(By.id("password")).sendKeys("Admin");
//        driver.switchTo().alert().accept();
//        driver.switchTo().window(parentWindow);
//        driver.switchTo().alert().dismiss();
//        alert.accept();
//        alert.dismiss();
        for(String s:allHandles){
            if(!parentWindow.equals(s)){
                driver.switchTo().window(s);
                System.out.println("Driver title after switched to child window"+driver.getTitle());
                driver.findElement(By.xpath("//label[@for='chk-Corporate-qbusinessSize-']/i")).click();
                Thread.sleep(7);
                TakesScreenshot screenshot= (TakesScreenshot)driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("C:\\screenshots\\naukri.png"));
                driver.close();


            }
        }
        driver.switchTo().window(parentWindow);
        String parentTitle = driver.getTitle();
        System.out.println("Parent title is"+parentTitle);
        driver.close();





    }

}
