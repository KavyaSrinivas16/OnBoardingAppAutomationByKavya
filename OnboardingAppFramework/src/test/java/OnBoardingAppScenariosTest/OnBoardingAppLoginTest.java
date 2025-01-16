package OnBoardingAppScenariosTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.onboarding.fintech.generic.basetest.BaseClass;
import com.onboarding.fintech.generic.objectrepository.AddEscrowAccountPage;
import com.onboarding.fintech.generic.objectrepository.ContractsListPage;
import com.onboarding.fintech.generic.objectrepository.EscrowAccountListPage;
import com.onboarding.fintech.generic.objectrepository.HomePage;

public class OnBoardingAppLoginTest extends BaseClass {

	@Test(enabled = true)
	public void LoginTest() throws Throwable

	{

		SoftAssert sa = new SoftAssert();
		// clicking on Add Escrow Account button in the homepage
		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		wlib.waitForElementPresent(driver, hp.getAddEscrowAccountBtn());
		hp.getAddEscrowAccountBtn().click();

		/*
		 * fetching the random account name from the excel sheet to give input to Escrow
		 * Name and clicking on Create button
		 */
		String escrowAccountName = elib.getDataFromExcel("Sheet1", 1, 0) + jlib.getRandomNumber();
		AddEscrowAccountPage aeap = new AddEscrowAccountPage(driver);
		aeap.getEscroeNameTxtfld().sendKeys(escrowAccountName);
		aeap.getCreateBtn().click();
		hp.getUserManagementBtn().click();
		hp.getEscrowAccountListBtn().click();
		String actualResult = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
		String expectedResult = escrowAccountName;
		sa.assertEquals(actualResult, expectedResult, "account name should be same");
		sa.assertAll();
	}

	@Test
	public void createContractTest() throws Throwable {

		SoftAssert sa = new SoftAssert();

		// navigate to view more link of recently created escrow account

		Thread.sleep(3000);
		EscrowAccountListPage ealp = new EscrowAccountListPage(driver);
		ealp.getFrstEscrowAccViewMoreLnk().click();

		// navigate to Contracts button
		ealp.getContractsBtn().click();

		// navigate to Add contracts button
		ContractsListPage clp = new ContractsListPage(driver);
		clp.getAddContractsBtn().click();

		Thread.sleep(5000);

		// enter all Contracts details
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
		for (int counterparty = 0; counterparty < 50; counterparty++) {

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

		driver.findElement(By.xpath("//button[text()='10']")).click();
		String actualResult = driver.findElement(By.xpath("//table//tr[5]//td[3]")).getText();
		String expectedResult = "kavya44@gmail.com";
		sa.assertEquals(actualResult, expectedResult, "hgjhgjhgku");
		sa.assertAll();
		sa.assertTrue(actualResult.equals(expectedResult), "mentioned mail id is not matching");
		sa.assertAll();

		HomePage hp = new HomePage(driver);
		wlib.scrollToElement(driver, hp.getUserProfileIcon());

	}
}
