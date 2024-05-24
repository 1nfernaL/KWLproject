package kwl.Steps;

import kwl.Pages.HomePage;
import kwl.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class HomePageSteps extends HomePage {

    public void openTnCPDFlink() {

        Utils.Data.openPDFlink(getTnClink());

    }

    public String getPDFcontent() throws IOException {
        String currentUrl = driver.getCurrentUrl();
        String pdfContent = Utils.Data.getPdfContent(currentUrl);
        return pdfContent;
    }

    public void openPrivacyPolicyPDFlink(){
        Utils.Data.openPDFlink(getPrivacyPolicylink());
    }

    public void openTermsOfUsePDFlink(){
        Utils.Data.openPDFlink(getTermsOfUselink());
    }

    public void changeSelectedCountry(){
        getCountryDropdown().click();

        WebElement countryInput = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.visibilityOf((WebElement) By.id("react-select-5-input")));
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until((ExpectedConditions.attributeToBe(countryInput,"aria-expanded","true")));
        driver.findElement(By.name("Argentina")).click();
    }

}
