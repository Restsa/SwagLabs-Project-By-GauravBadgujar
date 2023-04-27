package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
       
	    @FindBy (xpath ="//button[text()='Add to cart']")           private List<WebElement> addToCart ;
        @FindBy (xpath="//select[@class='product_sort_container']") private WebElement selectNameAtoZ  ;
        @FindBy (xpath="//button[text()='Open Menu']")              private WebElement openMenu        ;
        @FindBy (xpath="//a[@id=\"about_sidebar_link\"]")           private WebElement about           ;
        @FindBy (xpath="//a[@id=\"logout_sidebar_link\"]")          private WebElement logout          ; 
        @FindBy (xpath="//a[@id='reset_sidebar_link']")             private WebElement resetAppState   ;
        @FindBy (xpath="//a[@class=\"shopping_cart_link\"]")        private WebElement shoppingCart    ;
        @FindBy (xpath="//img[contains(@src,'static/media')]")      private List<WebElement> productImage ;
        @FindBy (xpath="//button[text()='Remove']")                 private List<WebElement> removeButton ;
        @FindBy (xpath="//a//div")                                  private List<WebElement> productName ;
        @FindBy (xpath="//div[@class='inventory_item']")            private List<WebElement> products ;
        
		      public ProductPage (WebDriver driver)
		      {
		    	  PageFactory.initElements(driver, this);
		      }
		      
		      public void addToCartProduct (int index)
		      {
		    	  addToCart.get(index).click();
		      }
		      public void clickOnShoppingCart ()
		      {
		    	  shoppingCart.click();
		      }
		      public void clickOnProduct (int index)
		      {
		    	  productImage.get(index).click();
		      }
		      public void clickOnMenu ()
		      {
		      openMenu.click();
		      }
		      public void clickOnLogout ()
		      {
		    	  logout.click();
		      }
		      public void clickOnAbout ()
		      {
		    	  about.click();
		      }
		      public void clickOnRestApp ()
		      {
		    	  resetAppState.click();
		      }
		     public Boolean checkingImages (int index)
		     {
		    	 WebElement image = productImage.get(index);
		    	 Boolean result = image.isDisplayed();
		    	 return result ;
		     }
		     public void checkingIfImagesAreSame (int a , int b)
		     {
		    	 String image1 = productImage.get(a).getText();
		    	 String image2 = productImage.get(b).getText();
		    	 if(image1 != image2)
		    	 {
		    		 System.out.println("Images of products are same");
		    	 }
		     }
		     public void clickOnRemove (int index)
		     {
		    	WebElement product = removeButton.get(index); 
		     }
		     public void nameOfProduct (int index)
		     {
		    	 WebElement product = products.get(index);
		     }
		     public int noOfProducts ()
		     {
		    	 int totalproducts = products.size();
		    	 return totalproducts ;
		     }
		    
}
