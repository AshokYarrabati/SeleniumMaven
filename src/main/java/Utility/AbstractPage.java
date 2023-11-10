package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class AbstractPage {

    WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver=driver;
    }

    public void getScreenshot() throws Exception{
        TakesScreenshot screenshot =(TakesScreenshot) driver;
         File src = screenshot.getScreenshotAs(OutputType.FILE);
         File destination = new File("C:\\Users\\hp\\IdeaProjects\\SeleniumMaven\\src\\test\\java\\screenshots\\screenshot.png");
        FileUtils.copyFile(src,destination);
    }

    public void verifyElementIsDisplayed(By e){
        if(driver.findElement(e).isDisplayed()){
            System.out.println("WebElement is displayed");
        }else{
            System.out.println("WebElement is not displayed"+e.toString());
        }
    }


}
