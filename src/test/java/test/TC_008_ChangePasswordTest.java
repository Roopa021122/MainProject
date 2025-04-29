package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.HomePage;

public class TC_008_ChangePasswordTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setup() {
		
		SheetName="ChangePassword";
		testName="Change Password test";
		testAuthor="Roopa";
		testCategory="Smoketest";
		testDescription="Change password test with positive scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ChangePassword(String Un,String Pass, String OldPas, String NewPass, String ConPass)
	{
		HomePage obj=new HomePage(driver);
		          obj.EnterLUn(Un)
		             .EnterLPass(Pass)
		             .ClickLogin()
		             .ChangePassword()
		             .EnterCurPassCh(OldPas)
		             .EnterNewPassCh(NewPass)
		             .EnterConPassCh(ConPass)
		             .clickSubmitChangePass()
		             .PassChangedSuccesTxt()
		             .LogOut()
		             .LogoutText()
		             .ClickHereLoginAftrLogout();
	}

}
