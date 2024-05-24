package kwl.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	@FindBy(xpath="//a[contains(@href, '/help')]")
	private WebElement contactUsButton;

	public void openContactUsPage (){
		contactUsButton.click();
	}

	@FindBy(xpath ="//*[@id=\"calculation-form\"]/div[2]/div/input")
	private WebElement receivedAmountField;

	@FindBy(xpath="//*[@id=\"calculation-form\"]/div[4]/button")
	private WebElement continueButton;

	@FindBy(xpath="//*[@id=\"calculation-form\"]/div[2]/span")
	private WebElement limitAlertMessage;

	public void enterLowerLimitAmount(){
		receivedAmountField.click();
		receivedAmountField.sendKeys("149");
	}

	public void enterHigherLimitAmount(){
		receivedAmountField.click();
		receivedAmountField.sendKeys("5001");
	}
	public void clearReceivedAmountField(){
		receivedAmountField.click();
		receivedAmountField.sendKeys(Keys.END);
		receivedAmountField.sendKeys(Keys.BACK_SPACE);
		receivedAmountField.sendKeys(Keys.BACK_SPACE);
		receivedAmountField.sendKeys(Keys.BACK_SPACE);
		receivedAmountField.sendKeys(Keys.BACK_SPACE);
	}

	public void clickContinueButton(){
		continueButton.click();
	}

	public WebElement getContinueButton (){
		return continueButton;
	}

	public WebElement getLimitAlertMessage() {
		return limitAlertMessage;
	}

	@FindBy(xpath="//a[contains(text(),'Terms and Conditions')]")
	private WebElement TnClink;

	public WebElement getTnClink(){
		return TnClink;
	}

	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	private WebElement PrivacyPolicylink;

	public WebElement getPrivacyPolicylink() {return PrivacyPolicylink; }

	@FindBy(xpath="//a[contains(text(),'Website Terms of Use')]")
	private WebElement TermsOfUselink;

	public WebElement getTermsOfUselink(){
		return TermsOfUselink;
	}

	@FindBy(xpath="//*[@id=\"calculation-form\"]/div[1]/div/div")
	private WebElement countryDropdown;

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	@FindBy(xpath="//*[@id=\"calculation-form\"]/div[1]/div/div/div[2]/div")
	private WebElement selectedCountry;

	public WebElement getSelectedCountry(){
		return selectedCountry;
	}

	@FindBy(xpath="//*[@id=\"root\"]/header/div/div[2]/button")
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

	public void clickSignInButton(){
		signInButton.click();
	}

}
