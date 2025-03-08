package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BasePage implements ITestListener {

    public Listeners() throws IOException {
        super();
    }

    public synchronized void onTestFailure(ITestResult result) {
        try {
            System.out.println("Test Failed: " + result.getName());
            takeSnapShot();
            //ExtentManager.attachImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
