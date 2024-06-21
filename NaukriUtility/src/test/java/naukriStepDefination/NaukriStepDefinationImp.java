package naukriStepDefination;

import java.io.IOException;

import NaukriUtility.testComponents.BaseTest;
import Selenium.NaukriUtility.HomePage;
import Selenium.NaukriUtility.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NaukriStepDefinationImp extends BaseTest {

	public Selenium.NaukriUtility.LandingPage LandingPage;
	public Selenium.NaukriUtility.HomePage HomePage;
	public ProfilePage ProfilePage;

	@Given("I landed on Naukri login page")
	public void I_landed_on_Naukri_login_page() throws IOException {

		LandingPage = launchApplication();
		
			
		
	}

	

	@Given("^Logged in with (.+) and (.+) $")
	public void Logged_in_with_username_and_Password(String user, String pass) {
         
		HomePage HomePage = LandingPage.loginmethod(user, pass);
	}

	@When("I have navigate to profile page")
	public void I_have_navigate_to_profile_page() {
		ProfilePage ProfilePage = HomePage.clickOnViewProfile();
	}

	@And("^ I updated the (.+)$")
	public void I_Updated_the_Profile(String Summary) {

		ProfilePage.updateSummary(Summary);
	}

	@Then("Profile summary Updated")
	public void Profile_summary_Updated() {

		ProfilePage.Logout();
	}

}
