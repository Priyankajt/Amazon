package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseackage.BaseamazonClass;
import pompackage.PomLogin_Security;
import pompackage.PomYourPayment;

public class LoginSecurity extends BaseamazonClass {
	PomYourPayment pom;
	PomLogin_Security log;
	public LoginSecurity() 
	{
		super();
	}
	
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
		BaseamazonClass.initiation();
		BaseamazonClass.login();
		pom=new PomYourPayment();
		pom.Click1();
		log= new PomLogin_Security();
		log.loginsecuritybtn();
      }
@Test(priority=3)
public void name() 
{
	log.updatename();
	log.typename("Amit");
	log.Clickb();
	
}
@Test(priority=2)
public void phone() throws InterruptedException {
	log.addphone();
	log.Typephone("6475627200");
	log.Clickbutton();
	Thread.sleep(3000);
	log.verifyframe();
}	

	@Test(priority=1)
	public void delete() throws InterruptedException {
	log.deletemobile();
	log.deletebutton();
	Thread.sleep(5000);
	log.confirmdelete();
	log.verify();
}
	
@AfterMethod
public void closebrowser() 
{
	driver.close();
}
}
