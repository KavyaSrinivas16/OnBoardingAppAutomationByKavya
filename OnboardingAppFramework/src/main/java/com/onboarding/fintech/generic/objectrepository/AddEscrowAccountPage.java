package com.onboarding.fintech.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

public class AddEscrowAccountPage extends WebDriverUtility {

	WebDriver driver;

	public AddEscrowAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Escrow Name']")
	private WebElement escroeNameTxtfld;

	@FindBy(xpath = "//b[text()='Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//b[text()='Cancel']")
	private WebElement cancelBtn;

	public WebElement getEscroeNameTxtfld() {
		return escroeNameTxtfld;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

}
