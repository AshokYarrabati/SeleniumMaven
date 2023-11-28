package Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    WebDriver driver;

    long seconds = Long.parseLong(ConfigReader.getProperties().getProperty("implicitWaitInSeconds"));

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

    public void waitForElementToBeDisplayed(By element){
        Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public void waitForElementToBeDisplayedUSingFluentWait(WebElement el){
        Wait<WebDriver> driver = new FluentWait<>(UIBase.Tdriver.get())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driver.until(ExpectedConditions.visibilityOf(el));
    }

    public void waitForElementToBeClickable(WebElement element){
        Wait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickUsingJSE(WebElement e){
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",e);
    }

    public void clickUsingJSEUsingByLocator(By e){
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",e);
    }

    public void enterUserNameUsingJSE(WebElement element, String user){
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='admin'",element);

    }

    public void selectItemFromListBox(WebElement element, String itemToSelect){
        Select select = new Select(element);
        List<WebElement> allItems = select.getOptions();
        for(WebElement el:allItems){
            if(el.getText().equalsIgnoreCase(itemToSelect)){
                el.click();
            }
        }

        for( int i =0;i<allItems.size();i++){
            if(allItems.get(i).getText().equalsIgnoreCase(itemToSelect)){
                allItems.get(i).click();
            }
        }
        allItems.stream().filter(e-> e.getText().equalsIgnoreCase(itemToSelect)).findFirst().get().click();
    }






}
