package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	public WebDriver driver;
	public LoginPageObjects(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//email path
	@FindBy(css = "#user_email")
	private WebElement email;
	
	//password path
	@FindBy(css = "#user_password")
	private WebElement password;
		
	//submit path
	@FindBy(css = "input[value='Log In']")
	private WebElement submit;
	
	//forget password path
	@FindBy(css = ".link-below-button")
	private WebElement forgetPassword;
	
	
	public WebElement getEmail() 
	{
		return email;
	}
	
	public WebElement getPassword() 
	{
		return password;
	}
	
	public WebElement Submit() 
	{
		return submit;
	}
	
	public ForgotPasswordObjects ForgotPassword() 
	{
		forgetPassword.click();
		return new ForgotPasswordObjects(driver);
		
	}
}
