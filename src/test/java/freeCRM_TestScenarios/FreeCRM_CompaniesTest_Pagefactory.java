package freeCRM_TestScenarios;

import org.testng.annotations.Test;

import freeCRM_Base.BaseTest;
import freeCRM_Modules.CompaniesPageModule;
import freeCRM_Modules.HomePageModule;

public class FreeCRM_CompaniesTest_Pagefactory extends BaseTest {
	
	@Test
	public void createnewCompany() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		HomePageModule homeObj =new HomePageModule (driver);
		homeObj.homePageCompaniesTab();
		CompaniesPageModule compobj=new CompaniesPageModule(driver);
		compobj.companiesModule();
	}

}
