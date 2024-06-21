package Selenium.NaukriUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.ReusableMethods;

public class ProfilePage extends ReusableMethods {

	WebDriver driver;

	public ProfilePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='widgetHead']//span[@class='edit icon'][normalize-space()='editOneTheme']")
	private WebElement pencilIcon;
	
	@FindBy(id="resumeHeadlineTxt")
	private WebElement summarySection;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='nI-gNb-drawer__bars']")
	private WebElement drawer;
	
	@FindBy(linkText="Logout")
	private WebElement Logout;
	
	public void updateSummary(String summary) {
		
		pencilIcon.click();
		summarySection.clear();
		summarySection.sendKeys(summary);
		save.click();
		
	}
	
	public void Logout() {
		drawer.click();
		waitForElementToAppear(Logout);
		Logout.click();
	}
	
}