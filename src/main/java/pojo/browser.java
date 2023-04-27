package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser {
	static WebDriver driver;
	
	public static WebDriver crossBrowser (String browser) {
		
	if(browser.equals("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(opt);
	}	
	
	else if(browser.equals("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();	
	}
		
	driver.manage().window().maximize();
	
	driver.get("https://www.saucedemo.com/");
	
	return driver;
}

}
