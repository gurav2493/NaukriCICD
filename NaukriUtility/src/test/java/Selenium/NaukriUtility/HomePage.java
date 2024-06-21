package Selenium.NaukriUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.ReusableMethods;

public class HomePage extends ReusableMethods {
	
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div[class='view-profile-wrapper']")
	WebElement viewProfile;
	
	public ProfilePage clickOnViewProfile() {
		
		waitForElementToAppear(viewProfile);
		viewProfile.click();
		ProfilePage ProfilePage=new ProfilePage(driver);
		return ProfilePage;
	}
}
