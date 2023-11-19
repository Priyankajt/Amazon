package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomYourPayment;

public class YourPayment extends BaseamazonClass {
	PomYourPayment pom;
	public YourPayment() 
	{
		super();
	}
	
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
		BaseamazonClass.initiation();
		BaseamazonClass.login();
		pom= new PomYourPayment();
		pom.Click1();
}
@Test(priority=1)
public void verifybutton() {
	pom.assert_();
	pom.Addpayment1();
	pom.asserturl();
}

@Test(priority=2)
public void addcard() throws InterruptedException {
	pom.Addpayment1();
	pom.Addpayment2();
	pom.Addpayment3();
	Thread.sleep(6000);
	driver.switchTo().frame(0);
	pom.Typecardno(prop.getProperty("cardno"));
	pom.Typename(prop.getProperty("name"));
	pom.date();
	pom.Year();
	pom.acard();
	pom.uaddress();
	pom.SEvent();
	Thread.sleep(8000);
	driver.switchTo().defaultContent();
	pom.Assert1();
	pom.Assert2();
	
}
@Test(priority=3)
public void Default() throws InterruptedException 
{
	pom.Addpayment1();
	pom.settings();
	pom.preference();
	pom.change();
	Thread.sleep(5000);
	pom.radiobutton();
	pom.continuebutton();
	
	Thread.sleep(2000);
	
	pom.wallet();
	pom.Assert3();
}
@AfterMethod
public void close() {
	driver.close();
}

}
