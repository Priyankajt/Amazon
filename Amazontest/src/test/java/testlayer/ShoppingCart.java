package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomShoppingCart;

public class ShoppingCart extends BaseamazonClass {
	PomShoppingCart log;
	public ShoppingCart()
	{
		super();
	}
	
	
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
		BaseamazonClass.initiation();
		BaseamazonClass.login();
	    log= new PomShoppingCart ();
    }
@Test(priority=1)
	public void search() 
	{
		log.search("harry potter book 5");
		log.searchitem_click();
		log.addtocart();
		log.cartbutton_click();
		log.verifyadded_item();
	}
	@Test(priority=2)
	public void  cart() throws Exception 
	{
		log.cartbutton_click();
		
		log.quantity();
		log.search("The Alchemist");
		log.clickotheritem();
		log.addtocart();
		log.cartbutton_click();
	     log.verify();
		log.deletealchemist();
		log.deleteall();
	}
	@AfterMethod
	public void closebrowser() 
	{
		driver.close();
	}

}
