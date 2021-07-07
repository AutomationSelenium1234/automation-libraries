package com.testingminibytes.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmb.utils.ReadPropertyFile;

public class LoginPageTests extends BaseTest{

	@Test
	public void test1() throws Exception 
	{

		DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
		Thread.sleep(1000);


	}


	@Test
	public void test2() throws Exception
	{
		DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes",Keys.ENTER);
		Thread.sleep(1000);

	}

}
