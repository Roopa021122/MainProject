package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;

public class TC_001_RegisterPage extends ProjectSpecificationMethods{

	

	@BeforeTest
	public void setup() {
		
		SheetName="RegisterData";
		testName="Register details test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Register test with positive scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	public void ValidRegisterTest(String userName, String pass, String conpass, String fullName, String email ) throws InterruptedException
	{
		HomePage obj=new HomePage(driver);
		          obj.ClickRegister()
		          .EnterUN(userName)
		          .EnterPass(pass)
		          .EnterConPass(conpass)
		          .EnterFName(fullName)
		          .EnterEmail(email)
		          .ClickCaptcha()
		          .ClickCheckBox()
		          .ClickRegBtn()
		          .LoginLink();
		          
	} 
}
