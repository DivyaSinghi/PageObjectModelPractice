package freeCRM_Base;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelReadWriteData;
import Utility.ExcelReading;

public class BaseTest {

	public static WebDriver driver;  //here we are initialising variable
	public static ConfigFileReader configObj;
	public static ExcelReadWriteData excelobj;
	static String ProjPath;
	protected static String currentDateTime;
	public String getDirectory;

	static
	{
		// fetch current date and time from calendar
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_sss"); //to convert the date in ur desired format use SimpleDateFormat java class
		currentDateTime=formater.format(calendar.getTime());
		System.out.println(currentDateTime);
				

		ProjPath=System.getProperty("user.dir");  //rootpath calculation
		configObj=new ConfigFileReader(ProjPath);
		configObj.loadPropertiesFile();
		String appName = configObj.getApplicationName();
		//To get fileName and to read excelFilename

		
		String filesName=appName+".html";
		@SuppressWarnings("unused")
		String getDirectory=CreateDirectoryStructure.getReportingDirectory(configObj.getApplicationName(), ProjPath, currentDateTime);
		ExtentManager.createInstance(filesName, configObj.getApplicationName(), configObj.getEnvironmentName());
		
		excelobj=new ExcelReadWriteData();		
		String fileName=configObj.getInputDataFile();
		excelobj.excelReadMthod(ProjPath,fileName );
	}

	@BeforeTest
	public void InvokeBrowser()
	{
		//String ProjPath=System.getProperty("user.dir"); //to identify project path
		System.out.println(ProjPath);
		String DriverPath=ProjPath+"/Drivers/chromedriver.exe"; //Concatenate project path with driver path
		System.out.println(DriverPath);
		System.setProperty("webdriver.chrome.driver", DriverPath);
		//webdriver.geeko.driver - for firefox driver

		driver = new ChromeDriver();

		driver.manage().window().maximize();  //maximize the window
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS );
	}

	@DataProvider(name="inputdata")
	public static Object[][] data(Method m)
	{
		String sheetname= m.getAnnotation(Test.class).description();
		System.out.println(sheetname);
		LinkedHashMap<Object,LinkedHashMap<Object,Object>> data= excelobj.getDataBySheetName(sheetname);
		System.out.println(data);
		Object[][] sheetData = new Object[data.size()][2];
		Iterator<Object> itr=data.keySet().iterator();

		int counter=0;
		while(itr.hasNext())
		{
			Object TC_ID=itr.next();
			sheetData[counter][0]=TC_ID;
			sheetData[counter][1]=data.get(TC_ID);
			counter++;
		}
		return sheetData;
	}
}


