package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.google.common.base.Throwables;
import org.testng.Assert;
import org.testng.ITestResult;

public class ReporterLog {

    static ExtentReports reports;
    static ExtentTest extentTest;

    public static ThreadLocal<String> filePath = new ThreadLocal<>();

    public static void initializeReporter(String suiteName){

        String reportPath = FilePath.extentReportPath +"/ExecutionReport.html";
        filePath.set(reportPath);

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.CATEGORY,ViewName.TEST,ViewName.LOG,ViewName.EXCEPTION}).apply();
        extentSparkReporter.config().setReportName("OrangeHRMAutomationReport");
        extentSparkReporter.config().setDocumentTitle("OrangeHRMAutomationReport");
        reports = new ExtentReports();
        reports.attachReporter(extentSparkReporter);
        reports.setSystemInfo("Environment",ConfigReader.getProperties().getProperty("env"));
        reports.setSystemInfo("url",ConfigReader.getProperties().getProperty("URL"));
        reports.setSystemInfo("System username",System.getProperty("username.dir"));
        reports.setSystemInfo("os",System.getProperty("os.name"));
        reports.setSystemInfo("java version",System.getProperty("java.version"));
    }

    public static void createTest(String testName){
        extentTest = reports.createTest(testName);
    }

    public static void assignCategory(String category){
        extentTest.assignCategory(category);
    }

    public static void attachScreenshot(String base64){
        extentTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"screenshot").build());
    }
    public static void attachScreenshot(String base64, String screenshotName){
        extentTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(base64,screenshotName).build());
    }

    public static void logInfo(String message){
        extentTest.log(Status.INFO,message);
    }
    public static void logPass(String message){
        extentTest.log(Status.PASS,message);
    }
    public static void logFail(String message){
        extentTest.log(Status.FAIL,message);
        Assert.fail(message);
    }
    public static void logWarn(String message){
        extentTest.log(Status.WARNING,message);
    }

    public static void logTestFailure(ITestResult result){
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- test case failed", ExtentColor.RED));
        extentTest.log(Status.FAIL,  MarkupHelper.createCodeBlock(Throwables.getStackTraceAsString(result.getThrowable())));
    }

    public static void flushReport(){
        reports.flush();
    }
}
