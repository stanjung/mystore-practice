package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class BaseDriver {
    public static WebDriver driver;

    public void configureDriverPath() throws IOException {

        if(System.getProperty("os.name").startsWith("Mac")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/drivers/mac/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/drivers/mac/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        if(System.getProperty("os.name").startsWith("Windows")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "//drivers//windows//geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "//drivers//windows//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
    }

    public void openBrowser(String browserType, String version) throws Exception {
        configureDriverPath();
        if (browserType.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            options.addArguments("--disable-gpu"); //Temporarily needed if running on Windows
            options.addArguments("--no-sandbox"); //to disable sandbox (Bypass OS security model)
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.setExperimentalOption("useAutomationExtension", false); //disabling extension
            driver = new ChromeDriver(options);
        }

    }

    public void quitFromBrowser(){
        driver.quit();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

}
