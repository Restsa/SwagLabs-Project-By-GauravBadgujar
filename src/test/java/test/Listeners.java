package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;


public class Listeners extends BaseTest implements ITestListener {
    
   public void onTestStart (ITestResult result)
      {
    	System.out.println("Test is started:-" +result.getName());
      }
   public void onTestFailure (ITestResult result)
     {
   //     System.out.println("Test is Fail:-" +result.getName());
	   try {
		   Screenshot.takescreenShot(driver, result.getName());
		} 
	   catch (Exception e) 
	   {
			e.printStackTrace();
		}
     }
   public void onTestSuccess (ITestResult result)
   {
	   System.out.println("Test is pass:-" +result.getName());
   }
   public void onTestSkipped (ITestResult result)
   {
	   System.out.println("Test is skipped:-" +result.getName());
   }
}
