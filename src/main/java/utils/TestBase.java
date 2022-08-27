package utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebDriverEventListener eventListner;

	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fi = new FileInputStream("V:\\Selenium_Workspace\\CucumberPOM\\src\\main\\java\\config\\config.properties");
			prop.load(fi);
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "V:/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "V:/SeleniumJars/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
