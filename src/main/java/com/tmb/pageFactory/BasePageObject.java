package com.tmb.pageFactory;

import org.openqa.selenium.WebDriver;

import com.tmb.driver.DriverManager;

public class BasePageObject<B extends BasePageObject<B>>{
	private WebDriver driver;

	@Deprecated
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Deprecated
	public WebDriver getDriver() {
		return this.driver;
	}

	public BasePageObject() {
		this.driver = DriverManager.getDriver();
	}
}