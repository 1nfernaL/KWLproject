package kwl.Drive;

import kwl.Common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static kwl.Common.Constants.userProfileDir;

public class DriverFactory {
    static public WebDriver getDriver() {

        String property = System.getProperty("driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+ userProfileDir);
        options.addArguments("--profile-directory= Profile 1");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        WebDriver driver = null;
        if (property !=null) {
            if("opera".equals(property)){
                driver = new FirefoxDriver();

            }
            else{
                if ("chrome".equals(property))
                    driver = new ChromeDriver(options);
            }
        } else {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Constants.DEV_URL);
        return driver;
    }
}
