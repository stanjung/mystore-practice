package base;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.Constants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static base.BaseDriver.driver;

public class BaseReport {
    public static SimpleDateFormat sdf;

    public void printReport(){
        Reporter.loadXMLConfig(new File("src/test/features/extent-config.xml"));
        Reporter.setSystemInfo("User", "tanjung");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Web App Name", "mystore-practice");
        Reporter.setSystemInfo("Build version", "v 1.0");
        Reporter.setTestRunnerOutput("Cucumber reporting using Extent Report");
    }

    public void getScreenShoot() {
        sdf = new SimpleDateFormat("dd-MM-YYYY-hh-mm-SS-SSS");
        String imageName = "Screenshot";
        String screenshotName1 = imageName.replaceAll(" ", "_");
        String screenshotName = screenshotName1+sdf.format(new Date());
        try {
            System.out.println("image name"+imageName);
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destinationPath = new File(System.getProperty("user.dir") + "/target/html/" + screenshotName + ".png");
            File relativeDestinationPath = new File(Constants.screenShootPath+screenshotName+".png");
            Files.copy(sourcePath, destinationPath);
            Reporter.addScreenCaptureFromPath(String.valueOf(relativeDestinationPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}