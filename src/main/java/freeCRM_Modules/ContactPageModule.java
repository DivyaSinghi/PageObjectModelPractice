package freeCRM_Modules;

import org.openqa.selenium.WebDriver;

import freeCRM_PO.FreeCRMContactsPage_PO;

public class ContactPageModule {
	 WebDriver driver;
	
	public ContactPageModule(WebDriver driver){
		this.driver=driver;
	}
	public  void createNewContact()
	{
		FreeCRMContactsPage_PO contactsobj=new FreeCRMContactsPage_PO(driver);
		contactsobj.clickNewContactButton();
		contactsobj.inputFirstName();
		contactsobj.inputLastName();
		contactsobj.clickSaveButton();
		
	}
}
