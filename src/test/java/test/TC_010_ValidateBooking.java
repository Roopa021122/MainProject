package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;

public class TC_010_ValidateBooking extends ProjectSpecificationMethods{

	@BeforeTest
	public void setup() {
		
		SheetName="BookHotelInvalidData";
		testName="BookHotel with invalid data test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Book a Hotel test with negative scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	public  void BookingHotelsTest(String Un, String Pass, String CheckIn, String CheckOut,String FName,
			                       String lNam,String addr,String CardNo, String ccv, String TestType, String ExpectedResult) throws InterruptedException
	{
	HomePage obj= new HomePage(driver);
	       obj.EnterLUn(Un)
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
	          .ClickRadioBtn()
	          .ClickContinue()
	          .EnterFirstNameHot(FName)
	          .EnterLastNameHot(lNam)
	          .EnterAddressHot(addr)
	          .EnterCardNum(CardNo)
	          .UnselectCardType()
	          .UnselectExpiryMonth()
	           .EnterCVV(ccv)
	          .InClickBookNow()
	          .ValidateBookAHotelPAge(TestType, ExpectedResult)
	          .ClickCancelBookHotel();
	}
	
	
}
