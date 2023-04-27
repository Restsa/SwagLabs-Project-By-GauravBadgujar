package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import utility.parametrization;

public class ExcelData {
   
	public static String readUsername1 () throws EncryptedDocumentException, IOException {
	String name = parametrization.excelSheetData("SwagLabs XLSX Worksheet", 0, 0);
	
	return name ;
	 }
   
	public static String readUsername2 () throws EncryptedDocumentException, IOException
   {
	 String name = parametrization.excelSheetData("SwagLabs XLSX Worksheet", 1,0 );
	 return name ;
   }
  
	public static String readUsername3 () throws EncryptedDocumentException, IOException
   {
	  String  name =parametrization.excelSheetData("SwagLabs XLSX Worksheet", 2,0 );
	  return name ;
   }
   
	public static String readUsername4 () throws EncryptedDocumentException, IOException
   {
	  String name = parametrization.excelSheetData("SwagLabs XLSX Worksheet", 3,0 );
	  return name ;
   }
  
	public static String password () throws EncryptedDocumentException, IOException
   {
	 String name = parametrization.excelSheetData("SwagLabs XLSX Worksheet", 0,1 );
	 return name ;
   }
}
