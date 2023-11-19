package testlayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseackage.BaseamazonClass;
import pompackage.PomSearch_Sort_Filter;

public class Sort extends BaseamazonClass {
	PomSearch_Sort_Filter log;
	public Sort() 
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
	@Test
	public void sortPrice() 
	{
		
		log.search("Shoes");
		log.sortMenu();
		log.sortingPrice();
		
	}


}
