package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class parametrization {
  
	public static String excelSheetData (String sheetname ,int row ,int cell) throws EncryptedDocumentException, IOException {
	  
	   FileInputStream file = new FileInputStream ("C:\\Users\\gaura\\OneDrive\\Documents\\gitWorkSpace\\SwagLabs\\src\\test\\resources\\SwagLabs XLSX Worksheet.xlsx");
	   return WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	 
   }
}
