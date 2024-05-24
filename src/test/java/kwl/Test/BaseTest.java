package kwl.Test;

import kwl.App;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected static App app = new App();

    @AfterMethod
    public void tearDownSuits() {
        app.common.stopApp();
    }
}
