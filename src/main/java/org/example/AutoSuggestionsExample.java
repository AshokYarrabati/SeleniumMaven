package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionsExample {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/auto-complete/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
       WebElement iframe= driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search"))).sendKeys("a");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("a");
        Thread.sleep(10);

        List<WebElement> allSuggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        for(int i=0;i<allSuggestions.size();i++){
            if(allSuggestions.get(i).getText().equals("antal")){
                allSuggestions.get(i).click();
            }
        }
//        for(WebElement element:allSuggestions){
//            if(element.getText().equals("antal")){
//                element.click();
//            }
//        }

        allSuggestions.stream().filter(e->e.getText().equals("antal")).findFirst().get().click();
    }
}
