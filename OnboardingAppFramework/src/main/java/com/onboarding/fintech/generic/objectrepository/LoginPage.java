package com.onboarding.fintech.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onboarding.fintech.generic.fileutility.FileUtility;
import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterEmailTxtfld;

	@FindBy(xpath = "//b[text()='Get OTP']")
	private WebElement getOtpBtn;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterOtpTxtfld;

	@FindBy(xpath = "//b[text()='VERIFY OTP']")
	private WebElement verifyOtpBtn;

	public WebElement getEnterEmailTxtfld() {
		return enterEmailTxtfld;
	}

	public WebElement getGetOtpBtn() {
		return getOtpBtn;
	}

	public WebElement getEnterOtpTxtfld() {
		return enterOtpTxtfld;
	}

	public WebElement getVerifyOtpBtn() {
		return verifyOtpBtn;
	}

	public void loginToapp(String url, String UserName, String OTP) throws InterruptedException {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		enterEmailTxtfld.sendKeys(UserName);
		getOtpBtn.click();
		Thread.sleep(2000);
		enterOtpTxtfld.sendKeys(OTP);
		verifyOtpBtn.click();

	}

//	public void entreEmailID(String email) {
////		return enterEmailTxtfld;
//
//		enterEmailTxtfld.sendKeys(email);
//	}
//
//	public WebElement getEmailTxtFld() {
//		return enterEmailTxtfld;
//	}
//
//	public void clickongetotp() {
//		getOtpBtn.click();
//	}
//
//	public void getEnterOtpTxtfld(String otp) {
//		enterOtpTxtfld.sendKeys(otp);
//	}
//
//	public void clickOnVerifyOtpBtn() {
//		verifyOtpBtn.click();
//	}

}
