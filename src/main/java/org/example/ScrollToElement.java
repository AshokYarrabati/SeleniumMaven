package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ScrollToElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.browserstack.com/guide/drag-and-drop-in-selenium");
        //wait for certain period of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        WebElement text=driver.findElement(By.xpath("//h1[text()='How to Drag and Drop in Selenium?']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(text).build().perform();



    }
}
