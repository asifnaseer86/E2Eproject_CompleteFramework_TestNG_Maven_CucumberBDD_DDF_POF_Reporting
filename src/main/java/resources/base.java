package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {

	public WebDriver driver;
	public String url;
	public WebDriver intitializeDriver() throws IOException 
	{
		String localDir = System.getProperty("user.dir");
		File file = new File(localDir + "\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(file);
		
		Properties prop = new Properties();
		prop.load(fis);
		//send parameters from maven command use system.getpropertiy() to run desired browser
		//mvn test -Dbrowser=chrome
		
		//String browserName = System.getProperty("browser"); // use this when getting browser details from maven command
		String browserName = prop.getProperty("browser"); // use this when getting browser details from file
		url = prop.getProperty("url");
		System.out.println(browserName);
		System.out.println(url);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", localDir + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("chrome-headless")) 
		{
			System.setProperty("webdriver.chrome.driver", localDir + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", localDir + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new  FirefoxDriver();
		}
		else if (browserName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", localDir + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new  InternetExplorerDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", localDir + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
