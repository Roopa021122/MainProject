package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class RegisterPage extends ProjectSpecificationMethods {

	//username
		@FindBy(xpath="//input[@id='username']")
		WebElement enterUN;
		
		//password
		@FindBy(xpath="//input[@id='password']")
		WebElement enterpass;
		
		//confirm password
		@FindBy(xpath="//input[@id='re_password']")
		WebElement enterConPass;
		
		//enterFullname
		@FindBy(xpath="//input[@id='full_name']")
		WebElement enterName;
		
		@FindBy(xpath="//input[@id='email_add']")
		WebElement enteremail;
		
		@FindBy(xpath="//input[@id='captcha-form']")
		WebElement clickCaptcha;
		
		//click  checkbox
		@FindBy(xpath="//input[@id='tnc_box']")
		WebElement clickCheckbox;
		
		//clcik register button
		@FindBy(xpath="//input[@id='Submit']")
		WebElement regBtn;
		
		@FindBy(xpath="input[@id='Reset']")
		WebElement clickReset;
		
		
		public RegisterPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public RegisterPage EnterUN(String name)
		{
			enterUN.sendKeys(name);
			return this;
		}
		public RegisterPage EnterPass(String pass)
		{
			enterpass.sendKeys(pass);
			return this;
		}
		public RegisterPage EnterConPass(String Cpass)
		{
			enterConPass.sendKeys(Cpass);
			return this;
		}
		public RegisterPage EnterFName(String FName)
		{
			enterName.sendKeys(FName);
			return this;
		}
		public RegisterPage EnterEmail(String email) 
		{
			enteremail.sendKeys(email);
			return this;
		}
		public RegisterPage ClickCaptcha() throws InterruptedException 
		{
			Thread.sleep(30000);
			clickCaptcha.click();		
			return this;
		}

		public RegisterPage ClickCheckBox() 
		{
			
			clickCheckbox.click();
			return this;
		}
		public RegisterVerification ClickRegBtn()
		{		regBtn.click();
			return new RegisterVerification(driver);
		}
		
		public RegisterPage ClickReset()
		{
			clickReset.click();
			return this;
		}
		
	}