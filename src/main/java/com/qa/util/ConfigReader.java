package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	private static Properties prop;
	public Properties init_prop() throws IOException {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\hybridCucumber\\src\\test\\resource\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		

	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
		
	}
}
