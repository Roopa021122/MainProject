package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;
public class TC_002_InvalidRegisterDataTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setup() {
		
		SheetName="InvalidRegisterData";
		testName="InvalidRegister test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Register test with Negative scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ValidRegisterTest(String userName, String pass, String conpass, String fullName, String email, String TestType,String ExpectedResult ) throws InterruptedException
	{
		HomePage obj=new HomePage(driver);
		          obj.ClickRegister()
		             .EnterUN(userName)
		             .EnterPass(pass)
		             .EnterConPass(conpass)
		             .EnterFName(fullName)
		             .EnterFName(fullName)
		             .EnterEmail(email)
		             .ClickCaptcha()
			          .ClickCheckBox()
			          .ClickRegBtn()
		             .InvalidRegidterData(TestType, ExpectedResult);
		             
		             

}
}
