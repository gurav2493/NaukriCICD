package Selenium.NaukriUtility;

import java.io.IOException;

import org.testng.annotations.Test;

import NaukriUtility.testComponents.BaseTest;

public class NaukriProfileUpdate extends BaseTest{
	
	
	@Test(dataProvider="getData")

	public void profileUpdate(String user, String pass,String Summary) {
			
		HomePage HomePage=LandingPage.loginmethod(user, pass);
		ProfilePage ProfilePage = HomePage.clickOnViewProfile();
		ProfilePage.updateSummary(Summary);
		ProfilePage.Logout();

	}

}
