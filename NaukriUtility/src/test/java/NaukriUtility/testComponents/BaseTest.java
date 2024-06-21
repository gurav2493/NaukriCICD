package NaukriUtility.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Selenium.NaukriUtility.LandingPage;


public class BaseTest{
	
	public WebDriver driver;
	public LandingPage LandingPage;

	public WebDriver initializeBrowser() throws IOException {
	
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
				
		if(browserName.equalsIgnoreCase("chrome"))	
		{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.rajpurohit_in\\Desktop\\chromedriver.exe");
		

		driver = new ChromeDriver();
		
		
	}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();

					}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		return driver;
}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeBrowser();
		LandingPage=new LandingPage(driver);
		LandingPage.goTo();
		return LandingPage;
		
	}
	
 public File getScreenshot(String testcasename, WebDriver driver) throws IOException{
	 
	 TakesScreenshot screenShot= (TakesScreenshot)driver;
	 File source= screenShot.getScreenshotAs(OutputType.FILE);
	 File DestFile=new File(System.getProperty("user.dir"+ "//reports"+ testcasename +".png"));
	 FileHandler.copy(source, DestFile);
	 return DestFile;
 }
	
    @AfterMethod (alwaysRun=true)

public void closeBrowser() {
	
	driver.close();
}
    
    
    
   @DataProvider()
	   
	   public String[][] getData() {
		   
		   return new String[][] {{"gouravrajpurohit@gmail.com","Jan!2019","Overall having 9 year of experience in automation and manual Testing and currently working as Module Lead – QA in Infobeans Technology Private Limited"},{"saxena.hs1@gmail.com","Polaris123!","QA" }};
	   }
   }


