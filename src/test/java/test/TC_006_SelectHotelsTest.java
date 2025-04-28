package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;
public class TC_006_SelectHotelsTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setup() 
	{
		
		SheetName="BookHotelData";
		testName="Booking Hotel test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Book Hotel with credentials details with Positive scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	public  void BookingHotelsTest(String Un, String Pass, String CheckIn, String CheckOut,String FName,String lNam,String addr,String CardNo,String ccv,String TestType) throws InterruptedException
	{
		HomePage obj=new HomePage(driver);
		     
		        
		         obj  .EnterLUn(Un)
		              .EnterLPass(Pass)
		              .ClickLogin()
		              .SelectLocation()
			          .SelectHotels()
			          .SelectRoomType()
			          .SelectNumOfRooms()
		              .CheckIn(CheckIn)
		              .CheckOut(CheckOut)
		              .AdultsPerRoom()
			          .ChildPerRoom()
			          .ClickSearch()
			          .WelcomeMenu()
			          .ClickRadioBtn()
			          .ClickContinue()
			          .EnterFirstNameHot(FName)
			          .EnterLastNameHot(lNam)
			          .EnterAddressHot(addr)
			          .EnterCardNum(CardNo)
			          .CardType()
			          .ExpiryMonth()
			          .ExpiryYear()
			          .EnterCVV(ccv)
			          .ClickBookNow()
			          .CheckConfirmationText()
			          .ClickSearchAfterConf()
			          .HotelBookd(TestType);
		
	}
}
