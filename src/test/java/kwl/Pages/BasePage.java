package kwl.Pages;

import kwl.Drive.MyDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected static MyDriver driver= MyDriver.getInstance();

    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
