package com.pom.framework;



import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	
	public String getProperties(String property) throws IOException {
		
		Properties prop = new Properties();
		FileReader fileReader = new FileReader(IBaseInterface.CONFIG_PATH);
		prop.load(fileReader);
		return prop.getProperty(property);
	}
	
}
