package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="SignInData")
	public String[][] getData() throws IOException {
		
		String path=".//testData//Luma_SignInData.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcolumns = xlutil.getCellCount("Sheet1", 1);
		
		String signindata[][] = new String[totalrows][totalcolumns]; //Created for two dimension array which can
		
		for(int i=1;i<=totalrows;i++) { // read the data from xl storing in two dimensional array
			
			for(int j=0;j<totalcolumns;j++) {
				
				signindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
	return signindata; //returning two dimension array
		
		
	}

}
