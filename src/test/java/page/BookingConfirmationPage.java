package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;
public class BookingConfirmationPage extends ProjectSpecificationMethods {

	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	WebElement checkConf;
	
	@FindBy(xpath="//input[@id='search_hotel']")
	WebElement clickSearchConf;
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	WebElement clickItnerary;
	
	@FindBy(xpath="//input[@id='logout']")
	WebElement clickLogout;
	
	
	public BookingConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public BookingConfirmationPage CheckConfirmationText()
	{
		String ActualText=checkConf.getText();
		System.out.println(ActualText);
		String ExpectedText="Booking Confirmation";
		if(ActualText.equalsIgnoreCase(ExpectedText))
		{
			System.out.println("Booking successfully");
		}
		else
		{
			System.out.println("Booking unsuccessfull");
		}
		return this;
	}
	public HotelsPage  ClickSearchAfterConf()
	{
		clickSearchConf.click();
		return new HotelsPage(driver);
	}
    public HomePage ClickItneraryConf()
    {
    	clickItnerary.click();
    	return new HomePage(driver);
    }
    public HomePage ClickLogout()
    {
    	clickLogout.click();
    	return new HomePage(driver);
    }
}
