package utils;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {

	public static WebDriver driver;
	public String SheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
   
	
	public void LaunchBrowser(String browser, String url) {

    	if(browser.equalsIgnoreCase("chrome")) {
             driver= new ChromeDriver();
        } else if(browser.equalsIgnoreCase("edge")) {
	         driver= new EdgeDriver();
        } else {
	         driver= new ChromeDriver();
        }
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
driver.get(url);
}
    public void CloseBrowser() {
    	driver.close();
    }
    
    public static String[][] readExcelData(String sheetName) throws IOException
	{
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\roopa\\eclipse-workspace\\AdactinHotel\\src\\test\\resources\\Excel\\MainProjectData.xlsx");
		XSSFSheet sheet = book.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][columnCount];
		for(int i=1; i<=rowCount;i++)
		{
         XSSFRow row = sheet.getRow(i);
			
			for(int j = 0; j < columnCount; j++) 
			{
				XSSFCell cell = row.getCell(j);
				if (cell == null) {
                    data[i - 1][j] = ""; // Handle empty cells
                } else {
                    cell.setCellType(CellType.STRING); 
                    data[i - 1][j] = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
	        }
		}}
		book.close();
		return data;
    }
	
    public static String screenshot(String name) throws IOException {
		
		String path="C:\\Users\\roopa\\eclipse-workspace\\AdactinHotel\\src\\test\\resources\\snap\\"+name+".png";
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}