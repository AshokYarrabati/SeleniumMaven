package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHandler {

    public  WebDriver getWebDriverObject(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        return driver;
    }
}
