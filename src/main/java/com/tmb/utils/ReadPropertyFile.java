package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile()
	{

	}

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(fis);
			
//			for(Object key:property.keySet())
//			{
//				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));
//			}
			
			for (Map.Entry<Object,Object> entry : property.entrySet()) 
			{
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(property.get(entry.getValue())));
			}
			//property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	public static String get(String key)
	{
		// TODO: not working, visit 9th video again
		if(Objects.isNull(key)||Objects.isNull(CONFIGMAP.get(key)))
		{
			throw new NullPointerException("Property name "+key+"is not found in properties file");
		}
		return CONFIGMAP.get(key);
	}



	public static String getValue(String key) throws Exception
	{
//		Properties property = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
//		property.load(fis);
		if(Objects.isNull(property.getProperty(key))||Objects.isNull(key))
		{
			throw new NullPointerException("Property name "+key+"is not found in properties file");
		}
		return property.getProperty(key);

	}

}
