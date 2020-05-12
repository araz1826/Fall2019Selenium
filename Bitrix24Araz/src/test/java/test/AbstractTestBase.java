package test;

import Pages.AbstractPageBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;

public class AbstractTestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    //reporting  : there are 3 classes   (Beforetest, aftertest and BeforeMethod is updated)
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {// this makes parameter optional if not specify testng wil require this parameter for every test, in xml file
        System.out.println("Report Name: "+reportName);
        String reportNameString=reportName==null ? "report.html" : reportName;

        report = new ExtentReports();
        String reportPath = "";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void afterTest(){
        report.flush();
    }

        @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());

            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
