package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomCreateAccount;
import testdata.DataProviderClass;

public class CreateAccount extends BaseamazonClass{
	PomCreateAccount pom;

	public CreateAccount() 
	{
	super();
	}
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
	BaseamazonClass.initiation();
	pom=new PomCreateAccount();
	pom.click();
	Thread.sleep(2000);
	}

	@Test(priority=1,dataProvider = "data-provider-createaccount", dataProviderClass = DataProviderClass.class)
	public void Yourname(String Condition, String name, String Email, String Password, String PasswordAgain) throws InterruptedException
	{
			if(Condition.equals("Invalid")) 
			{
			pom.typename(name);
			pom.typeemail(Email);
			pom.typepassword(Password);
			pom.typepasswordagain(PasswordAgain);
			pom.clickk();
			pom.verifyError();
			pom.verifybutton();
			}
			
			else if (Condition.equals("newcustomer")|| Condition.equals("Inphone")) {
			pom.typename(name);
			pom.typeemail(Email);
			pom.typepassword(Password);
			pom.typepasswordagain(PasswordAgain);
			Thread.sleep(5000);
			pom.verifybutton();
			pom.clickk();
			String CurrentURL= driver.getCurrentUrl();
			String ExpectedURL = "https://www.amazon.ca/ap/register";
			String ExpectedURL1="https://www.amazon.ca/ap/cvf/request?arb=a0ba831d-a99f-46ed-8f26-3406e84236a1";
			if(CurrentURL.equals(ExpectedURL))
			{
			Assert.assertEquals(CurrentURL, ExpectedURL);
			System.out.println(CurrentURL);
			}
			else if(CurrentURL.equals(ExpectedURL1)) 
			{
			Assert.assertEquals(CurrentURL, ExpectedURL1);
			System.out.println(CurrentURL);

	}}
	else if(Condition.equals("Alreadyregistered")) 
	{
	pom.typename(name);
	pom.typeemail(Email);
	pom.typepassword(Password);
	pom.typepasswordagain(PasswordAgain);
	pom.clickk();
	pom.returningcx();
	}
	}


	@AfterMethod
	public void close() {
	driver.close();
	}


}
