package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomLogin extends BaseamazonClass {

@FindBy(id="ap_email")WebElement emailField;
	
	@FindBy(id="continue")WebElement continueButton;
	
	@FindBy(id="ap_password")WebElement passwordField;
	
	@FindBy(xpath="//input[@id='signInSubmit']")WebElement signInButton;
	
	@FindBy(xpath="//input[@name='rememberMe']")WebElement keepLoggedIn;
    @FindBy(xpath="//div[contains(text(),'Enter your e-mail address or mobile phone number')]") WebElement EmailError;
    @FindBy (xpath="//div[contains(text(),'Enter your password')]") WebElement Ipass;
    @FindBy(xpath="//span[contains(text(),' Your password is incorrect')]") WebElement Inpass;
    @FindBy(xpath="//span[contains(text(),'Hello, Shruti')]") WebElement WelcomeMessage;
    @FindBy (xpath="//div[@id='nav-al-signin']/div//a//span[contains(text(),'Sign in')]") WebElement Signin;
	

	 public PomLogin()
	 {	       
	        PageFactory.initElements(driver,this);
	 }
	 public void Signinbutton() throws InterruptedException 
	 {
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		 Thread.sleep(2000);

		 String actualresult= Signin.getText();
		 String expectedresult= "Sign in";
		 System.out.println(actualresult);
		 Assert.assertEquals(actualresult, expectedresult);
		 Signin.click();

		 }


	public void provideEmail(String email) 
	{
           emailField.sendKeys(email);		
	}
    
	public void continueButtonClick()
	{
	     continueButton.click();
	}

	public void providePassword(String password) 
	{
	     passwordField.sendKeys(password);
	  
	}
	
	public void signInButtonClick() 
	{
		signInButton.click();
	}

	
	public void KeepMeSignedCheckboxCheck()
	{
		keepLoggedIn.click();
	}
	
	public void emailerror() 
	{
		String actualerror=EmailError.getText();
		String expectederror= "Enter your e-mail address or mobile phone number";
		Assert.assertEquals(actualerror, expectederror);
		System.out.println(actualerror);
	}

	public void Loginemailerror() 
	{
		String actualerror =driver.findElement(By.className("a-list-item")).getText();
		String expectederror="We cannot find an account with that e-mail address";
		Assert.assertEquals(actualerror, expectederror);
		System.out.println(actualerror);
	}
	public void Loginmobileerror() 
	  {
		String actualerror =driver.findElement(By.className("a-list-item")).getText();
		String expectederror="We cannot find an account with that mobile number";
		Assert.assertEquals(actualerror, expectederror);
		System.out.println(actualerror);
		}
		public void passerror() {
		String actual= Ipass.getText();
		String Expected= "Enter your password";
		Assert.assertEquals(actual, Expected);
		System.out.println(actual);
		}


		public void Inpasserror() {
		String actual= Inpass.getText();
		String Expected= "Your password is incorrect";
		Assert.assertEquals(actual, Expected);
		System.out.println(actual);
		}


		public void verifytitle() 
		{
		String actual=driver.getTitle();
		if(actual.equals("Amazon Sign In")) 
		{
		Assert.assertEquals(actual, "Amazon Sign In");
		System.out.println(actual);
		}
		else if (actual.equals("amazon.ca")) {
		Assert.assertEquals(actual, "Amazon.ca");
		System.out.println(actual);
		}
		else if (actual.equals("Authentication required")) {
		Assert.assertEquals(actual, "Authentication required");
		System.out.println(actual);
		}
		}
		public void loggedin() 
		{
		String actual = WelcomeMessage.getText();
		String expected = "Hello, Shruti";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		}

}
