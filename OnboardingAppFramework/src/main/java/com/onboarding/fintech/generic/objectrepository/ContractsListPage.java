package com.onboarding.fintech.generic.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

public class ContractsListPage extends WebDriverUtility {

	WebDriver driver;

	public ContractsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[text()='Add Contract']")
	private WebElement addContractsBtn;

	@FindBy(xpath = "//label[text()='Name of Contract']/following-sibling::div/input")
	private WebElement nameOfContractTxtFld;

	@FindBy(xpath = "//label[text()=\"Contract Admin's name\"]/following-sibling::div/input")
	private WebElement contractAdminNameTxtFld;

	@FindBy(xpath = "//div[text()='Clear all']")
	private WebElement clearAllLnk;

	@FindBy(xpath = "//label[text()=\"Name\"]/following-sibling::div/input")
	private List<WebElement> counterPartyNameTxtFld;

	@FindBy(xpath = "//label[text()=\"Company Name\"]/following-sibling::div/input")
	private List<WebElement> counterPartyCompanyNameTxtFld;

	@FindBy(xpath = "//label[text()=\"Email ID\"]/following-sibling::div/input")
	private List<WebElement> counterPartyEmailIdTxtFld;

	@FindBy(xpath = "//label[text()=\"Access\"]/following-sibling::div/div")
	private List<WebElement> accessDropdown;

	@FindBy(xpath = "//b[text()='Add Parties']")
	private WebElement addPartiesLnk;

	@FindBy(xpath = "//b[text()='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement removeBtn;

	@FindBy(xpath = "//li[text()='VIEWER']")
	private WebElement ViewerAccessOption;

	@FindBy(xpath = "//li[text()='EDITOR']")
	private WebElement EditorAccessOption;

	public WebElement getViewerAccessOption() {
		return ViewerAccessOption;
	}

	public WebElement getEditorAccessOption() {
		return EditorAccessOption;
	}

	public WebElement getAddContractsBtn() {
		return addContractsBtn;
	}

	public WebElement getNameOfContractTxtFld() {
		return nameOfContractTxtFld;
	}

	public WebElement getContractAdminNameTxtFld() {
		return contractAdminNameTxtFld;
	}

	public WebElement getClearAllLnk() {
		return clearAllLnk;
	}

	public List<WebElement> getCounterPartyNameTxtFld() {
		return counterPartyNameTxtFld;
	}

	public List<WebElement> getCounterPartyCompanyNameTxtFld() {
		return counterPartyCompanyNameTxtFld;
	}

	public List<WebElement> getCounterPartyEmailIdTxtFld() {
		return counterPartyEmailIdTxtFld;
	}

	public List<WebElement> getAccessDropdown() {
		return accessDropdown;
	}

	public WebElement getAddPartiesLnk() {
		return addPartiesLnk;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	@FindBy(className = "NewContract_groupParent__SwKdB")
	private WebElement chooseFileButton;

	public WebElement getChooseFileButton() {
		return chooseFileButton;
	}

}
