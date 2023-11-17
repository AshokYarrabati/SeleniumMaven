package Utility;
import org.openqa.selenium.*;

public class AbstractPage {

    WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver=driver;
    }

    public String getScreenshot(){
        TakesScreenshot screenshot =(TakesScreenshot) driver;
         return screenshot.getScreenshotAs(OutputType.BASE64);

    }

    public void verifyElementIsDisplayed(WebElement e){
        if(e.isDisplayed()){
            System.out.println("WebElement is displayed");
        }else{
            System.out.println("WebElement is not displayed"+e.toString());
        }
    }


}
