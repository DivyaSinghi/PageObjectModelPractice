package freeCRM_Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import freeCRM_PO.FreeCRMCompaniesPage_PageFactory;
import freeCRM_PO.FreeCRMContactsPage_PageFactory;

public class CompaniesPageModule {
	static WebDriver driver;

	public CompaniesPageModule(WebDriver driver )
	{
		CompaniesPageModule.driver=driver;
	}

	public void companiesModule()
	{
		FreeCRMCompaniesPage_PageFactory companiesobject=PageFactory.initElements(driver, FreeCRMCompaniesPage_PageFactory.class);
		companiesobject.clickNewcompany();
		companiesobject.newCompanyName();
		companiesobject.clickSave();


	}
}
