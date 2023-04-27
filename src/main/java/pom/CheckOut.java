package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
    
	 @FindBy (xpath="//input[@id=\"first-name\"]")         private WebElement firstname ;
     @FindBy (xpath="//input[@placeholder=\"Last Name\"]") private WebElement lastname ;
     @FindBy (xpath="//input[@id=\"postal-code\"]")        private WebElement postalCode ;
     @FindBy (xpath="//button[@id='cancel']")              private WebElement cancel ;
     @FindBy (xpath="//input[@value=\"Continue\"]")        private WebElement continueOnCheckout ;
     
		     public CheckOut (WebDriver driver)
		     {
		    	 PageFactory.initElements(driver,this);
		     }
		     public void enteringFirstname (String name)
		     {
		    	 firstname.sendKeys(name);
		     }
		     public void enteringLastname (String name)
		     {
		    	 lastname.sendKeys(name);
		     }
		     public void enteringPostalCode (String name)
		     {
		    	 postalCode.sendKeys(name);
		     }
		     public void clickOnCancelButton () {
		    	 cancel.click();
		     }
		     public void clickOnContinueToCheckout ()
		     {
		    	 continueOnCheckout.click();
		     }
}
