package com.tmb.constants;

//final: If we don't want user to extend this class in script
public final class FrameworkConstants {
	
	//Constructor: Don't want users to create object of the call
	private FrameworkConstants() {
		
	}
	
	//final: variable not going to be changed forever
	private static final String CHROME_DRIVER_PATH =System.getProperty("user.dir")+"/src/test/resources/resources/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH =System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	//GetterMethod: users shouldn't have see the variable name
	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	} 

}
