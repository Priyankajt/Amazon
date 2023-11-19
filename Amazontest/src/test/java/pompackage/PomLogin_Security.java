package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomLogin_Security extends BaseamazonClass {

	@FindBy (xpath="//h2[contains(text(),'Login & security')]") WebElement Login; 	
	@FindBy (xpath="//input[@id='auth-cnep-edit-name-button']") WebElement Edit;
	@FindBy (name ="customerName") WebElement namebox; 
	@FindBy (xpath="//input[@id='cnep_1C_submit_button']") WebElement button;
	@FindBy (xpath ="//span[contains(text(),'You successfully changed your account!')]") WebElement Success;
	@FindBy (xpath="//div[contains(text(),'Amit')]") WebElement text;
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement editbutton;
	@FindBy (name="newMobilePhoneNumber") WebElement add; 
	@FindBy (xpath="//input[@id='auth-continue']") WebElement continue_button;
	@FindBy (xpath="//input[@id='auth-cnep-add-phone-button']") WebElement addbutton;
	@FindBy (css="#auth-verification-ok-announce") WebElement Button4;
	@FindBy (xpath="//h4[contains(text(),'Mobile number already in use')]") WebElement Error;
	@FindBy (xpath="//a[@id='auth-account-conflict-continue-verify-url']") WebElement Yes;
	
	@FindBy (xpath="//input[@id='auth-cnep-edit-phone-button']") WebElement button5;
	@FindBy (xpath="//button[contains(text(),'Delete')]") WebElement delete;
	@FindBy (name="deleteMobilePhone") WebElement yesdelete;
	@FindBy (xpath="//a[@id='phoneModalLink']") WebElement text2;


public PomLogin_Security() {
	PageFactory.initElements(driver, this);
}


public void loginsecuritybtn()
{
	boolean result =Login.isDisplayed();
	System.out.println(result);
	Login.click();
}
public void updatename() {
	
	Edit.click();
}

public void typename(String name) {
	namebox.clear();
	namebox.sendKeys(name);
}
public void Clickb() {
	button.click();
	
	String actual= Success.getText();
	String expected= "You successfully changed your account!";
	Assert.assertEquals(actual, expected);
	System.out.println(actual);
	String result= text.getText();
	Assert.assertEquals(result, "Amit");
	System.out.println(result);
}
public void addphone() {
	addbutton.click();
}
public void Typephone(String number) {
	add.sendKeys(number);
}
public void Clickbutton() {
	continue_button.click();

}
public void verifyframe() throws InterruptedException {
	Button4.click();
	

		String actual1=driver.getTitle();
		String expected1= "Amazon Phone Verification";
		Assert.assertEquals(actual1, expected1);
		System.out.println(actual1);
	
}
public void deletemobile() throws InterruptedException {
	Thread.sleep(5000);
	button5.click();	
}
public void deletebutton() {
	delete.click();
}

public void confirmdelete() {
	yesdelete.click();
}
public void verify() {
	Login.click();
	boolean stringg = addbutton.isDisplayed();
	System.out.println(stringg);
}

}
