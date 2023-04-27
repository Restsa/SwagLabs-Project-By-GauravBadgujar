package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateandtime {
  
	public static String getdateAndTime () {
	   
	   LocalDateTime date = LocalDateTime.now();
	   DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-mm-yyyy HH-mm-ss");
	   String dateandtime = date.format(pattern);
	  
	   return dateandtime ;
   }
}
