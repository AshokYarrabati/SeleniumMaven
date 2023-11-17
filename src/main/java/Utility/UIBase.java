package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class UIBase extends Hooks {


    public static WebDriver driver;
    public static ThreadLocal<WebDriver> Tdriver = new ThreadLocal<>();
    public static void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Tdriver.set(driver);
        driver.manage().window().maximize();
    }

    @BeforeClass(alwaysRun=true)
    public void launchDriver(){
        startChromeBrowser();
        driver.get(ConfigReader.getProperties().getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass(alwaysRun=true)
    public void quitDriver() {
        driver.quit();
    }

}
