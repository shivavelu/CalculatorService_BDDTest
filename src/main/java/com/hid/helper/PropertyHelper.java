package com.hid.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
	public static Properties propapi;
	

	static{
		try {
			
			propapi = new Properties();
			File f = new File(".src/main/resources/com/property/testData.properties");
			FileInputStream ip = new FileInputStream(f);
			propapi.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public static String readProperty(String i) {
		String o = PropertyHelper.propapi.getProperty(i);
		return o;
	}


}
