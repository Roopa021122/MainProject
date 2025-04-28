package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;


public class RegisterVerification  extends ProjectSpecificationMethods{

	//verification code
			@FindBy(xpath="//td[contains(text(),'An email verification ')]")
			WebElement verifyCode;
			
			@FindBy(xpath="//a[text()='Click here to login']")
			WebElement loginLink;
			
			@FindBy(xpath="//label[text()='Username is Empty']")
			WebElement EmptyUN;
			
			@FindBy(xpath="//label[text()='Password is Empty']")
			WebElement EmptyPass;
			
			@FindBy(xpath="//label[text()='Passwords Do Not Match']")
			WebElement InvalidCPas;
			
			@FindBy(xpath="//label[text()='Full Name is Empty']")
			WebElement EmptyName;
			
			@FindBy(xpath="//label[@id='email_add_span']")
			WebElement InvalidEmail;
			
			@FindBy(xpath="//input[@id='Reset']")
			WebElement clickReset;
			
			
		public RegisterVerification(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	 
		
	    public HomePage LoginLink()
	    {
	    	loginLink.click();
	    	return new HomePage(driver);
	    }
	    public RegisterPage InvalidRegidterData(String TestType, String ExpectedResult)
		{
			if(TestType.equalsIgnoreCase("UserNameIsEmpty")){
				
			    String actualText=EmptyUN.getText();
			     System.out.println(" print the Error msg when UserName is empty: " +actualText);
			     Assert.assertEquals(actualText, ExpectedResult);
			     clickReset.click();

			    
			}
			else if(TestType.equalsIgnoreCase("PasswordIsEmpty"))
			{
				
				String actualText=EmptyPass.getText();
				System.out.println(" print the Error msg when Password is empty: " +actualText);
				Assert.assertEquals(actualText, ExpectedResult);
			     clickReset.click();

				
			}else if(TestType.equalsIgnoreCase("InvalidConfirmPassword"))
			{
				
				String actualText=InvalidCPas.getText();
				System.out.println(" print the Error msg when InvalidConfirmPassword is given: " +actualText);
				Assert.assertEquals(actualText, ExpectedResult);
			     clickReset.click();

			
			}else if(TestType.equalsIgnoreCase("FullNameIsEmpty"))
			{
				
				String actualText=EmptyName.getText();
				System.out.println(" print the Error msg when name is empty: " +actualText);
				Assert.assertEquals(actualText, ExpectedResult);
				//reset the datas in register page
				clickReset.click();

			}else if(TestType.equalsIgnoreCase("InvalidEmailId"))
			{
				
				String actualText=InvalidEmail.getText();
				System.out.println(" print the Error msg when InvalidEmail is given: " +actualText);
				Assert.assertEquals(actualText, ExpectedResult);
				
			     clickReset.click();

			}
			return new RegisterPage(driver);
		}
	}

