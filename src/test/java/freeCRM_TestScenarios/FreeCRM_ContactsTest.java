package freeCRM_TestScenarios;

import org.testng.annotations.Test;

import freeCRM_Base.BaseTest;
import freeCRM_Modules.ContactPageModule;
import freeCRM_Modules.HomePageModule;
import freeCRM_Modules.LoginModule;

public class FreeCRM_ContactsTest extends BaseTest{
	
	@Test(priority=0)
	public void createNewContact() throws InterruptedException{
	LoginModule loginmoduleobj = new LoginModule(driver);	
	//loginmoduleobj.Login(null);
	HomePageModule homepagemoduleobj=new HomePageModule(driver);
	homepagemoduleobj.homePageContactTab();
	
	ContactPageModule contactpagemodule = new  ContactPageModule(driver);
	contactpagemodule.createNewContact();
	}
	
	
}
	
	
	

