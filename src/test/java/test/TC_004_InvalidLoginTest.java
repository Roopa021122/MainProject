package test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;

public class TC_004_InvalidLoginTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setup() {
		
		SheetName="InvalidLoginData";
		testName="ValidateLogin test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Login test with Negative scenarios ";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ValidateInvalidLogin(String Un, String pass, String Testtype, String Expectedresult)
	{
		HomePage obj = new HomePage(driver);
		
		         obj.EnterLUn(Un)
		             .EnterLPass(pass)
		             .ClickLoginInvalid()
		              .validateLoginDetails(Testtype, Expectedresult)
		             .validateForgotSubmissionForm(Testtype, Expectedresult);
	}
	
}
