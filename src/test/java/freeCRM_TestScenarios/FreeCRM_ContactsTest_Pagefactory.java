package freeCRM_TestScenarios;

import org.testng.annotations.Test;

import freeCRM_Base.BaseTest;
import freeCRM_Modules.ContactsPageFactoryModule;

public class FreeCRM_ContactsTest_Pagefactory extends BaseTest{


	@Test
	public void navigateToContactsTab() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.switchTo().frame("mainpanel");
		//ContactsPageFactoryModule contactsobj=new ContactsPageFactoryModule(driver);
		//contactsobj.navigateToContacts();
		ContactsPageFactoryModule.navigateToContacts();
	}
}
