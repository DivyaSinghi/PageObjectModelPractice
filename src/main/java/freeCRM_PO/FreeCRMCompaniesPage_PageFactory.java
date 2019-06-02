package freeCRM_PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import freeCRM_Base.BasePageObject;

public class FreeCRMCompaniesPage_PageFactory extends BasePageObject{
	
	WebDriver driver;
	public FreeCRMCompaniesPage_PageFactory(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(xpath="//td[text()='Name']/following-sibling::td/input[@type='text']")
	WebElement inputName;

	@FindBy(xpath="//input[@value='New Company']")
	WebElement clickNewCompany;
	
	@FindBy(xpath="//input[@name='company_name']")
	WebElement inputCompanyName;
	
	@FindBy(xpath="//input[@value='Max']//following::input[@value='Save']")
	WebElement saveButton;
	
	public void clickNewcompany()
	{
		clickNewCompany.click();
	}
	
	public void newCompanyName()
	{
		inputCompanyName.sendKeys("Google");
	}
	
	public void clickSave()
	{
		saveButton.click();
	}
	
	
			
	
	
}
