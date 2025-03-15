package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BasePage implements ITestListener {

    public Listeners() throws IOException {
        super();
    }
    public synchronized void onStart(ITestContext context) {
        ExtentManager.getReport();
        ExtentManager.createTest(context.getName(), context.getName());

    }

    public synchronized void onTestFailure(ITestResult result) {
        ExtentManager.getTest().fail(result.getThrowable());
        try {
            System.out.println("Test Failed: " + result.getName());
            takeSnapShot(result.getMethod().getMethodName());
            ExtentManager.attachImage();
            //ExtentManager.attachImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }
}
