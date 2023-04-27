package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
     
     @FindBy (xpath="//button[@id=\"continue-shopping\"]") private WebElement        continueShopping ;
     @FindBy (xpath="//button[@id=\"checkout\"]")          private WebElement        checkOut ;
     @FindBy (xpath="//button[text()='Remove']")           private List <WebElement> Remove ;
     @FindBy (xpath="//div[@class='cart_item']")           private List<WebElement>  cartData ;
     
		     public CartPage (WebDriver driver)
		     {
		    	 PageFactory.initElements(driver,this);
		     }
		     
		     public void clickOnContinueShopping () {
		    	 continueShopping.click();
		     }
		     
		     public void clickOnCheckout ()
		     {
		    	 checkOut.click();
		     }
		     
		     public void clickOnRemoveItom (int index)
		     {
		    	 Remove.get(index).click();
		     }
		     public int checkOnCartData ()
		     {
		    	 return cartData.size();
		     }
}
