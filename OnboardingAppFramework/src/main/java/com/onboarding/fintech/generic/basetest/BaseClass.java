package com.onboarding.fintech.generic.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.onboarding.fintech.generic.databaseutility.DataBaseUtility;
import com.onboarding.fintech.generic.fileutility.ExcelUtility;
import com.onboarding.fintech.generic.fileutility.FileUtility;
import com.onboarding.fintech.generic.objectrepository.AddEscrowAccountPage;
import com.onboarding.fintech.generic.objectrepository.HomePage;
import com.onboarding.fintech.generic.objectrepository.LoginPage;
import com.onboarding.fintech.generic.webdriverutility.JavaUtility;
import com.onboarding.fintech.generic.webdriverutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite // (groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		System.out.println("Connect to db and report config");
//		dblib.getDBConnection();

	}

	// @Parameters("BROWSER")
	@BeforeClass // (groups = { "smokeTest", "regressionTest" })
	public void configBC(/* String browser */) throws Throwable {

		System.out.println("launch browser");
		// String BROWSER = browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			ChromeOptions co = new ChromeOptions();
//			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		// UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod // (groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("login script");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("UserName");
		String OTP = flib.getDataFromPropertiesFile("OTP");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, OTP);
	}

	@AfterMethod // (groups = { "smokeTest", "regressionTest" })
	public void configAM() throws InterruptedException {
		System.out.println("logout script");
		HomePage hp = new HomePage(driver);
		hp.getUserProfileIcon().click();
		hp.getUserProfileLogOutBtn().click();
	}

	@AfterClass // (groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
	}

	@AfterSuite // (groups = { "smokeTest", "regressionTest" })
	public void configAS() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("close db and report backup");
//		dblib.closeDBConnection();

	}

}
