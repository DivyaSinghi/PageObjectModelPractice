package freeCRM_Modules;

import org.openqa.selenium.WebDriver;

import freeCRM_Base.BaseTest;
import freeCRM_PO.FreeCRMHomePage_PO;

public class HomePageModule{

	static WebDriver driver;
	
	public HomePageModule(WebDriver driver)
	{
		HomePageModule.driver=driver;
	}

	public void homePageContactTab() throws InterruptedException
	{
		FreeCRMHomePage_PO homePageObj=new FreeCRMHomePage_PO(driver);
		homePageObj.getContactsTab();
		Thread.sleep(5000);
		
	}
	
	public void homePageCompaniesTab() throws InterruptedException
	{
		FreeCRMHomePage_PO homePageObj=new FreeCRMHomePage_PO(driver);
		homePageObj.getCompaniesTab();
		Thread.sleep(5000);
		
	}
}
