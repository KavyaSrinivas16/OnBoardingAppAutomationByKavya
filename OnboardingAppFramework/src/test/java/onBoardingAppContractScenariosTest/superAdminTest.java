package onBoardingAppContractScenariosTest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.onboarding.fintech.generic.basetest.BaseClass;
import com.onboarding.fintech.generic.objectrepository.AddEscrowAccountPage;
import com.onboarding.fintech.generic.objectrepository.HomePage;
import com.onboarding.fintech.generic.webdriverutility.UtilityClassObject;

@Listeners(com.onboarding.fintech.generic.lilstenerUtility.ListImpClass.class)
public class superAdminTest extends BaseClass{
	
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

}
