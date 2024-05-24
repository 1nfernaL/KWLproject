package kwl.Pages;

import kwl.Common.Constants;
import kwl.Drive.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {

	@FindBy(xpath="//*[@id=\"root\"]/main/section/div/div[2]/div[2]/textarea")
	private WebElement contactUsTextarea;

	@FindBy(xpath="//*[@id=\"root\"]/main/section/div/div[2]/div[1]/input")
	private WebElement emailToSupportField;

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitButton;

	public void sendSupportMessage(){

		emailToSupportField.sendKeys(Constants.validUserEmail);
		contactUsTextarea.sendKeys(Constants.messageText);
		MyDriver.getInstance().scrollDown(0,500);
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

		WebElement recaptcha = (new WebDriverWait(driver, Duration.ofSeconds(10)))
			.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor")));
		recaptcha.click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.attributeToBe(recaptcha, "aria-checked", "true"));
		driver.switchTo().defaultContent();
		submitButton.click();
	}

	@FindBy(xpath="/html/body/div[1]/main/section/div/div[2]/p")
	private WebElement successSupportMessage;

	public String getSuccessSupportMessage(){
		String message = successSupportMessage.getText();
		return message;
	}

	@FindBy(xpath="//*[@id=\"root\"]/main/section/div/div[2]/div/button")
	private WebElement okButton;

	public void closeSuccessSupportMessage(){
		okButton.click();
	}

}
