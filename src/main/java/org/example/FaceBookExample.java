package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FaceBookExample {

    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        //wait for certain period of time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://www.facebook.com");
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.name("firstname")).sendKeys("ABCSD");
        driver.findElement(By.name("lastname")).sendKeys("cbcn");
        driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@type='password' and @data-type='password']")).sendKeys("Hello123");

        WebElement dayList=driver.findElement(By.xpath("//select[@aria-label='Day']"));
        Select select=new Select(dayList);
        select.selectByIndex(1);
        //select.selectByVisibleText("21");
        WebElement monthList = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select monthSelect = new Select(monthList);
        monthSelect.selectByVisibleText("Nov");

        WebElement yearList = driver.findElement(By.xpath("//select[@aria-label='Year']"));
        Select yearSelect = new Select(yearList);
        yearSelect.selectByValue("1996");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.name("websubmit")).click();




    }
}
