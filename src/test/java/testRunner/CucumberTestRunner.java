package testRunner;

import base.BaseDriver;
import base.BaseReport;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;


@CucumberOptions(
        features 			= {"src/test/features"},
        glue 	 			= {"stepDefinition"},
        plugin 				= {"com.cucumber.listener.ExtentCucumberFormatter:target/html/report.html"},
        tags	 			= {"@homepage"},
        dryRun 	 			= false,
        strict 	 			= false,
        monochrome 			= true
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
    private static BaseDriver base = new BaseDriver();
    private static BaseReport report = new BaseReport();



    @BeforeSuite(alwaysRun = true)
    @Parameters({"browserType","version"})  //passing parameter from pom
    public void setUp(String browserType,String version) throws Exception{
        base.openBrowser(browserType,version);
//        base.setWindowSize();  //don't use maximize for selenoid
//        base.implicitWait(10);
        base.deleteAllCookies();
    }



    @AfterSuite(alwaysRun = true)
    @Parameters({"browserType","version"}) //passing parameter from pom
    public void copyFileThenQuit(String browserType,String version) throws InterruptedException {
        base.quitFromBrowser();
    }


    @AfterClass
    public static void teardown() throws IOException {
        report.printReport();
    }

}
