package Selenium.NaukriUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.ReusableMethods;

public class LandingPage extends ReusableMethods {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#login_Layer")
	WebElement firstLogin;
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement password;

	@FindBy(className="loginButton")
	WebElement loginButton;
	
	
	public void  goTo()
	{
		driver.get("https://www.naukri.com/");
	}
	
	public HomePage loginmethod(String user,String pass)
	{
		firstLogin.click();
		waitForElementToAppear(username);
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		HomePage HomePage = new HomePage(driver);
		return HomePage;
		
	}
	
	
}
