package dataprovider;

import org.testng.annotations.DataProvider;

import readdata.ExcelRead;

public class filling_data {

	

	@DataProvider(name = "excel-inputs")
	public static Object[][] getExcelData(){
		String fileName ="C:\\Users\\AP\\Desktop\\Book1.xlsx"; 
		return new ExcelRead().getExcelContent(fileName); 
	}
	
	
	
	
	
	
}
