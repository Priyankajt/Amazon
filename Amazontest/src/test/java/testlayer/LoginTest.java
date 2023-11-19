package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseackage.BaseamazonClass;
import pompackage.PomLogin;
import testdata.DataProviderClass;

public class LoginTest extends BaseamazonClass {
	PomLogin pom;
	public LoginTest() 
	{
	super();
	}
	
	@BeforeMethod
	public void openbrowser() throws InterruptedException 
	{
		 BaseamazonClass.initiation();
		 pom= new PomLogin();
		 Thread.sleep(5000);
		pom.Signinbutton();
		
	}
	@Test(priority=1, dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void Login(String Condition, String Email, String Password) throws InterruptedException 
	{
		if(Condition.equals("VEmail")||Condition.equals("Vnumber") ) 
		{
		
		pom.provideEmail(Email);
		pom.continueButtonClick();
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.ca/ap/signin";
		Assert.assertEquals(actualURL, expectedURL,"Assertion Failed");
		
		}
		else if (Condition.equals("InEmail/mobile")) 
		{

			pom.provideEmail(Email);
			pom.continueButtonClick();
			Thread.sleep(2000);
			pom.emailerror();
		}
		  else if (Condition.equals("Inmobile")) 
		  {
		       
			  pom.provideEmail(Email);
			  pom.continueButtonClick();
			  pom.Loginmobileerror();
		  }
	      else if(Condition.equals("Inemail"))
	      {
	            
				    pom.provideEmail(Email);
				    pom.continueButtonClick();
				    pom.Loginemailerror();
	      }
	else if (Condition.equals("Invalidpass"))
	{

		pom.provideEmail(Email);
		pom.continueButtonClick();
		pom.providePassword(Password);
		pom.KeepMeSignedCheckboxCheck();
		pom.signInButtonClick();
		pom.passerror();
	}
		else if (Condition.equals("Incorrectpass")) 
		{

			    pom.provideEmail(Email);
				pom.continueButtonClick();
				pom.providePassword(Password);
				pom.KeepMeSignedCheckboxCheck();
				pom.signInButtonClick();
				pom.Inpasserror();
		}
		else if (Condition.equals("Vcase")) 
		{

		pom.provideEmail(Email);
		pom.continueButtonClick();
		pom.providePassword(Password);
		pom.KeepMeSignedCheckboxCheck();
		pom.signInButtonClick();
		Thread.sleep(2000);
		String CurrentURL= driver.getCurrentUrl();
		String ExpectedURL = "https://www.amazon.ca/?ref_=nav_signin&";
		String ExpectedURL1="https://www.amazon.ca/ap/cvf/request?arb=a0ba831d-a99f-46ed-8f26-3406e84236a1";
		if(CurrentURL.equals(ExpectedURL)) 
		{
			Assert.assertEquals(CurrentURL, ExpectedURL);
			System.out.println(CurrentURL);
		}
		else if(CurrentURL.equals(ExpectedURL1)) {
		Assert.assertEquals(CurrentURL, ExpectedURL1);
		System.out.println(CurrentURL);
		}

		pom.loggedin();
		driver.get("https://www.amazon.ca/");
		pom.loggedin();
	}
		

		
	}

	@AfterMethod
	public void close()
	{
	driver.close();
	}


}
