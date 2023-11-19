package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomYourOrders extends BaseamazonClass {
@FindBy(xpath="//h2[contains(text(),'Your Orders')]") WebElement yourorderbtn;
	
	
	@FindBy(xpath="//li[contains(text(),'Orders')]") WebElement ordersbtn;
	@FindBy(name="orderFilter") WebElement dropdown;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement text1;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement text2;
    @FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement text3;
    @FindBy(xpath="//a[text()='Buy Again' and @class='a-link-normal']") WebElement buyagaintab; 

    @FindBy(xpath="//a[contains(text(),'Not Yet Shipped')]") WebElement notyetshippedtab; 
    @FindBy(xpath="//a[contains(text(),'Cancelled Orders')]") WebElement cancelledorderstab; 
  
	@FindBy(xpath="//div[@class='a-row a-spacing-small']") WebElement text4;
	@FindBy(xpath="//div[@class='a-section a-spacing-top-medium a-text-center']") WebElement text5;
	@FindBy(xpath="//div[@class='']") WebElement text6;
	//We aren't finding any cancelled orders (for orders placed in the last 6 months). View all orders "
	@FindBy(xpath="//a[@id='a-autoid-1-announce' and @class='a-button-text']") WebElement Buyitagainbtn;
	@FindBy(xpath="//a[contains(text(),'Echo Dot (3rd gen) - Smart speaker with Alexa - Charcoal')]") WebElement Cancelleditemtext;
	@FindBy(xpath="//span[@class='a-size-medium a-text-bold']")WebElement cancelledtext;
	
	
	
	public PomYourOrders()
	{
		PageFactory.initElements(driver, this);
	}
	public void yourorderbtn() 
	{
		yourorderbtn.click();
		String expected="Your Orders";
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	public void clickordersbtn()
	{
		ordersbtn.click();
	}
	public void buyagaintabclick() 
	{
		buyagaintab.click();
	}
	public void notyetshippedclick()
	{
		notyetshippedtab.click();
	}
	public void Cancelledordersclick() 
	{
		cancelledorderstab.click();
	}
	public void dropdown_past30days()
	{
		Select drop=new Select(dropdown);
		drop.selectByIndex(0);
		String actual=text1.getText();
		String expected="You have not placed any orders in the past 30 days. View orders in past 3 months";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	public void dropdown_past3month()
	{
		Select drop=new Select(dropdown);
		drop.selectByIndex(1);
		String actual=text2.getText();
		String expected="Looks like you haven't placed an order in the last three months. View orders in 2022";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}

	public void dropdown_thisyear() 
	{
		Select drop=new Select(dropdown);
		drop.selectByIndex(2);
		String actual=text3.getText();
		String expected="You have not placed any orders in 2022.";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
	public void buyagainfunction_no_orderhistory() 
	{
	
		String actual=text4.getText();
		String expected="There are no recommended items for you to buy again at this time. Check Your Orders for items you previously purchased.";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	public void notyetshippedfunction_no_orderhistory() 
	{
	
		String actual=text5.getText();
		String expected="Looking for an order? All of your orders have shipped. View all orders";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}
	
	public void cancelleditemfunction_orderhistory() 
	{
		if(cancelledtext.getText().equals("Cancelled")) 
		{
			String expected="Echo Dot (3rd gen) - Smart speaker with Alexa - Charcoal";
	     	String actual=Cancelleditemtext.getText();
	     	Assert.assertEquals(actual, expected);
	     	System.out.println(actual);
	     //	Boolean status=Buyitagainbtn.isDisplayed();
	     	//Assert.assertEquals(true, true);
		}
		
}
}
