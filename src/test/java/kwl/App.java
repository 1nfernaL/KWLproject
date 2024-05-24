package kwl;

import kwl.Steps.*;

public class App {
    public CommonSteps common;
    public HomePageSteps home;
    public ContactUsSteps contactUs;

    public App() {
        common = new CommonSteps();
        home = new HomePageSteps();
        contactUs = new ContactUsSteps();
    }

}
