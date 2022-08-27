package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestBase;

public class LoginPage extends TestBase
{

	//Page Factory
	@FindBy(name ="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement Login;
	
	@FindBy(className = "_9ay7")
	WebElement error;
	
	//Initializing the Page Objects.
	public LoginPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	public String LoginPageTitle()
	{
		String actual = driver.getTitle();
		return actual;
		
	}
	
	public void login(String uname, String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		
		
	}
	public void loginClick()
	{
		Login.click();
	}
		
	public String Errormsg()
	{
		String actual = error.getText();
//		String actual = driver.findElement(By.className("_9ay7")).getText();
		System.out.println(actual);
		return actual;

	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
