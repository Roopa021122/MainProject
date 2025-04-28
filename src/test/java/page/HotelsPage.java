package page;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.ProjectSpecificationMethods;

public class HotelsPage extends ProjectSpecificationMethods {

	@FindBy(xpath="//a[text()='Search Hotel']")
	WebElement clicksearch;
	//Location
	@FindBy(xpath="//select[@id='location']")
    private WebElement loc;
	//Invalid Location text
	@FindBy(xpath="//span[text()='Please Select a Location']")
	WebElement textError;
	//Hotels
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	//roomType
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	//no. of rooms
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement numfRooms;
	//Unselected room
	@FindBy(xpath="//span[@id='num_room_span']")
	WebElement roomtext;
	//check in date
	@FindBy(xpath="//input[@id='datepick_in']")
	WebElement checkIn;
	//check out date
	@FindBy(xpath="//input[@id='datepick_out']")
	WebElement checkOut;
	//Adults per room
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultsRoom;
	//unselected adults per room
	@FindBy(xpath="//span[text()='Please Select Adults per Room']")
	WebElement adultsRoomText;
	//child per room
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childRoom;
	//Search for room
	@FindBy(xpath="//input[@id='Submit']")
	WebElement search;
	//Verify login
	@FindBy(xpath="(//td[@class='welcome_menu'])[1]")
	WebElement verifyUser;
	//Verify reset
	@FindBy(xpath="//input[@id='Reset']")
	WebElement reset;
	//click change Password
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement changePass;
	//enter current password
	@FindBy(xpath="//input[@id='current_pass']")
	WebElement currentPas;
	//enter new Password
	@FindBy(xpath="//input[@id='new_password']")
	WebElement newPas;
	//enter confirm password
	@FindBy(xpath="//input[@id='re_password']")
	WebElement conPas;
	//click submit button
	@FindBy(xpath="//input[@id='Submit']")
	WebElement clickSub;
	//check the alert messsage
	@FindBy(xpath="//span[text()='Your Password is successfully updated!!!']")
	WebElement checkMsg;
	//logout
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	//check the logout text
	@FindBy(xpath="//td[@class='reg_success']")
	WebElement logoutText;
	//click Booked Itinerary
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	WebElement clickItinerary;
	//check the text of searchHotel
	@FindBy(xpath="//td[text()='Search Hotel ']")
	WebElement text;
	
	
	public HotelsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public HotelsPage verifyLogin() {
		String text=verifyUser.getText();
		System.out.println("Welcome user text: "+text);
		return this;
	}
	public HotelsPage ClickSearchHotels()
	{
		clicksearch.click();
		return this;
		
	}
	public HotelsPage SelectLocation()
	{   
		Select drplocation=new Select(loc);
		drplocation.selectByValue("London");
		return this;
	}
	public HotelsPage SelectHotels()
	{
		Select drpHotels=new Select(hotels);
		drpHotels.selectByValue("Hotel Sunshine");
		return this;
	}
	public HotelsPage SelectRoomType()
	{
		Select drproomtype=new Select(roomType);
		drproomtype.selectByValue("Double");
		return this;
	}
	public HotelsPage SelectNumOfRooms()
	{
		Select drprooms=new Select(numfRooms);
		drprooms.selectByValue("2");
		return this;
	}
	public HotelsPage CheckIn(String InDate)
	{
		checkIn.sendKeys(InDate);
		return this;
	}
	public HotelsPage CheckOut(String OutDate)
	{
		checkOut.sendKeys(OutDate);
		return this;
	}
	public HotelsPage AdultsPerRoom()
	{
		Select drpAdultRoom=new Select(adultsRoom);
		drpAdultRoom.selectByValue("2");
		return this;
	}
	public HotelsPage ChildPerRoom()
	{
		Select drpChildRoom=new Select(childRoom);
		drpChildRoom.selectByValue("2");
		return this;
	}
	public SelectHotelPage ClickSearch()
	{
		search.click();
		return new SelectHotelPage(driver);
	}
	
	
		public HotelsPage InSelectLocation()
		{   
			Select drplocation=new Select(loc);
			drplocation.selectByVisibleText("- Select Location -");
			return this;
		}
		public HotelsPage LocationErrorText()
		{
			String text=textError.getText();
			System.out.println("Print the message of unselected Location: "+text);
		    		
		    return this;
		}
		public HotelsPage InSelectNumOfRooms()
		{
			Select drprooms=new Select(numfRooms);
			drprooms.selectByVisibleText("- Select Number of Rooms -");
			return this;
		}	
		public HotelsPage NumOfRoomsErrorText()
		{
			String text=roomtext.getText();
			System.out.println("Print the message of unselected NumOfRooms: "+text);
			return this;
		}
		public HotelsPage InCheckIn(String InDate)
		{
			checkIn.sendKeys(InDate);
			return this;
		}
		public HotelsPage InCheckOut(String OutDate)
		{
			checkOut.sendKeys(OutDate);
			return this;
		}
		public HotelsPage InAdultsPerRoom()
		{
			Select drpAdultRoom=new Select(adultsRoom);
			drpAdultRoom.selectByVisibleText("- Select Adults per Room -");
			return this;
		}
	    public HotelsPage InvalidHotelSearch()
	    {
	    	search.click();
	    	return this;
	    }
		public HotelsPage AdultsRoomErrorText()
		{
			String text=adultsRoomText.getText();
			System.out.println("Error message of unselected adultPerRoom: "+text);
			return this;
		}
		public void CheckReset()
		{
			reset.click();
			System.out.println("User are able to reset the given datas");
		}
		public HotelsPage ChangePassword()
		{
			changePass.click();
			return this;
		}
		public HotelsPage EnterCurPassCh(String curPas)
		{
			currentPas.sendKeys(curPas);
			return this;
		}
		public HotelsPage EnterNewPassCh(String newPass)
		{
			newPas.sendKeys(newPass);
			return this;
		}
		public HotelsPage EnterConPassCh(String conPass)
		{
			conPas.sendKeys(conPass);
			return this;
		}
		public HotelsPage clickSubmitChangePass()
		{
			clickSub.click();
			return this; 
		}
		public HotelsPage PassChangedSuccesTxt()
		{
			String text=checkMsg.getText();
			System.out.println("Confirmation text: "+text);
		 return this;
		}
		public LogOutPage LogOut()
		{
			logout.click();
			return new LogOutPage(driver);
		}
		public BookedItineraryPage ClickBookedItinerary()
		{
			clickItinerary.click();
			return new BookedItineraryPage(driver);
		}
		public HotelsPage CheckTextSearchHotel()
		{
			
			String ActualText = text.getText();
			System.out.println("ActualText");
			return this;
		}
		public HomePage HotelBookd(String TestType)
		{
			if(TestType.equalsIgnoreCase("FirstBooking"))
			{
				System.out.println();
			}
			else if(TestType.equalsIgnoreCase("SeconBooking"))
			{
				System.out.println();
			}else if(TestType.equalsIgnoreCase("ThirdBooking"))
			{
				System.out.println();
			}else if(TestType.equalsIgnoreCase("FourthBooking"))
			{
				System.out.println();
			}
			return new HomePage(driver);
		}
		
	
}
