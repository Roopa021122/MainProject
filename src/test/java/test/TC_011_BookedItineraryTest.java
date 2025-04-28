package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.BookedItineraryPage;
import page.HomePage;
public class TC_011_BookedItineraryTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setup() {
		
		SheetName="validLoginData";
		testName="BookedItinerary test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Register test with Negative scenarios";
		
	}
	
	@Test(dataProvider = "readData")
    
	public void BookedItineraryTest(String UN, String Pass) throws IOException, InterruptedException
	{
		HomePage obj=new HomePage(driver);
		
		          obj.EnterLUn(UN)
		              .EnterLPass(Pass)
		              .ClickLogin()
		              .ClickBookedItinerary()
		              .VerifyBookedtext()
		              .SelectAllOrderID()
		              .ClickFirstOrderID()
		              .ClickSecOrderID()
		              .CancelSelectAll();
		  BookedItineraryPage obj1=new   BookedItineraryPage(driver);
		              obj1.SearchOrderId()
		              .ClickGo()
		              .SelectedOrderDisplay()
		              .ClickShowAll()
		              .searchHotelBookedItin()
		              .ClickBookedItinerary()
		              .ClickLogoutBookedItiner()
		              .ClickHereLoginAftrLogout();
	}
}
