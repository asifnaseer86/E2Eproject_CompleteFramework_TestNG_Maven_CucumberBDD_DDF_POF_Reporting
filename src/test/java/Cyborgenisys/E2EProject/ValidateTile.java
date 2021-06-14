package Cyborgenisys.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import resources.base;

public class ValidateTile extends base{

	LandingPageObjects LP;
	public static Logger log = LogManager.getLogger(ValidateTile.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initializer() throws IOException 
	{
		driver = intitializeDriver();
		log.info("Driver successfully initialized");
		driver.get(url);
		log.info("Navigated to home page");
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		log.info("Driver successfully removed");
	}
	
	@Test
	public void homePageTile() throws IOException 
	{

		
		
		
		String title = LP.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES1","Title not same");
		log.info("Successfully validated text message");
	}
	
	@Test	
	public void basePageNavigation() throws IOException 
	{
		LP = new LandingPageObjects(driver);
		boolean navBar = LP.getNavBar().isDisplayed();
		Assert.assertTrue(navBar,"Navigation bar is not present");
		log.info("Successfully validated Navigation Bar available");

	}
	
	@Test	
	public void validateHeader() throws IOException 
	{

		String headerText = LP.getHeader().getText();
		Assert.assertEquals(headerText,"An Academy to learn Everything about Testing");
		log.info("Successfully validated Header Text available");

	}
	

}
