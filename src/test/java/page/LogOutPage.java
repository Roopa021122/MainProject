package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class LogOutPage extends ProjectSpecificationMethods {
	//check the logout text
			@FindBy(xpath="//td[@class='reg_success']")
			WebElement logoutText;
		//clickHere to login after logout
			@FindBy(xpath="//a[text()='Click here to login again']")
			WebElement clickhere;
	
		
		public LogOutPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public LogOutPage LogoutText()
		{
			
			String ExpectedText="You have successfully logged out. Click here to login again";
			String actualtext=logoutText.getText();
			
			if(actualtext.equalsIgnoreCase(ExpectedText))
			{
				System.out.println("Logout Successfully text: "+actualtext);
			}else
			{
				System.out.println("Logout unsuccessful");
			}
			return this;
		}
		public HomePage ClickHereLoginAftrLogout()
		{
			clickhere.click();
			return new HomePage(driver);
		}

	}

