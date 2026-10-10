package com.automation.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static final Properties properties = new Properties();
	static {
	      
		try( FileInputStream file = new FileInputStream("src/test/resources/config.properties")){
	        properties.load(file);
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static final String USERNAME = properties.getProperty("username");
	public static final String PASSWORD = properties.getProperty("password");
	public static final String URL = properties.getProperty("baseUrl");
	public static final String INVENTORY_URL = properties.getProperty("inventoryUrl");
}

