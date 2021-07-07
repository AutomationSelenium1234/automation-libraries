package com.tmb.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.driver.DriverManager;

public class OrangeHRMHomePage {
	
	private final By welcome = By.id("welcome");
	private final By logout = By.id("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome()
	{
		DriverManager.getDriver().findElement(welcome).click();
		return this;
	}
	
	
	public OrangeHRMLoginPage clickLogout()
	{
		//different way of using Thread.slepp
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		
		DriverManager.getDriver().findElement(logout).click();
		return new OrangeHRMLoginPage();
	}
	
	
	

}
