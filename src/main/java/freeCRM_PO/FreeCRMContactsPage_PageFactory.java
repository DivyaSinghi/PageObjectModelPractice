package freeCRM_PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import freeCRM_Base.BasePageObject;

public class FreeCRMContactsPage_PageFactory extends BasePageObject {
	WebDriver driver;
	Actions action;
	
	
	public FreeCRMContactsPage_PageFactory (WebDriver driver)
	{
		super(driver);
		action = new Actions(driver);
	}	
	//driver.switchTo().frame("mainpanel");
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	@FindBy(xpath="//input[contains(@name,'first_name')]")
	WebElement firstName;
	
	//legend[@class='fieldset' and text()='Contact Information']
	
	public void hoverToContacts()
	{
		action.moveToElement(contacts).build().perform();
	}
	
	public void clickNewContact()
	{
		newContact.click();
	}
	
	public void enterFirstName()
	{
		firstName.sendKeys("Abdul");
	}
	
}


	
	
	
	