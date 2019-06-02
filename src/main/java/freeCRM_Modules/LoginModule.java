package freeCRM_Modules;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import freeCRM_Base.BaseTest;
import freeCRM_Base.ConfigFileReader;
import freeCRM_PO.FreeCRMHomePage_PO;
import freeCRM_PO.FreeCRMLogin_PO;

public class LoginModule {

	WebDriver driver;
	
	public LoginModule(WebDriver driver){
		this.driver=driver;
	}
	public void Login(String url, LinkedHashMap<String,String> data)
	{
		System.out.println("inside login method");
		driver.get(url);
		FreeCRMLogin_PO loginObj=new FreeCRMLogin_PO(driver);

		loginObj.enterUserName(data.get("UserName"));
		loginObj.enterPassword(data.get("Password"));
		loginObj.clickButton();
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS );
		//driver.switchTo().frame("mainpanel");

	}
	/*public String verifyTitle()
	{
		FreeCRMHomePage_PO homePageObj=new FreeCRMHomePage_PO(driver);
		return homePageObj.getPageTitle();
	}
	 */

}
