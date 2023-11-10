package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class AmazonExample {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in");
        //wait for certain period of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        WebElement bestSellerLink = driver.findElement(By.partialLinkText("Sellers"));
        bestSellerLink.click();
        String titleName =driver.getTitle();

        System.out.println("page title after clicked on best seller "+titleName);
        driver.findElement(By.linkText("Apps for Android")).click();
        String andriodTitleName =driver.getTitle();
        System.out.println("the current URL is"+driver.getCurrentUrl());

        System.out.println("page title after clicked on Apps for Android "+andriodTitleName);
        driver.close();

        List<WebElement> allCheckBoxes=driver.findElements(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));
        allCheckBoxes.stream().forEach(e->e.click());

        //List<WebElement> allTags=driver.findElements(By.tagName("a"));

//        System.out.println(allTags.size());
//
//        for (WebElement element:allTags){
//            System.out.println(element.getText());
//        }
    }


}
