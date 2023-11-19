package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomYourOrders;
import pompackage.PomYourPayment;

public class YourOrder extends BaseamazonClass{
	PomYourOrders log;
	PomYourPayment pom;
	public YourOrder()
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
		log=new PomYourOrders();
		log.yourorderbtn();
	
		
	}
	
@Test(priority=1)
   public void verifyordermenu()
	{
	
	
		log.dropdown_past30days();
		log.clickordersbtn();
		log.dropdown_past3month();
		log.clickordersbtn();
		log.dropdown_thisyear();
		
	}
	@Test(priority=2)
	public void verify_buyagain_no_orderhistory() 
	{
		
	  log.buyagaintabclick();
	  log.buyagainfunction_no_orderhistory();
	}
	@Test(priority=3)
	public void verify_notyetshipped_no_orderhistory() 
	{
		
		
	  log.notyetshippedclick();
	  log.notyetshippedfunction_no_orderhistory();
	}
	@Test(priority=4)
	public void verify_cancelledorder_orderhistory() 
	{
		
		log.Cancelledordersclick();
		log.cancelleditemfunction_orderhistory(); 
	
	}
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}

	

}
