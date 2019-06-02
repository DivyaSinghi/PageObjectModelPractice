package freeCRM_TestScenarios;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import freeCRM_Base.BaseTest;
import freeCRM_Modules.LoginModule;


public class FreeCRM_LoginTest extends BaseTest {	
	
	@Test(dataProvider="inputdata",description="searchparameter")
	public void LoginToFreeCRM(String TC_ID, LinkedHashMap<String,String> data)
	{
		System.out.println("inside LoginToFreeCRM");
		LoginModule loginmoduleobj = new LoginModule(driver);	
		loginmoduleobj.Login(configObj.getURL(),data);
		/*String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, "CRMPRO");*/
		/*String ActualTitle= loginmoduleobj.verifyTitle();
		Assert.assertEquals(ActualTitle, "CRMPRO");*/
	}
}


