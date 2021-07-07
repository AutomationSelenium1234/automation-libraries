package com.testingminibytes.scripts;

import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
		
	}

	
	@Test
	public void loginLogoutTests()
	{
		DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/");
		OrangeHRMLoginPage ohlPg = new OrangeHRMLoginPage();
//		ohlPg.enterUserName("Admin");
//		ohlPg.enterPassword("admin123");
//		ohlPg.clickLogin();
		
		OrangeHRMHomePage ohhPg =ohlPg.enterUserName("Admin").enterPassword("admin123").clickLogin();
		ohhPg.clickWelcome().clickLogout();
		
	}
}
