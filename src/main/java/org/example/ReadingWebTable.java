package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ReadingWebTable {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='countries']//tr"));

        for(int i =0;i<allRows.size();i++){
            boolean found=false;

            if(found){
                break;
            }

            List<WebElement> cols= driver.findElements(By.xpath("//table[@id='countries']//tr["+(i+1)+"]/td"));

            for(int k=0;k<cols.size();k++){
                String data = cols.get(k).getText();
                if(data.equals("Ashok")){
                    System.out.println("Name found Test case passed");
                    found=true;
                    break;
                }
                System.out.println("data from webtable"+data);
            }


        }

    }
}
