package kwl.Test;

import kwl.Common.Constants;
import kwl.Drive.MyDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class MyTest extends BaseTest{
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void test1NotLoggedInUser() throws InterruptedException, IOException {
//        app.home.openContactUsPage();
//        app.contactUs.sendSupportMessage();
//        Assert.assertEquals(app.contactUs.getSuccessSupportMessage(), Constants.successSupportMessage);

        //Checking min limit alerts
        app.home.enterLowerLimitAmount();
        app.home.clickContinueButton();
        softAssert.assertTrue(app.home.getLimitAlertMessage().isDisplayed(),"Limit alert isn't displayed");
        softAssert.assertEquals(app.home.getLimitAlertMessage().getText(), Constants.minLimitAlertMessage, "Limit alert text is wrong");
        softAssert.assertFalse(app.home.getContinueButton().isEnabled(),"Continue button is still active with unavailable entered amount");
        Thread.sleep(5000);
        //Checking min limit alerts
        app.home.clearReceivedAmountField();
        app.home.enterHigherLimitAmount();
        app.home.clickContinueButton();
        softAssert.assertTrue(app.home.getLimitAlertMessage().isDisplayed(), "Limit alert isn't displayed");
        softAssert.assertEquals(app.home.getLimitAlertMessage().getText(), Constants.maxLimitAlertMessage, "Limit alert text is wrong");
        softAssert.assertFalse(app.home.getContinueButton().isEnabled(),"Continue button is still active with unavailable entered amount");
        Thread.sleep(5000);
        app.home.clearReceivedAmountField();
        String currentWindowHandle = MyDriver.getInstance().getWindowHandle(); //Save current window identifier
        //Checking Terms&Conditions PDF link
        app.home.openTnCPDFlink();
        Thread.sleep(10000);
        //MyDriver.getInstance().manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        softAssert.assertEquals(MyDriver.getInstance().getCurrentUrl(),Constants.TnClinkUrl,"Wrong link is opened");
        softAssert.assertTrue(app.home.getPDFcontent().contains("Terms and Conditions"), "PDF doesn't contain such text");
        MyDriver.getInstance().close();
        MyDriver.getInstance().switchTo().window(currentWindowHandle); //Return to prev saved window
        Thread.sleep(5000);
        //Checking PrivacyPolicy PDF link
        app.home.openPrivacyPolicyPDFlink();
        Thread.sleep(10000);
        softAssert.assertEquals(MyDriver.getInstance().getCurrentUrl(),Constants.PrivacyPolicylinkUrl,"Wrong link is opened");
        softAssert.assertTrue(app.home.getPDFcontent().contains("KUVA PRIVACY POLICY"), "PDF doesn't contain such text");
        MyDriver.getInstance().close();
        MyDriver.getInstance().switchTo().window(currentWindowHandle);
        Thread.sleep(5000);
        //Checking TermsOfUse PDF link
        app.home.openTermsOfUsePDFlink();
        Thread.sleep(10000);
        softAssert.assertEquals(MyDriver.getInstance().getCurrentUrl(),Constants.TermsOfUseUrl,"Wrong link is opened");
        softAssert.assertTrue(app.home.getPDFcontent().contains("Terms of Use"), "PDF doesn't contain such text");
        MyDriver.getInstance().close();
        MyDriver.getInstance().switchTo().window(currentWindowHandle);
        Thread.sleep(5000);
        //Checking Country dropdown on the Start page
        softAssert.assertEquals(app.home.getSelectedCountry().getText(),"Zimbabwe", "Wrong value country is selected");
        //app.home.changeSelectedCountry();
        Thread.sleep(5000);
        softAssert.assertAll();
    }
}
