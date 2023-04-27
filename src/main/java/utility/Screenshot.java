package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
  public static void takescreenShot (WebDriver driver , String name) throws IOException
  {
	    String dateAndTime =dateandtime.getdateAndTime();
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\gaura\\OneDrive\\Documents\\gitWorkSpace\\SwagLabs\\Screenshot"+name+dateAndTime+".png");
		FileHandler.copy ( source , destination );
	}
	
  }
