package page;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	
	       //clcik register
			@FindBy(xpath="//a[text()='New User Register Here']")
			WebElement clickRegister;
			
			//enter username
			@FindBy(xpath="//input[@id='username']")
			WebElement enterUn;
			
			//enter password
			@FindBy(xpath="//input[@id='password']")
			WebElement pass;
			
			//click loginbtn
			@FindBy(xpath="//input[@id='login']")
			WebElement clickLogin;
			
			//UserName is empty
		    @FindBy(xpath="//span[@id='username_span']")
			WebElement unEmpty;
		    
			//passwod is empty
			@FindBy(xpath="//span[text()='Enter Password']")
			WebElement passEmpty;
			
	    //check logo
		@FindBy(xpath="//img[@class='logo']")
		WebElement checkLogo;
		
		//Querry text check
		@FindBy(xpath="//td[text()='For any queries/issues please email: ']")
		WebElement checkQuerry;
		
		//Querry email check
		@FindBy(xpath="//a[text()='info@adactin.com']")
		WebElement checkEmail;
		
		
		
		//click forgot password
		@FindBy(xpath="//a[text()='Forgot Password?']")
		WebElement clickForgotPass;
		
		//inspect Forgot password form title
		@FindBy(xpath="//td[text()='Forgot Password Form ']")
		WebElement inspectTitle;
		
		//click here
		@FindBy(xpath="//a[text()='Click here']")
		WebElement clickHere;
		
		//go back to login page
		@FindBy(xpath="//a[text()='Go back to Login page']")
		WebElement GoBackLogin;
		
		//enter email in password form
		@FindBy(xpath="//input[@id='emailadd_recovery']")
		WebElement enteremail;
		
		//click Email Password btn
		@FindBy(xpath="//input[@id='Submit']")
		WebElement clickEmailPas;
		
		@FindBy(xpath="//a[text()='Click here to login']")
		WebElement clickLoginHere;
		
	
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	    
		public RegisterPage ClickRegister()
		{
			clickRegister.click();
			return new RegisterPage(driver);
		}
		public HomePage EnterLUn(String UN)
		{
			enterUn.sendKeys(UN);
			return this;
		}
		public HomePage EnterLPass(String password)
		{
			pass.sendKeys(password);
			return this;
		}
		public HotelsPage ClickLogin() 
		{
			clickLogin.click();
			return new HotelsPage(driver);
		}
		public HomePage ClickLoginInvalid() {
			clickLogin.click();
			return this;
		}
		public HomePage validateLoginDetails(String TestType,String ExpectedResult)
		{
	       if(TestType.equalsIgnoreCase("UsrNameIsEmpty")){
				String actualText=unEmpty.getText();
				System.out.println("UserName is Empty text:" +actualText);
				
			}else if(TestType.equalsIgnoreCase("PasswordIsEmpty"))
			{			
				String actualText=passEmpty.getText();
				
			    System.out.println("Password is empty text: "+actualText);
				
			}
	       return this;
		}
		
		public HomePage validateForgotSubmissionForm(String TestType, String ExpectedRsult)
		{
			if(TestType.equalsIgnoreCase("ClickForgotPassword")){
				clickForgotPass.click();
				String actualtext=inspectTitle.getText();
				
			    System.out.println("click forgot password user are able to navigate to: "+actualtext);
			}
			else if(TestType.equalsIgnoreCase("enterInvalidUserdata")){
				clickHere.click();
				String actualtext=inspectTitle.getText();
				 System.out.println("check user are able to navigate the forgot password form: "+actualtext);
		}
			//GoBackLogin.click();
			return this;
			
	    }
		//Take Screenshot the logo present in home page
			public HomePage LogoScreenshot() throws IOException
			{
				WebElement ele=checkLogo;
				File src=ele.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src, new File("C:\\Users\\roopa\\eclipse-workspace\\AdactinHotel\\src\\test\\resources\\LogoScreenshot\\ele.png"));
				System.out.println("Logo is visible in home page");
				return this;
			}
			public HomePage CheckQueryEmail()
			{
				String actText=checkQuerry.getText();
				System.out.println("Query text is available in login page as: "+actText);
				
				return this;
			}
			public HomePage checkEmailClickable()
			{
			    checkEmail.click();
				System.out.println("Query Email button are able to click");
				return this;
			}
				
	}
