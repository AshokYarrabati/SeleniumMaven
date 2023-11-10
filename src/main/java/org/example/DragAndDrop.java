package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        openBrowser(driver);
        //wait for certain period of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Actions actions = new Actions(driver);
//        WebElement sourceItem = driver.findElement(By.id("column-a"));
//        WebElement dest = driver.findElement(By.id("column-b"));
        WebElement checkBox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        actions.click(checkBox).build().perform();
        actions.contextClick(checkBox).build().perform();
        closeBrowser(driver);

//        Action dragAndDrop =actions.clickAndHold(sourceItem)
//                .moveToElement(dest)
//                .release(dest)
//                .build();
//        dragAndDrop.perform();

    }

    public static void openBrowser(WebDriver driver){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public static void closeBrowser(WebDriver driver){
        driver.close();
    }


}
