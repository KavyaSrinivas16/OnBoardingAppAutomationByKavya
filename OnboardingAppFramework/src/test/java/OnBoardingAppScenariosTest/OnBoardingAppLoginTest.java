package OnBoardingAppScenariosTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import com.onboarding.fintech.generic.basetest.BaseClass;
import com.onboarding.fintech.generic.objectrepository.AddEscrowAccountPage;
import com.onboarding.fintech.generic.objectrepository.ContractsListPage;
import com.onboarding.fintech.generic.objectrepository.EscrowAccountListPage;
import com.onboarding.fintech.generic.objectrepository.HomePage;
import com.onboarding.fintech.generic.webdriverutility.UtilityClassObject;

@Listeners(com.onboarding.fintech.generic.lilstenerUtility.ListImpClass.class)

public class OnBoardingAppLoginTest extends BaseClass {

	@Test(priority = 0)
	public void LoginTest() throws Throwable

	{

		UtilityClassObject.getTest().log(Status.INFO, "navigate to homepage");
		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		wlib.waitForElementPresent(driver, hp.getAddEscrowAccountBtn());
		hp.getAddEscrowAccountBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Create Escrow account");
		String escrowAccountName = elib.getDataFromExcel("Sheet1", 1, 0) + jlib.getRandomNumber();
		AddEscrowAccountPage aeap = new AddEscrowAccountPage(driver);
		aeap.getEscroeNameTxtfld().sendKeys(escrowAccountName);
		aeap.getCreateBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Verify Escrow Account name");
		hp.getUserManagementBtn().click();
		hp.getEscrowAccountListBtn().click();
		String actualResult = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
		String expectedResult = escrowAccountName;
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualResult, expectedResult, "account name should be same");
		sa.assertAll();
	}

	@Test(priority = 1)
	public void createContractTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to view more link of recently created escrow account");
		Thread.sleep(3000);
		EscrowAccountListPage ealp = new EscrowAccountListPage(driver);
		ealp.getFrstEscrowAccViewMoreLnk().click();
		ealp.getContractsBtn().click();
		ContractsListPage clp = new ContractsListPage(driver);
		clp.getAddContractsBtn().click();
		Thread.sleep(5000);

		UtilityClassObject.getTest().log(Status.INFO, "enter all Contracts details");
		String nameOfContract = elib.getDataFromExcel("Sheet2", 1, 1);
		clp.getNameOfContractTxtFld().click();
		clp.getNameOfContractTxtFld().sendKeys(nameOfContract);

		String ContractAdminName = elib.getDataFromExcel("Sheet2", 1, 2);
		clp.getContractAdminNameTxtFld().sendKeys(ContractAdminName);

		wlib.scrollToElement(driver, clp.getNameOfContractTxtFld());
		wlib.waitForElementPresent(driver, clp.getNameOfContractTxtFld());
		Thread.sleep(5000);
		clp.getChooseFileButton().click();
		Thread.sleep(2000);
		wlib.selectFile(flib.getDataFromPropertiesFile("path"));
		Thread.sleep(5000);

		int partiesDetails = 4; // Give the index of starting data
		for (int counterparty = 0; counterparty < 10; counterparty++) {

			if (!(counterparty == 0)) {
				wlib.scrollToElement(driver, clp.getAddPartiesLnk());
				wlib.waitForElementPresent(driver, clp.getAddPartiesLnk());
				clp.getAddPartiesLnk().click();
			}

			WebElement counterPartyName = clp.getCounterPartyNameTxtFld().get(counterparty);
			String counterPartyNameValue = elib.getDataFromExcel("Sheet2", partiesDetails, 1);
			wlib.scrollToElement(driver, counterPartyName);
			wlib.waitForElementPresent(driver, counterPartyName);
			counterPartyName.click();
			counterPartyName.sendKeys(counterPartyNameValue);

			WebElement companyName = clp.getCounterPartyCompanyNameTxtFld().get(counterparty);
			String CounterPartyCompanyName = elib.getDataFromExcel("Sheet2", partiesDetails, 2);
			wlib.scrollToElement(driver, companyName);
			wlib.waitForElementPresent(driver, companyName);
			companyName.click();
			companyName.sendKeys(CounterPartyCompanyName);

			WebElement emailIDfield = clp.getCounterPartyEmailIdTxtFld().get(counterparty);
			String CounterPartyEmailId = elib.getDataFromExcel("Sheet2", partiesDetails, 3);
			wlib.scrollToElement(driver, emailIDfield);
			wlib.waitForElementPresent(driver, emailIDfield);
			emailIDfield.click();
			emailIDfield.sendKeys(CounterPartyEmailId);

			WebElement accessDropdown = clp.getAccessDropdown().get(counterparty);
			wlib.scrollToElement(driver, accessDropdown);
			wlib.waitForElementPresent(driver, accessDropdown);
			accessDropdown.click();

			if (counterparty == 0) {
				WebElement editor = clp.getEditorAccessOption();
				wlib.scrollToElement(driver, editor);
				wlib.waitForElementPresent(driver, editor);
				editor.click();
			} else {
				{
					WebElement viewer = clp.getViewerAccessOption();
					wlib.scrollToElement(driver, viewer);
					wlib.waitForElementPresent(driver, viewer);
					viewer.click();
				}
			}
			partiesDetails++;

		}

		clp.getContinueBtn().click();
		Thread.sleep(2000);

		UtilityClassObject.getTest().log(Status.INFO, "verify the created email ID of last counterparty");
		driver.findElement(By.xpath("//button[text()='2']")).click();
		String actualResult = driver.findElement(By.xpath("//table//tr[5]//td[3]")).getText();
		String expectedResult = "kavya4@gmail.com";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualResult, expectedResult, "mentioned mail id is not matching");
		sa.assertAll();
		sa.assertTrue(actualResult.equals(expectedResult), "mentioned mail id is not matching");
		sa.assertAll();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to homepage");
		HomePage hp = new HomePage(driver);
		hp.getEscrowAccountListBtn().click();

	}

	@Test(priority = 2)
	public void ContractAgreementTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "navigate to view more link of recently created escrow account");
		Thread.sleep(3000);
		EscrowAccountListPage ealp = new EscrowAccountListPage(driver);
		ealp.getFrstEscrowAccViewMoreLnk().click();
		ealp.getContractsBtn().click();
		ContractsListPage clp = new ContractsListPage(driver);
		clp.getAddContractsBtn().click();
		Thread.sleep(5000);

		UtilityClassObject.getTest().log(Status.INFO, "enter all Contracts details");
		String nameOfContract = elib.getDataFromExcel("Sheet2", 1, 1);
		clp.getNameOfContractTxtFld().click();
		clp.getNameOfContractTxtFld().sendKeys(nameOfContract);

		String ContractAdminName = elib.getDataFromExcel("Sheet2", 1, 2);
		clp.getContractAdminNameTxtFld().sendKeys(ContractAdminName);

		wlib.scrollToElement(driver, clp.getNameOfContractTxtFld());
		wlib.waitForElementPresent(driver, clp.getNameOfContractTxtFld());
		Thread.sleep(5000);
		clp.getChooseFileButton().click();
		Thread.sleep(2000);
		wlib.selectFile(flib.getDataFromPropertiesFile("path"));
		Thread.sleep(5000);

		int partiesDetails = 4; // Give the index of starting data
		for (int counterparty = 0; counterparty < 2; counterparty++) {

			if (!(counterparty == 0)) {
				wlib.scrollToElement(driver, clp.getAddPartiesLnk());
				wlib.waitForElementPresent(driver, clp.getAddPartiesLnk());
				clp.getAddPartiesLnk().click();
			}

			WebElement counterPartyName = clp.getCounterPartyNameTxtFld().get(counterparty);
			String counterPartyNameValue = elib.getDataFromExcel("Sheet2", partiesDetails, 1);
			wlib.scrollToElement(driver, counterPartyName);
			wlib.waitForElementPresent(driver, counterPartyName);
			counterPartyName.click();
			counterPartyName.sendKeys(counterPartyNameValue);

			WebElement companyName = clp.getCounterPartyCompanyNameTxtFld().get(counterparty);
			String CounterPartyCompanyName = elib.getDataFromExcel("Sheet2", partiesDetails, 2);
			wlib.scrollToElement(driver, companyName);
			wlib.waitForElementPresent(driver, companyName);
			companyName.click();
			companyName.sendKeys(CounterPartyCompanyName);

			WebElement emailIDfield = clp.getCounterPartyEmailIdTxtFld().get(counterparty);
			String CounterPartyEmailId = elib.getDataFromExcel("Sheet2", partiesDetails, 3);
			wlib.scrollToElement(driver, emailIDfield);
			wlib.waitForElementPresent(driver, emailIDfield);
			emailIDfield.click();
			emailIDfield.sendKeys(CounterPartyEmailId);

			WebElement accessDropdown = clp.getAccessDropdown().get(counterparty);
			wlib.scrollToElement(driver, accessDropdown);
			wlib.waitForElementPresent(driver, accessDropdown);
			accessDropdown.click();

			if (counterparty == 0) {
				WebElement editor = clp.getEditorAccessOption();
				wlib.scrollToElement(driver, editor);
				wlib.waitForElementPresent(driver, editor);
				editor.click();
			} else {
				{
					WebElement viewer = clp.getViewerAccessOption();
					wlib.scrollToElement(driver, viewer);
					wlib.waitForElementPresent(driver, viewer);
					viewer.click();
				}
			}
			partiesDetails++;

		}

		clp.getContinueBtn().click();
		Thread.sleep(2000);

		UtilityClassObject.getTest().log(Status.INFO, "verify the created email ID of first counterparty");
		driver.findElement(By.xpath("//button[text()='1']")).click();
		String actualResult1 = driver.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
		String expectedResult1 = "kavya.s@escrowstack.io";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualResult1, expectedResult1, "mentioned mail id is not matching");
		sa.assertAll();

		UtilityClassObject.getTest().log(Status.INFO, "verify the created email ID of last counterparty");
		driver.findElement(By.xpath("//button[text()='1']")).click();
		String actualResult2 = driver.findElement(By.xpath("//table//tr[2]//td[3]")).getText();
		String expectedResult2 = "kavyasrinivasa.a6@gmail.com";
		sa.assertTrue(actualResult2.equals(expectedResult2), "mentioned mail id is not matching");
		sa.assertAll();

		Thread.sleep(90000);
		driver.navigate().refresh();

		UtilityClassObject.getTest().log(Status.INFO, "verify counterparty status");
		String counterParty1Status = driver.findElement(By.xpath("//table//tr[1]//td[5]")).getText();
		String CounterPartyStatus = "Finalized";
		String counterParty2Status = driver.findElement(By.xpath("//table//tr[2]//td[5]")).getText();

		sa.assertEquals(counterParty1Status, CounterPartyStatus);
		sa.assertEquals(counterParty2Status, CounterPartyStatus);
		sa.assertAll();

		clp.getviewDocumentBtn().click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[text()='Contracts List']")).click();
		Thread.sleep(5000);

		UtilityClassObject.getTest().log(Status.INFO, "Verify contracts status");
		String ActContractStatus = driver.findElement(By.xpath("//table//tr[1]//td[5]")).getText();
		String ExpContractStatus = "ACCEPTED";
		sa.assertEquals(ActContractStatus, ExpContractStatus);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to homepage");
		HomePage hp = new HomePage(driver);
		hp.getEscrowAccountListBtn().click();

	}
}
