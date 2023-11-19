package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomPayment;

public class Payment extends BaseamazonClass {

PomPayment pom;
public Payment() 
{
	super();
}
@BeforeMethod
public void initmethods() throws InterruptedException 
{
BaseamazonClass.initiation();
BaseamazonClass.login();
pom=new PomPayment();
}

@Test(priority=1)
public void search() throws InterruptedException {
	pom.search("alchemist");
	pom.al();
	pom.add();
	pom.check();
	pom.assert1();
	pom.ship();
	pom.shipfee();	
}

@Test(priority=2)
public void Search2() throws InterruptedException {
pom.search("alexa");	
pom.Rado();
pom.add();
pom.check();
pom.shipfree();
pom.clickc();
pom.use();
Thread.sleep(5000);
pom.verifyerror();
}
@AfterMethod
public void closebrowser() {
	driver.close();
}
}
