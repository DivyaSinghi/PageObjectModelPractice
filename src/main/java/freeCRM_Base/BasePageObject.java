package freeCRM_Base;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePageObject {

	protected WebDriver driver;
	WebElement elm;

	public BasePageObject (WebDriver driver)
	{
		this.driver=driver;
	}	

	public void clickOnElement(By locator)
	{
		elm=findElementsafely(locator);
		elm.click();
	}

	public void sendKeysOnElement(By locator, String text)
	{
		elm=findElementsafely(locator);
		elm.sendKeys(text);
	}

	public WebElement getTextOfElement(By locator)
	{
		elm=findElementsafely(locator);
		elm.getText();
		return elm;
	}


	public WebElement findElementsafely(final By locator){
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(180, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(locator);
			}
		});
		return foo;
	}

}
