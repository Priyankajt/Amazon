package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseackage.BaseamazonClass;

public class ProductDetailsPage extends BaseamazonClass{

	@FindBy(css="strong.current-item")public WebElement productNamebreadCrumb;
	@FindBy(id="buy-now-button")WebElement BuyNow;
	@FindBy(xpath="//input[@id='add-to-cart-button']")WebElement addToCartBtn;

	public ProductDetailsPage()
	{
		
        PageFactory.initElements(driver,this);
	}
	
	
	public void AddToCart()
	{
		addToCartBtn.click();
	}
	
}
