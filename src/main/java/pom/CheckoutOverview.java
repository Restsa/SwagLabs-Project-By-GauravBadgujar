package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {
   
   @FindBy (xpath="//button[@id=\"cancel\"]")               private WebElement       cancel ;
   @FindBy (xpath="//button[@id=\"finish\"]")               private WebElement       finish ;
   @FindBy (xpath="//button[text()='Back Home']")           private WebElement       backHome ;
   @FindBy (xpath="//div[@class=\"inventory_item_price\"]") private List<WebElement> productPrice ;
   @FindBy (xpath="//div[text()='Item total: $']")          private WebElement       itemTotal ;
   @FindBy (xpath="//div[text()='Tax: $']")                 private WebElement       tax ;
   @FindBy (xpath="class=\"cart_quantity\"")                private List<WebElement> quantity ;
   @FindBy (xpath="//div[@class='summary_info_label summary_total_label']")private WebElement totalprice ;
   @FindBy (xpath="//h2[@class='complete-header']")         private WebElement thanksDisplayed ;
   
		   public CheckoutOverview (WebDriver driver)
		   {
			   PageFactory.initElements(driver,this);
		   }
		   public void clickOnCancel ()
		   {
			   cancel.click();
		   }
		   public void clickOnFinish ()
		   {
			   finish.click();
		   }
		   public void clickOnBackHome ()
		   {
			   backHome.click();
		   }
		   public double getProductPrice(int index)
		   {
			   String price =productPrice.get(index).getText();
			   return Double.parseDouble(price.substring(1));  
		   }
		   public double getItomTotal ()
		   {
			   String price = itemTotal.getText();
			   return Double.parseDouble(price.substring(12));
		   }
		   public double getTax ()
		   {
			   String taxamount = tax.getText();
			   return Double.parseDouble(taxamount.substring(6));
		    }
		   public String getProductQuantity(int index) {
			   String Qty = quantity.get(index).getText();
			   return Qty ;
		   }
		   public double checkTotalProductPrice () {
			   String price = totalprice.getText();
			   return Double.parseDouble(price.substring(8));
		   }
		   public void getFinalDisplayed ()
		   {
			   boolean result = thanksDisplayed.isDisplayed();
			   System.out.println("Final Page is Display:- " +result);
		   }
}

