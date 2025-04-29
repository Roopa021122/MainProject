package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;
public class TC_009_HomeContentDetailsTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void setup() {
		
		testName="HomeContent test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Home Content test with positive scenarios";
		
	}
	
	@Test
	public void HomeContentTest() throws IOException
	{
		HomePage obj=new HomePage(driver);
		          obj.LogoScreenshot()
		             .CheckQueryEmail()
		             .checkEmailClickable();
	}
	
	

}
