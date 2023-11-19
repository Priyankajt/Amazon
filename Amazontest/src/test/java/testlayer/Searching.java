package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomSearch_Sort_Filter;
import testdata.DataProviderClass;

public class Searching extends BaseamazonClass {
	PomSearch_Sort_Filter log;
	public Searching() 
	{
		super();
	}
	
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
		BaseamazonClass.initiation();
		log=new PomSearch_Sort_Filter();
    }

	@Test(priority=1, dataProvider = "data-provider-keywords", dataProviderClass = DataProviderClass.class)
	public void searchbox(String Keywords) throws InterruptedException
	{
		log.search(Keywords);
		Thread.sleep(5000);
		log.verifysearchelementwithkeywords();	
	}
	
	@Test(priority=2)
	public void verify_itemnumber() throws InterruptedException 
	{
		log.search("AQ1701");
		log.verifysearchelementwith_itemnumber();
		Thread.sleep(5000);
		
	}
	@Test(priority=3)
	public void verify_partial_itemnumber() throws InterruptedException 
	{
		log.search("AQ17");
		log.verifysearchelementwith_partial_itemnumber();
		Thread.sleep(5000);
		
	}
	@Test(priority=4)
	public void verify_categorywise() throws InterruptedException 
	{
		log.search("shoes");
		log.verifycategorywise();
		Thread.sleep(5000);
		
	}
	@Test(priority=5)
	public void verify_searchpageresults() throws InterruptedException 
	{
		log.search("shoes");
		log.verifycategorywise();
		Thread.sleep(5000);
		
	}
	@Test()
	public void product_details() throws InterruptedException 
	{
		log.search("adidas");
		Assert.assertEquals(driver.getTitle(), "Amazon.ca : adidas");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		log.verifyproductimage();
		Thread.sleep(8000);
		
		log.verifyproductname();
		Thread.sleep(8000);
		
	//	log.verifyproductprice();
		Thread.sleep(8000);
		
		log.verify_rating();
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		log.verify_review();

    	//driver.navigate().back();
		log.verifynavigatenextbtn();
		Thread.sleep(5000);
		log.verifynavigateprevbtn();
		Thread.sleep(5000);
		log.items();
		
	
		}
	
	
@AfterMethod
public void closebrowser()
{
	driver.close();
}	


}
