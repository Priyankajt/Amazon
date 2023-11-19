package testlayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomSearch_Sort_Filter;
import testdata.DataProviderClass;

public class SearchFilter extends BaseamazonClass{

	PomSearch_Sort_Filter log;
	public SearchFilter() 
	{
		super();
	}
	
	@BeforeMethod
	public void initmethod() throws InterruptedException 
	{
		BaseamazonClass.initiation();
		BaseamazonClass.login();
		log=new PomSearch_Sort_Filter();
    }

	@Test(priority=1, dataProvider = "data-provider-keywords", dataProviderClass = DataProviderClass.class)
	public void searchbox(String Keywords) throws InterruptedException
	{
		log.search(Keywords);
		Thread.sleep(5000);
		log.verifysearchelementwithkeywords();	
	}
	public void dropdown()
	{
		
	}
}
