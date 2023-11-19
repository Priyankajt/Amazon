package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomYourAccount extends BaseamazonClass {

	@FindBy(id="nav-link-accountList") WebElement Hellopriyanka;
	@FindBy(xpath="//span[contains(text(),'Your Account')]") WebElement Youraccount;
	@FindBy(xpath="//h1[contains(text(),'Your Account')]") WebElement Account;

	
	public PomYourAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void mousehover() 
	{
		Actions action= new Actions(driver);
		action.moveToElement(Hellopriyanka).build().perform();
	
		Youraccount.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void click() {
		Hellopriyanka.click();
		String actual=Account.getText();
		String expected = "Your Account";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
}
