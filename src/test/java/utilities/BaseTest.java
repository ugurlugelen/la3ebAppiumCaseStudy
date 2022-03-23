package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;


public abstract class BaseTest {

    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentSparkReporter extentSparkReporter;



    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        String filePath = System.getProperty("user.dir") + "/test-output/la3eb.html";
        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName("LA3EB Case Study");
        extentSparkReporter.config().setDocumentTitle("N11 TEST CASES");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("QA Tester", "Adem Ugurlugelen");
        extentReports.setSystemInfo("Environmet","PRODUCTION");
        extentReports.setSystemInfo("Android","10.0");
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }

    @BeforeMethod
    public void setUp(ITestContext context){
        Driver.getAppiumDriver();
        extentTest = extentReports.createTest(context.getName());
        extentTest.info("User runs the application");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.fail(result.getName());
            String screenshot = ReusableMethods.getScreenshot(result.getName());
            extentTest.addScreenCaptureFromPath(screenshot);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
       Driver.quitAppiumDriver();
    }
}


