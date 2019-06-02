package freeCRM_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeCRMHomePage_PO {
	
	static WebDriver driver;   //here we are creating local variable-driver
	public FreeCRMHomePage_PO(WebDriver driver)
	{
		FreeCRMHomePage_PO.driver=driver;
	}
	
	 By contactsTab=By.xpath("//a[@title='Contacts']");
	  By companiesTab=By.xpath("//a[@title='Companies']");
	
	public  void getContactsTab()
	{
		driver.findElement(contactsTab).click();
	}
	
	public  void getCompaniesTab()
	{
		driver.findElement(companiesTab).click();
	}
}
