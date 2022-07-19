package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class utilityClass 
{    
	

	public static String propertyAccess(int rownumber, int cellnumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".//Test_Data//grow_test_data.xlsx");
		return WorkbookFactory.create(fis).getSheet("Sheet1").getRow(rownumber).getCell(cellnumber).getStringCellValue();
			}
	

	
	public static String getproperty() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//Property//config.properties");
		prop.load(file);
		String url = prop.getProperty("URL");
		return url;
	}
	

}
