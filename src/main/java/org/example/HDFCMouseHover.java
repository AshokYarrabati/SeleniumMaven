package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class HDFCMouseHover {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        //wait for certain period of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        //WebElement saveOption = driver.findElement(By.xpath("//li[@id='webSave']"));
//        List<WebElement> allLinks = driver.findElements(By.tagName("li"));
//        System.out.println("li size on page"+allLinks.size());
//        allLinks.forEach(WebElement::getText);
        Actions actions = new Actions(driver);
        //actions.moveToElement(saveOption).build().perform();
        WebElement sourceItem = driver.findElement(By.id("column-a"));
        WebElement dest = driver.findElement(By.id("column-b"));
        Thread.sleep(3);
        actions.dragAndDrop(sourceItem,dest);
        Thread.sleep(6);
        //driver.findElement(By.linkText("Savings Accounts")).click();
//        String title= driver.getTitle();
//        System.out.println("Title of the page is"+title);
//
//        TakesScreenshot screenshot = (TakesScreenshot)driver;
//        File source = screenshot.getScreenshotAs(OutputType.FILE);
//        File destFile=new File("C:\\screenshots\\SavingAccounts.png");
//        try {
//            FileUtils.copyFile(source, destFile);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        driver.close();
    }
}
