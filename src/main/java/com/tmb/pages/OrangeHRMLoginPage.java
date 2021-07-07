package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage {

	
	/*
	 * id
	 * name
	 * classname
	 * linktext
	 * partiallinktext
	 * css or xpath
	 */

	
	private final By userName = By.id("txtUsername");
	private final By passWord = By.xpath("//input[@id='txtPassword'][@type='password']");
	private final By login = By.id("btnLogin");
	
	
	public OrangeHRMLoginPage enterUserName(String username)
	{
		DriverManager.getDriver().findElement(userName).sendKeys(username);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password)
	{
		DriverManager.getDriver().findElement(passWord).sendKeys(password);
		return this;
	}
	
	public OrangeHRMHomePage clickLogin()
	{
		DriverManager.getDriver().findElement(login).click();
		return new OrangeHRMHomePage();
	}
	
	
	
}
