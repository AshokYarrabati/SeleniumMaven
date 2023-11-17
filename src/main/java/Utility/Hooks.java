package Utility;

import org.apache.hc.client5.http.utils.Base64;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Hooks {

    public static ThreadLocal<String> testCaseName = new ThreadLocal<>();
    @BeforeSuite(alwaysRun = true)
    public void setUpData(ITestContext context){
        String suiteName = context.getCurrentXmlTest().getSuite().getName();
        ReporterLog.initializeReporter(suiteName);
    }

    @BeforeMethod
    public void setTest(Method method) {
        String testCase = method.getAnnotation(Test.class).testName();
        testCaseName.set(testCase);
        ReporterLog.createTest(testCaseName.get());
        ReporterLog.assignCategory(testCaseName.get());
        System.out.println("created test case name is" + testCase);
        System.out.println("created test case name"+testCaseName.get());
    }

//    @AfterMethod
//    public void getResult(ITestResult result){
//        String executionResult=null;
//        if(result.getStatus()==ITestResult.FAILURE){
//            WebDriver driver = UIBase.driver;
//
//            executionResult="fail";
//        }
//
//
//    }

    @AfterMethod()
    public void getResult(ITestResult result) {
        String status = "";
        if (result.getStatus() == ITestResult.FAILURE) {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.75f), 1000)).takeScreenshot(UIBase.Tdriver.get());
            String base64Img = null;
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ImageIO.write(screenshot.getImage(), "PNG", out);
                byte[] bytes = out.toByteArray();
                base64Img = Base64.encodeBase64String(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ReporterLog.attachScreenshot(base64Img, "failed screenshot");
            ReporterLog.logTestFailure(result);
            status = "Fail";
            result.getThrowable().printStackTrace();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            status = "Pass";
        } else if (result.getStatus() == ITestResult.SKIP) {
            status = "skip";
        }

        System.out.println("Test result:"+status+testCaseName.get());

    }

    @AfterSuite(alwaysRun = true)
    public void flushTheReport() throws IOException {
        ReporterLog.flushReport();
        File file = new File(ReporterLog.filePath.get());
        Desktop desktop =Desktop.getDesktop();
        desktop.browse(file.toURI());
    }


}