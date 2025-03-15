package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BasePage {
    
    private String url;
    private Properties prop;
    public static String screenShotDestinationPath;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(data);
    }

    public static WebDriver getDriver() throws IOException {
    return WebDriverInstance.getThreadedDriver();
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }

    public static String  takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        //File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\"+ timestamp() + ".png");
        String destFile = "screenshots/" + timestamp() + ".png";
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\target\\" + destFile));

        System.out.println(destFile);
        screenShotDestinationPath = destFile;
        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;

        //FileUtils.copyFile(srcFile, destFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String getScreenShotDestinationPath() {
        return screenShotDestinationPath;
    }

    public static void waitForElementInvisible(WebElement element, int timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
