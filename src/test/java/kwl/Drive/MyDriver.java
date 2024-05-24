package kwl.Drive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class MyDriver implements WebDriver {
    private WebDriver driver;
    private static MyDriver ourInstance = new MyDriver();

    public static MyDriver getInstance() {
        return ourInstance;
    }

    private MyDriver() {
        driver = DriverFactory.getDriver();
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }
    public void scrollDown(int i, int i1) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public WebDriver.Options manage() {
        return driver.manage();
    }
}


