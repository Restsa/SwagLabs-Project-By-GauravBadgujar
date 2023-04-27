package test;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pojo.browser;
import pom.CartPage;
import pom.CheckOut;
import pom.CheckoutOverview;
import pom.Loginpage;
import pom.ProductPage;
import utility.parametrization;
import utility.reports;
@org.testng.annotations.Listeners (test.Listeners.class)

public class Swaglabapplication extends BaseTest{
 
   ExtentReports report ;
   ExtentTest test ;
 
   @BeforeTest 
  public void setUpReports () 
  {
	  report=reports.createReports();
  }
 

	@BeforeMethod
	@Parameters({"Browser"})
	public void Browser(String Browser) {
		driver = browser.crossBrowser("Browser");
	}
	
  
   @AfterTest
   public void getReports ()
   {
	   report.flush();
   }
  
   @AfterMethod
   public void getResult (ITestResult result)
   {
	   if (result.getStatus()==ITestResult.SUCCESS)
	   {
		   test.log(Status.PASS,result.getName());
	   }
	   else if (result.getStatus()==ITestResult.FAILURE)
	   {
		   test.log(Status.FAIL,result.getName());
	   }
	   else if (result.getStatus()==ITestResult.SKIP)
	   {
		   test.log(Status.SKIP,result.getName());
	   }
   }
  
   @DataProvider (name="LoginData")
   public Object [] [] loginTestData () throws EncryptedDocumentException, IOException {
	   return new Object [] [] {{ExcelData.readUsername1(),ExcelData.password()}};
//			                   {ExcelData.readUsername2(),ExcelData.password()},
//			                   {ExcelData.readUsername3(),ExcelData.password()},
//			                   {ExcelData.readUsername4(),ExcelData.password()}};
   }
   @Test
   (dataProvider="LoginData")
   public void verifyIfCustomerAbleToAddProductToCart (String username , String password) throws EncryptedDocumentException, IOException
   { 
	   test = report.createTest("loginFunctionlity");
	  
	   Loginpage login = new Loginpage (driver);
	   login.enterUserName(username);
	   login.enterPassword(password);
	   login.clickOnLoginpage();
	   
	   ProductPage productpage = new ProductPage (driver);
	   productpage.addToCartProduct(5);
	   productpage.clickOnShoppingCart();
	   
	   CartPage cartpage = new CartPage (driver);
	   int products = cartpage.checkOnCartData();
	   Assert.assertTrue(products>0);
	   System.out.println("CartItom:- " +products);
	   
   }
   @Test
   public void verifyIfCustomerAbleToRemoveProductFromCart () throws InterruptedException
   {
	   Loginpage login = new Loginpage (driver);
	   login.enterUserName("standard_user");
	   login.enterPassword("secret_sauce");
	   login.clickOnLoginpage();
	   
	   ProductPage productpage = new ProductPage (driver);
	   productpage.addToCartProduct(1);
	   productpage.clickOnShoppingCart();
	   
	   CartPage cartpage = new CartPage (driver);
	   Thread.sleep(6000);
	   cartpage.clickOnRemoveItom(0);

       int products = cartpage.checkOnCartData();
	   Assert.assertTrue(products==0);
	   System.out.println("CartItom:- " +products);
   }
   @Test
   public void verifyIfCustomerAddMultipleProductOnCart ()
   {
	   Loginpage login = new Loginpage (driver);
	   login.enterUserName("standard_user");
	   login.enterPassword("secret_sauce");
	   login.clickOnLoginpage();
	  
	   ProductPage productpage = new ProductPage (driver);
	   productpage.addToCartProduct(1);
	   productpage.clickOnShoppingCart();
	  
	   CartPage cartpage = new CartPage (driver);
	   cartpage.clickOnContinueShopping();
	   productpage.addToCartProduct(2);
	   productpage.clickOnShoppingCart();
	   
	   int products = cartpage.checkOnCartData();
	   Assert.assertTrue(products>0);
	   System.out.println("CartItom:- " +products);
   }
   @Test
   (dataProvider="LoginData")
   public void verifyIfCustomerAbleToCheckoutOrder (String username , String password) throws InterruptedException, EncryptedDocumentException, IOException
   {   
	   test = report.createTest("verifyIfCustomerAbleToCheckoutOrder");
	   Loginpage login = new Loginpage (driver);
	   login.enterUserName(username);
	   login.enterPassword(password);
	   login.clickOnLoginpage();
	   
	   ProductPage productpage = new ProductPage (driver);
	   int products = productpage.noOfProducts();
	   System.out.println("Total no of products in a page:- " +products);
	   productpage.addToCartProduct(0);
	   productpage.clickOnShoppingCart();
	  
	   CartPage cartpage = new CartPage (driver);
	   int items = cartpage.checkOnCartData();
	   System.out.println("No of Items in Cart:- " +items);
	   
	   SoftAssert softassert = new SoftAssert();
	   softassert.assertTrue(items>0);
	   softassert.assertAll();
	   
	   cartpage.clickOnCheckout();
	  
	   CheckOut cart = new CheckOut (driver);
	   cart.enteringFirstname("Gaurav");
	   cart.enteringLastname("Badgujar");
	   cart.enteringPostalCode("425001");
	   cart.clickOnContinueToCheckout();
	  
	   CheckoutOverview overview = new CheckoutOverview (driver);
	   Double priceOfItem = overview.getProductPrice(0);
	   Double tax = overview.getTax();
	   Double totalAmount = overview.checkTotalProductPrice();
	   Double expected = tax+priceOfItem;
	  
	   SoftAssert softassert1 = new SoftAssert () ;
	   softassert.assertEquals(totalAmount, expected);
	   softassert.assertAll();
	   
       System.out.println();
	   System.out.println();
	   System.out.println("price of item:- " + priceOfItem);
	   System.out.println("tax :- " + tax);
	   System.out.println("total amount:- " + totalAmount);
	   Thread.sleep(2000);
	   overview.clickOnFinish();
	   overview.getFinalDisplayed();
  }
}