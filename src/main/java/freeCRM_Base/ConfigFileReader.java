package freeCRM_Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {

	Properties pro;
	String sourceFolder;
	public ConfigFileReader(String sourceFolder)
	{
             this.sourceFolder=sourceFolder;
	}

	public void loadPropertiesFile() {
		try {			
			File propertiesFileObj = new File(sourceFolder+"/GlobalConfig/config.properties");
			FileInputStream fls = new FileInputStream(propertiesFileObj);
			pro = new Properties();   //to load the properties file in the form of key and value pair
			pro.load(fls);
			fls.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}
	}

	@SuppressWarnings("unused")
	public String getApplicationName()
	{

		String appName=pro.getProperty("ApplicationName");
		if (appName!= null && appName!=" ")
		{
			return appName;
		}
		else
		{
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}
	}	
	@SuppressWarnings("unused")
	public String getEnvironmentName()
	{
		String envName=pro.getProperty("Environment");
		if (envName!= null && envName!=" ")
		{
			return envName;
		}
		else
		{
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}

	}

	@SuppressWarnings("unused")
	public String getURL()
	{
		String url=pro.getProperty("ApplicationURL");
		if (url!= null && url!=" ")
		{
			return url;
		}
		else
		{
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}

	}
	
	public String getInputDataFile()
	{
		String excelName=pro.getProperty("InputDataFile");
		if (excelName!= null && excelName!=" ")
		{
			return excelName;
		}
		else
		{
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}
		
	}

}

