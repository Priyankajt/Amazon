package pompackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomSearch_Sort_Filter extends BaseamazonClass {
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; 
	@FindBy(xpath="//span[contains(text(),'adidas')]") WebElement assertelement;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-color-state a-text-bold']") WebElement itemnumbertext;
	@FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(text(),'\"AQ17\"')]") WebElement partialitemnumbertext;
	@FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']//span[contains(text(),'shoes')]")WebElement categorywisetext;
	@FindBy(xpath="//div[@class='s-no-outline']//span[contains(text(),'RESULTS')]")WebElement searchpagetext;
	@FindBy(xpath="//img[@alt='adidas Mens Tiro 21 Track Pants']") WebElement searchelementimage;
	@FindBy(xpath="//span[contains(text(),'Mens Tiro 21 Track Pants')]") WebElement productname; 
	 @FindBy(xpath="//span[@class='a-price']//span[contains(text(),'$52.95')]") WebElement productprice;
    @FindBy(xpath="//span[contains(text(),'4.7 out of 5 stars')]") WebElement rating;
   
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_7']//span[contains(text(),'5,529')]") WebElement review;
	@FindBy(linkText="Next") WebElement next;
	@FindBy(linkText="Previous") WebElement previous;

	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected' and @aria-label='Current page, page 2']") WebElement page2;
	 @FindBy(xpath="//span[@class='s-pagination-item s-pagination-selected' and @aria-label='Current page, page 1']") WebElement page1;
	@FindBy(xpath="//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']//span[@class='a-offscreen']") WebElement sorting;
	 
	 
	 public PomSearch_Sort_Filter() 
	 {
		PageFactory.initElements(driver, this);
	}
	 public void search(String name) 
	 {
			Search.sendKeys(name);
			submit.click();	
	}
	 public void verifysearchelementwithkeywords() 
	 {
			String actual= assertelement.getText();
			Assert.assertTrue(actual.contains("adidas"));
			System.out.println(actual);
	 }
	 public void verifysearchelementwith_itemnumber() 
	 {
		 String actual= itemnumbertext.getText();
			Assert.assertTrue(actual.contains("AQ1701"));
			System.out.println(actual);
	 }
	 public void verifysearchelementwith_partial_itemnumber() 
	 {
		 String actual= partialitemnumbertext.getText();
			Assert.assertTrue(actual.contains("AQ17"));
			System.out.println(actual);
	 }
	 public void verifycategorywise() 
	 {
		 String actual= categorywisetext.getText();
			Assert.assertTrue(actual.contains("shoes"));
			System.out.println(actual);
	 }
	 public void verifysearchpage_results()
	 {
		 String actual= searchpagetext.getText();
			Assert.assertTrue(actual.contains("Results"));
			System.out.println(actual);
	 }
	 
	
	public void verifyproductimage()
	{
		boolean result=searchelementimage.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Image is Displayed");
		
	}
	public void verifyproductname() 
	{
		boolean result=productname.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Product Name is displayed");
		
		
	}
	public void verifyproductprice()
	{
		boolean result=productprice.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Product Price is displayed");
		
	}
	public void verify_rating() 
	{
		boolean result=rating.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Rating is displayed");
	}
	
	public void verify_review() {
		review.click();
		boolean result=review.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Reviews are displayed");
	}
	public void verifynavigatenextbtn() throws InterruptedException 
	{
		next.click();
		Thread.sleep(5000);
		boolean result=page2.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Page 2 is displayed");
	
	}
	public void verifynavigateprevbtn() throws InterruptedException {
		previous.click();
		Thread.sleep(5000);
		boolean result=page1.isDisplayed();
		Assert.assertTrue(result);
		System.out.println(result);
		System.out.println("Page 1 is displayed");

	}
public void items() 
{
	int pageitems= driver.findElements(By.xpath("//div[@class='s-card-container s-overflow-hidden aok-relative s-expand-height s-include-content-margin s-latency-cf-section s-card-border']")).size();
	Assert.assertEquals(pageitems, 60,"No of pages error");
	System.out.println(pageitems);

}
public void sortMenu() 
{
	  
	   Select dropdown=new Select(driver.findElement(By.name("s")));
	   dropdown.selectByIndex(1);
}
@SuppressWarnings("unchecked")
public void sortingPrice() 
{
	List<WebElement> elements = driver.findElements(By.className("a-price"));
	@SuppressWarnings("rawtypes")
	List originallist=new ArrayList();
	@SuppressWarnings("rawtypes")
	List templist=new ArrayList();

	for(WebElement e :elements) 
	   {
		   originallist.add(e.getText());
		   
		   templist.add(e.getText());
	   }
	   Collections.sort(templist);
	   System.out.println("Original List after Sorting:"+originallist);
	   System.out.println("Original List after Sorting:"+templist);
	  
	   if(originallist==templist) 
	   {
		   Assert.assertTrue(false);
	   }
}

}
