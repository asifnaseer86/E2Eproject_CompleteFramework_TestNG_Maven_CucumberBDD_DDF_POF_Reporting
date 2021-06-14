package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordObjects {

	public WebDriver driver;
	public ForgotPasswordObjects(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//email field path
	@FindBy(css = "#user_email")
	private WebElement email;
	

		
	//send me instruction button path
	@FindBy(xpath = "//input[@name='commit']")
	private WebElement submit;
	
	
	
	
	public WebElement getEmail() 
	{
		return email;
	}
	
	
	
	public WebElement Submit() 
	{
		return submit;
	}
	
	
}
