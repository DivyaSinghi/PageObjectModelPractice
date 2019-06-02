package freeCRM_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freeCRM_Base.BasePageObject;

public class FreeCRMContactsPage_PO extends BasePageObject {
	static WebDriver driver;

	public FreeCRMContactsPage_PO(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	 By newContact=By.xpath("//input[@value='New Contact']");
	 By firstName=By.xpath("//input[contains(@name,'first_name')]");
	 By firstNameLabel=By.xpath("//strong[text()='First Name']");
	 By lastName=By.xpath("//input[contains(@name,'surname')]");
	 By lastNameLabel=By.xpath("//strong[text()='Last Name']");
	 By saveButton=By.xpath("//input[@value='Load From Company']/following-sibling::input[@value='Save']");
	 
	 public void clickNewContactButton()
	 {
		 clickOnElement(newContact);
		// driver.findElement(newContact).click();
	 }
	 
	 public WebElement verifyFirstNameLabel()
	 {
		WebElement text= getTextOfElement(firstNameLabel);
		 //return driver.findElement(firstNameLabel).getText();
		return text;
	 }
	public  void inputFirstName()
	{
		driver.findElement(firstName).sendKeys("Marck");
	}
	
	public String verifySecondNameLabel()
	{
		return driver.findElement(lastNameLabel).getText();
	}
	public  void inputLastName()
	{
		driver.findElement(lastName).sendKeys("Zukerberg");
	}
	
	public  void clickSaveButton()
	{
		driver.findElement(saveButton).click();
	}
}
