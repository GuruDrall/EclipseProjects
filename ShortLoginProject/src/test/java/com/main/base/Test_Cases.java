package com.main.base;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.functional.pages.HomePage;
import com.functional.pages.LoginPage;
import com.shortProj.dataProviders.dataProviderClass;

@Listeners(Report_Listeners.class)
public class Test_Cases extends BaseClass1 {
	LoginPage loginPage;
	HomePage homePage;

	@Test(priority = 1)
	public void login() {
		launchBrowser();
		openURL();
		loginPage = new LoginPage();
		loginPage.enterUsername();
		loginPage.enterPassword();
		loginPage.ClickSubmit();
		String actURL = driver.getCurrentUrl();
		String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(actURL, expectedURL);
	}

	@Test(dataProvider = "excelData", dataProviderClass = dataProviderClass.class, enabled = false)
	public void loginTest(String username, String password) {
		launchBrowser();
		openURL();
		loginPage = new LoginPage();
		loginPage.loginWithDP(username, password);
		String actURL = driver.getCurrentUrl();
		String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(actURL, expectedURL);
	}

	@Test
	public void getCheatSheet() throws InterruptedException {
		homePage = new HomePage();
		homePage.clickHome();
		homePage.enterNameEmail();
		homePage.clickCheatSeet();
		Thread.sleep(15000);
		homePage.clickCheatSeet();
		
	}

}
