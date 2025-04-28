package base;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificationMethods extends UtilityClass {

	 @BeforeSuite
		public void reportIniatialization() {
			
			// To create report in the given location
			ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\roopa\\eclipse-workspace\\AdactinHotel\\src\\test\\resources\\report\\HotelBookingreport.html");
			reporter.config().setReportName("HotelBookingReport");
			
			// to capture the test data
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			
		}
		
		@BeforeClass
		public void testDetails() {
			
			test = extent.createTest(testName,testDescription);
			test.assignCategory(testCategory);
			test.assignAuthor(testAuthor);

		}
		
	
@BeforeMethod
 public void LauchingAndLoadingURL() {
	
	 LaunchBrowser("chrome","https://adactinhotelapp.com/index.php");
 }

    @AfterMethod
  public void browserClose() {
	  
	  CloseBrowser();
    }
	  
	 @DataProvider
		public String[][] readData() throws Exception {
			String[][] data=readExcelData(SheetName);
			return data;
		}
		
	  @AfterSuite
		public void closeReport() {
			extent.flush();
		
		
  }
}

