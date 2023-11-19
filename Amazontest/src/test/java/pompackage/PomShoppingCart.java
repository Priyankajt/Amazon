package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseackage.BaseamazonClass;

public class PomShoppingCart extends BaseamazonClass{
	@FindBy(id="twotabsearchtextbox") WebElement Search;
	@FindBy(id="nav-search-submit-button") WebElement submit; 
   @FindBy(xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']/div/div/div/div/h2/a/span") WebElement book;
   @FindBy(name="submit.add-to-cart") WebElement addtocart;
@FindBy(id="nav-cart") WebElement cart;
@FindBy (name="quantity") WebElement selectbox;
@FindBy (xpath="//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']") WebElement gettext; 
@FindBy (xpath="//span[@class='a-truncate-cut'][contains(text(),'Harry Potter and the Order of the Phoenix')]") WebElement addeditemtext;
@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")WebElement AddedtoCartText;
@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='The Alchemist']") WebElement alchemist;


@FindBy(xpath="//input[@value='Delete'] [@aria-label='Delete Harry Potter and the Order of the Phoenix' ]") WebElement delete_harrypotter5;

@FindBy(xpath="//input[@value='Delete'] [@aria-label='Delete The Alchemist' ]") WebElement delete_alchemist;
@FindBy(xpath="//h1[@class='a-spacing-mini a-spacing-top-base']") WebElement cartempty; 
public PomShoppingCart() 
{
	PageFactory.initElements(driver, this);
}

public void search(String name) {
	Search.sendKeys(name);
	submit.click();	;
}

public void searchitem_click() {
	book.click();
}

public void addtocart() 
{
	addtocart.click();
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Amazon.ca Shopping Cart");
	System.out.println(actual);
	 String Actualtext = AddedtoCartText.getText();
	  Assert.assertEquals(Actualtext, "Added to Cart");
	  System.out.println(Actualtext);
}
public void cartbutton_click() {
	cart.click();
}

public void verifyadded_item() 
{
	String actual = addeditemtext.getText();
	Assert.assertTrue(actual.contains("Harry Potter and the Order of the Phoenix"));
	System.out.println(actual);
}
public void quantity() throws InterruptedException {
Select obj=new Select(selectbox);
obj.selectByVisibleText("2");
Thread.sleep(5000);
String actual= gettext.getText();
Assert.assertTrue(actual.contains("Subtotal (2 items): $31.68"));
System.out.println(actual);
}

public void clickotheritem() 
{
	alchemist.click();

}

public void verify() 
{
	String actual = gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (3 items): $52.47"));
	System.out.println(actual);
}
public void deletealchemist() {
	delete_alchemist.click();
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (2 items): $31.68"));
	System.out.println(actual);
}
public void deleteall()
{
	delete_harrypotter5.click();
	delete_harrypotter5.click();
	
	String actual= gettext.getText();
	Assert.assertTrue(actual.contains("Subtotal (0 items):"));
	System.out.println(actual);
	
	System.out.println(cartempty.getText());
	
}


}
