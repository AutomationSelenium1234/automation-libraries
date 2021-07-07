package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.tmb.constants.FrameworkConstants;

public final class Driver {

	private Driver()
	{
		
	}
	

/**
 * If a non- familiar user uses multiple InitDriver actions, there will few unused browser instances,
 *  to overcome those instances we are checking for available browsers instances to NULL
 */
	public static void initDriver()
	{
		if(Objects.isNull(DriverManager.getDriver()))	
		{
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			DriverManager.setDriver(new ChromeDriver(options));
			
		}
	}

	/**
	 * If a script and browser is closed abruptly, we don't want our script to fail with below quit action,
	 * So we are checking for available browser instances before closing  
	 */
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}
}
