package kwl.Steps;

import kwl.Pages.BasePage;

public class CommonSteps extends BasePage {
    public void stopApp() {
        driver.quit();
    }

}
