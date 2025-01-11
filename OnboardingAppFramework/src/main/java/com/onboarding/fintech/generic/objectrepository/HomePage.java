package com.onboarding.fintech.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	public HomePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@style='position: relative; cursor: pointer;']")
	private WebElement userProfileIcon; 
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement userProfileLogOutBtn; 
	
	@FindBy(xpath = "//div[text()='Escrow A/C List']")
	private WebElement escrowAccountListBtn;
	
	@FindBy(xpath = "//div[text()='User Management']")
	private WebElement userManagementBtn;
	
	@FindBy(xpath = "//b[text()='Add Escrow account']/parent::button")
	private WebElement addEscrowAccountBtn;
	
	@FindBy(xpath = "//label[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@value='MM/DD/YYYY']")
	private WebElement createdDateTxtfld;
	
	@FindBy(xpath = "//b[text()='Apply']")
	private WebElement applyBtn;
	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getUserProfileLogOutBtn() {
		return userProfileLogOutBtn;
	}

	public WebElement getEscrowAccountListBtn() {
		return escrowAccountListBtn;
	}

	public WebElement getUserManagementBtn() {
		return userManagementBtn;
	}

	public WebElement getAddEscrowAccountBtn() {
		return addEscrowAccountBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreatedDateTxtfld() {
		return createdDateTxtfld;
	}

	public WebElement getApplyBtn() {
		return applyBtn;
	}
	
	
	
	
	
	
	

}
