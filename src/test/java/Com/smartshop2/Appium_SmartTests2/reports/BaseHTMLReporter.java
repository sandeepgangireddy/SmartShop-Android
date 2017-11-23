package Com.smartshop2.Appium_SmartTests2.reports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uncommons.reportng.HTMLReporter;

import Com.smartshop2.Appium_SmartTests2.tests.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseHTMLReporter extends HTMLReporter implements ITestListener {

    private static final String UTILS_KEY ="utils";
    private static final ReportUtils REPORT_UTILS = new ReportUtils();

    @Override
    protected VelocityContext createContext() {
        VelocityContext context = super.createContext();
        context.put(UTILS_KEY, REPORT_UTILS);
        return context;
    }

    /**
     * Inner function to take screenshots programatically with appium
     * @param result
     */
    private void createScreenshot(ITestResult result) {
        // take screenshot and put its path into test result context
    	Object currentClass = result.getInstance();
    	AppiumDriver<MobileElement> driver = ((TestBase) currentClass).getDriver();
        try {
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // output dir includes suite, so go up one level 
            String outputDir = result.getTestContext().getOutputDirectory();
			outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separatorChar));
			outputDir = outputDir.concat("/html");
			System.out.println("outputDir = " + outputDir);
			File saved = new File(outputDir, "ss_"+result.getMethod().getMethodName()+".png");
            FileUtils.copyFile(f, saved);
            System.out.println(saved.getName());
            // save screenshot path as result attribute so generateReport can access it
            result.setAttribute("screenshot", saved.getName());
            result.setAttribute("screenshotURL", driver.getCurrentUrl());
        } catch (Exception e) {
			System.out.println("error generating screenshot: "+e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {
        createScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        createScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}