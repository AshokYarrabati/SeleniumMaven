package scripts;

import org.testng.annotations.*;

public class TestNgDemo {

    //@BeforeSuite--->(Initializing the  extent report/allure code)
    //@BeforeTest---->it will be executed only once(WebDriver code define, launching the url)
    //@BeforeClass---->it will be executed only once
    //@BeforeMethod-->this will be executed before each test to get the test case name
    //@AfterMethod--->this will be executed after each test to see the status of the test(pass/fail)
    //@AfterClass-->it will be executed only once
    //@AfterTest--->in this annotation we are closing the webdriver object(quit)
    //@AfterSuite-->(report flushing after logging all the statements)

    @Test(priority = -1)
    public void test1() {
        System.out.println("Test Case 1");
    }// Test Case 2
    @Test
    public void test2() {
        System.out.println("Test Case 2");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
