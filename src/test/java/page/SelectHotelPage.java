package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethods;


public class SelectHotelPage extends ProjectSpecificationMethods{

	//Welcome Menu
		@FindBy(xpath="//td[@class='welcome_menu'][1]")
		WebElement welMenu;
		
		//click Radio Btn
		@FindBy(xpath="//input[@id='radiobutton_0']")
		WebElement clickRadioBtn;
		//click continue
		@FindBy(xpath="//input[@id='continue']")
		WebElement clickContinue;
		 public SelectHotelPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
		 
		 public SelectHotelPage WelcomeMenu()
		 {
			String text= welMenu.getText(); 
			System.out.println(text);
			return this;
		 }
		public SelectHotelPage ClickRadioBtn()
		{
			clickRadioBtn.click();
			return this;
		}
		public BookHotelPage ClickContinue()
		{
			clickContinue.click();
			return new BookHotelPage(driver);
		}
	
}
