package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecificationMethods;
public class BookHotelPage extends ProjectSpecificationMethods {

	//enter firstname
    @FindBy(xpath="//input[@id='first_name']")
    WebElement entername;
    //enter LastName
    @FindBy(xpath="//input[@id='last_name']")
    WebElement enterLname;
    //enter address
    @FindBy(xpath="//textarea[@id='address']")
    WebElement enteraddress;
    @FindBy(xpath="//input[@id='cc_num']")
    WebElement enteCardNum;
    @FindBy(xpath="//select[@id='cc_type']")
    private WebElement cardType;
    @FindBy(xpath="//select[@id='cc_exp_month']")
    private WebElement ExpMonth;
    @FindBy(xpath="//select[@id='cc_exp_year']")
    private WebElement ExpYear;
    @FindBy(xpath="//input[@id='cc_cvv']")
    WebElement enterCVV;
    @FindBy(xpath="//input[@id='book_now']")
    WebElement clickBookNow;
    //FirstNameEmpty text
    @FindBy(xpath="//label[@id='first_name_span']")
    WebElement FnameTxt;
    //LastName is empty
    @FindBy(xpath="//label[@id='last_name_span']")
    WebElement LnameTxt;
    //address is empty
    @FindBy(xpath="//label[@id='address_span']")
    WebElement addIsEmpty;
    //Invalid card no.
    @FindBy(xpath="//label[@id='cc_num_span']")
    WebElement uncardNo;
    //unselect card type
    @FindBy(xpath="//label[@id='cc_type_span']")
    WebElement uncardtyp;
    //unselect Expiry month
    @FindBy(xpath="//label[@id='cc_expiry_span']")
    WebElement unExpMnth;
    //unselect Expiry year
    @FindBy(xpath="//label[@id='cc_expiry_span']")
    WebElement unExpyear;
    //unselect Cvv
    @FindBy(xpath="//label[@id='cc_cvv_span']")
    WebElement unSelCVV;
    //Click cancel in book a hotel
    @FindBy(xpath="//input[@id='cancel']")
    WebElement cancel;
	public BookHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public BookHotelPage EnterFirstNameHot(String FName) throws InterruptedException
	{
		Thread.sleep(5000);
		entername.sendKeys(FName);
		return this;
	}
	public BookHotelPage EnterLastNameHot(String LName)
	{
		enterLname.sendKeys(LName);
		return this;
	}
	public BookHotelPage EnterAddressHot(String address)
	{
		enteraddress.sendKeys(address);
		return this;
	}
	public BookHotelPage EnterCardNum(String cardNum)
	{
		enteCardNum.sendKeys(cardNum);
		return this;
	}
	public BookHotelPage CardType()
	{
		Select drpCardType= new Select(cardType);
		drpCardType.selectByValue("VISA");
		return this;
	}
	public BookHotelPage ExpiryMonth()
	{
		Select drpExpiryMonth= new Select(ExpMonth);
		drpExpiryMonth.selectByValue("3");
		return this;
	}
	public BookHotelPage ExpiryYear()
	{
		Select drpExpiryYear= new Select(ExpYear);
		drpExpiryYear.selectByValue("2026");
		return this;
	}
	public BookHotelPage EnterCVV(String CVV)
	{
		enterCVV.sendKeys(CVV);
		return this;
	}
	public BookingConfirmationPage ClickBookNow()
	{
		clickBookNow.click();
		return new BookingConfirmationPage(driver);
	}
	public BookHotelPage UnselectCardType()
	{
		Select drpCardType= new Select(cardType);
		drpCardType.selectByVisibleText("- Select Credit Card Type -");
		return this;
	}
	public BookHotelPage UnselectExpiryMonth()
	{
		Select drpExpiryMonth= new Select(ExpMonth);
		drpExpiryMonth.selectByVisibleText("- Select Month -");
		return this;	
	}
	public BookHotelPage UnselectExpiryYear()
	{
		Select drpExpiryYear= new Select(ExpYear);
		drpExpiryYear.selectByVisibleText("- Select Year -");
		return this;
	}
	public BookHotelPage InClickBookNow()
	{
		clickBookNow.click();
		return this;
	}
	public BookHotelPage ValidateBookAHotelPAge(String TestType, String ExpectedResult)
	{
		if(TestType.equalsIgnoreCase("FirstNameISEmpty"))
		{
			String actualTxt=FnameTxt.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
			System.out.println(actualTxt);
		}else if(TestType.equalsIgnoreCase("LastNameISEmpty"))
		{
			String actualTxt=LnameTxt.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
			System.out.println(actualTxt);
		}else if(TestType.equalsIgnoreCase("AddressIsEmpty"))
		{
			String actualTxt=addIsEmpty.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
			System.out.println(actualTxt);
		}else if(TestType.equalsIgnoreCase("CArdNo.IsEmpty"))
		{			
			String actualTxt=uncardNo.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
			System.out.println(actualTxt);
		}else if(TestType.equalsIgnoreCase("UnselectedCreditCardType"))
		{
			String actualTxt=uncardtyp.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
		    System.out.println(actualTxt);
		}
		else if(TestType.equalsIgnoreCase("UnselectdExpiryMonth"))
		{
			String actualTxt=unExpMnth.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
		    System.out.println(actualTxt);
		}else if(TestType.equalsIgnoreCase("CVVNo.ISEmpty"))
		{
			String actualTxt=unSelCVV.getText();
			Assert.assertEquals(actualTxt, ExpectedResult);
		    System.out.println(actualTxt);
		}
		return this;
	}
	public SelectHotelPage ClickCancelBookHotel()
	{
		cancel.click();
		return new SelectHotelPage(driver);
	}
}
