package com.testingminibytes.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.utils.ReadPropertyFile;

public class HomepageTests extends BaseTest{
	
	
	@Test
	public void test3() throws Exception
	{
		
		DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		Thread.sleep(1000);
		
		
	}

}
