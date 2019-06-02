package freeCRM_Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import freeCRM_PO.FreeCRMContactsPage_PageFactory;

public class ContactsPageFactoryModule {
	static WebDriver driver;

	public ContactsPageFactoryModule(WebDriver driver)
	{
		ContactsPageFactoryModule.driver=driver;
	}

	public static void navigateToContacts()
	{
		FreeCRMContactsPage_PageFactory contactobj=PageFactory.initElements(driver, FreeCRMContactsPage_PageFactory.class);
		contactobj.hoverToContacts();
		contactobj.clickNewContact();
		contactobj.enterFirstName();
	}

}
