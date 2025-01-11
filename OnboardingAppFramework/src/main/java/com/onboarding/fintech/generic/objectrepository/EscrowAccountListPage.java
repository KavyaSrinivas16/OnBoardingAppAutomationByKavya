package com.onboarding.fintech.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

public class EscrowAccountListPage extends WebDriverUtility {
	
	WebDriver driver;
	public EscrowAccountListPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='MuiTableContainer-root css-1p6ntod']/descendant::tr[2]/descendant::td[5]/descendant::button[text()='View More']")
	private WebElement frstEscrowAccViewMoreLnk; 
	
	@FindBy(xpath = "//button[@class='SelectActivity1_kycListWrapperbtn3__ZrlrE']/descendant::div[text()='KYC List']")
	private WebElement KYClistBtn;
	
	@FindBy(xpath = "//button[@id='Statement_Button']/descendant::div[text()='Contracts']")
	private WebElement ContractsBtn;
	
	@FindBy(xpath = "//button[@id='Transaction_Button']/descendant::div[text()='E-sign & E-stamp']")
	private WebElement EsignAndEstampBtn;
	public WebElement getFrstEscrowAccViewMoreLnk() {
		return frstEscrowAccViewMoreLnk;
	}

	public WebElement getKYClistBtn() {
		return KYClistBtn;
	}

	public WebElement getContractsBtn() {
		return ContractsBtn;
	}

	public WebElement getEsignAndEstampBtn() {
		return EsignAndEstampBtn;
	}
	
	

}
