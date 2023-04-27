package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reports {
   public static ExtentReports createReports () {
	   
	    ExtentSparkReporter htmlReports = new ExtentSparkReporter("SwagLabsResult.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("TestedBy", "Gaurav Badgujar");
		reports.setSystemInfo("TestType", "Regression");
		return reports ; 
   }
}
