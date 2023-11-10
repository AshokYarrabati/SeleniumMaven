package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;

public class Hooks {

    @BeforeMethod
    public void setTest(Method method){
        String testCase = method.getAnnotation(Test.class).testName();
        System.out.println("created test case name is"+testCase);
    }

    @AfterMethod
    public void getResult(ITestResult result){
        String executionResult=null;
        if(result.getStatus()==ITestResult.FAILURE){
            WebDriver driver = UIBase.driver;

            executionResult="fail";
        }


    }
}
