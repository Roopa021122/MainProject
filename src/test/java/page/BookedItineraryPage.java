package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import base.ProjectSpecificationMethods;
import page.HomePage;
public class BookedItineraryPage extends ProjectSpecificationMethods {

	//verifyBookedPage
		@FindBy(xpath="//td[text()='Booked Itinerary']")
		WebElement pageVerify;
		//click select all order
		@FindBy(xpath="//input[@id='check_all']")
		WebElement selAllOrder;
		//check the select all
		@FindBy(xpath="//form[@id='booked_form']")
		WebElement checktable;
		//click the order
		@FindBy(xpath="(//input[@name='ids[]'])[1]")
		WebElement clickFirOrd;
		//click the second orderId
		@FindBy(xpath="(//input[@name='ids[]'])[2]")
		WebElement clickSecOrder;
		//cancel selectall
		@FindBy(xpath="//input[@name='cancelall']")
		WebElement cancelsel;
		//search hotel
		@FindBy(xpath="//input[@id='search_hotel']")
		WebElement search;
		
		//select the order idtext
		@FindBy(xpath="(//input[contains(@id,'order_id')][2]")
		WebElement ordertext;
		//select the orderid
		@FindBy(xpath="//input[@id='order_id_text']")
		WebElement selOrder;
		//Click go
		@FindBy(xpath="//input[@id='search_hotel_id']")
		WebElement clickGo;
		//check the selected order
		@FindBy(xpath="(//input[@class='select_text'])[1]")
		WebElement checkSelOrder;
		//click show all
		@FindBy(xpath="//a[text()='Show all']")
		WebElement showall;
		//click logout
		@FindBy(xpath="//input[@id='logout']")
		WebElement clickLogout;
		public BookedItineraryPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public BookedItineraryPage VerifyBookedtext()
		{
			String actualText= pageVerify.getText();
			System.out.println(actualText);
			return this;
			
		}
		public BookedItineraryPage SelectAllOrderID() throws IOException, InterruptedException
		{
			selAllOrder.click();
			WebElement section=driver.findElement(By.xpath("//form[@id='booked_form']"));
			File src=section.getScreenshotAs(OutputType.FILE);
			File trg=new File(".\\Screenshot\\SelectAllORderId.png");
			FileUtils.copyFile(src, trg);
			Thread.sleep(5000);
			selAllOrder.click();
			return this;
			
		}
		public BookedItineraryPage ClickFirstOrderID()
		{
			clickFirOrd.click();
			return this;
		}
		public BookedItineraryPage ClickSecOrderID()
		{
			clickSecOrder.click();
			return this;
			
		}
		public BookedItineraryPage CancelSelectAll()
		{
			cancelsel.click();
			Alert al=driver.switchTo().alert();
			String altext=al.getText();
			System.out.println("Print the alert text: " +altext);
			
			al.accept();
			return this;
		}
		public BookedItineraryPage SearchOrderId() throws InterruptedException
		{   
		    try {
			@SuppressWarnings("deprecation")
			String OrderID=ordertext.getAttribute("value");
			System.out.println(OrderID);
			selOrder.sendKeys(OrderID);
		    }
		    catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
			
			return this;
			
		}
		public BookedItineraryPage ClickGo() throws InterruptedException
		{
			Thread.sleep(5000);
			clickGo.click();
			return this;
		}
		public BookedItineraryPage SelectedOrderDisplay()
		{
			@SuppressWarnings("deprecation")
			String OrderID=ordertext.getAttribute("value");
			@SuppressWarnings("deprecation")
			String SelectedOrderId=checkSelOrder.getAttribute("value");
			Assert.assertEquals(OrderID, SelectedOrderId);
			System.out.println("selected hotel are displayed");
			return this;

		}
		public BookedItineraryPage ClickShowAll()
		{
			showall.click();
			return this;
		}
		public HotelsPage searchHotelBookedItin()
		{
			search.click();
			return new HotelsPage(driver);
		}
		
		public LogOutPage ClickLogoutBookedItiner()
		{
		
			clickLogout.click();
			return new LogOutPage(driver);
		}
}
