package Cyborgenisys.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordObjects;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initializer() throws IOException 
	{
		driver = intitializeDriver();
		log.info("Driver successfully initialized");
		
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		log.info("Driver successfully removed");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException 
	{
		
		driver.get(url);
		log.info("Navigated to home page");
		
		LandingPageObjects LP = new LandingPageObjects(driver);
		//LP.getLogin().click(); //second test fails becaus unable to find login css which was drived from home page		
		
		if(LP.getPoPupSize()>0) 
		{
			LP.getPoPup().click();
		}
		
		LoginPageObjects LPO = LP.getLogin();
		log.info("Clicked on login button to navigate to login page");
		LPO.getEmail().sendKeys(username);
		log.info("Entered email in login page email input field");
		
		LPO.getPassword().sendKeys(password);
		log.info("Entered password in login page password input field");
		
		log.info(text);
		LPO.Submit().click();
		log.info("Clicked on login button to validate username & password");
		
		ForgotPasswordObjects fpo = LPO.ForgotPassword();
		log.info("Clicked on forget password button to navigate to forget password page");
		
		fpo.getEmail().sendKeys("test");
		log.info("Entered email in forget password page email input field");
		fpo.Submit().click();
		log.info("Clicked on submit button to receive password through email");
	}
	
//	@Test
//	public void validateForgetPassword() 
//	{
//		
//	}
	
	@DataProvider
	public Object[][] getData() 
	{
		// TODO Auto-generated method stub
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0]= "restriceduser@test.com";
		data[0][1]= "1234567890";
		data[0][2]= "restriced user";
		//1st row
		data[1][0]= "restriceduser@test.com";
		data[1][1]= "12345678";
		data[1][2]= "non restriced user";
		
		return data;

	}
}
