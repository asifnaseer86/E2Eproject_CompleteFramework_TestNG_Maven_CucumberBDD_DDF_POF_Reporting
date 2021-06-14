package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	public WebDriver driver;
	public LandingPageObjects(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//By signIn = By.cssSelector("a[href*='sign in']");
	
	@FindBy(css = "a[href*='sign_in']")
	private WebElement signIn;
	
	@FindBy(css = "div[class='text-center'] h2")
	private WebElement title;
	
	@FindBy(css = ".nav.navbar-nav.navbar-right")
	private WebElement navBar;
	
	@FindBy(css = "div[class*='video-banner']")
	private WebElement header;
	
	@FindBy(xpath = "//button[text()='NO THANKS']")
	private WebElement popup;
	
	@FindBy(xpath = "//button[text()='NO THANKS']")
	private List<WebElement> popups;
	
	public LoginPageObjects getLogin() 
	{
		signIn.click();
		return new LoginPageObjects(driver);
	}
	
	public WebElement getTitle() 
	{
		return title;
	}
	
	public WebElement getNavBar() 
	{
		return navBar;
	}
	
	public WebElement getHeader() 
	{
		return header;
	}
	
	public int getPoPupSize() 
	{
		return popups.size();
	}
	
	public WebElement getPoPup() 
	{
		return popup;
	}
}
