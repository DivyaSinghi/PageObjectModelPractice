package freeCRM_PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FreeCRMLogin_PO {

	WebDriver driver;   //here we are creating local variable-driver
	public FreeCRMLogin_PO(WebDriver driver)
	{
		this.driver=driver;
	}

	By userName= By.xpath("//input[@type='text']");
	By passWord= By.xpath("//input[@type='password']");
	By submitButton= By.xpath("//input[@type='submit']");

	public void enterUserName(String un)
	{
		driver.findElement(userName).sendKeys(un);
	}

	public void enterPassword(String pwd)
	{
		driver.findElement(passWord).sendKeys(pwd);
	}

	public void clickButton()
	{
		driver.findElement(submitButton).click();
	}
}

