package stepDefinations;

import org.junit.Assert;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.TestBase;


public class stepDefination extends TestBase
{
	TestBase tb = new TestBase();
	LoginPage lp = new LoginPage();
	
	
	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
	    tb.initialization();
	}

	@When("title of login page")
	public void title_of_login_page() throws InterruptedException {
	    
		String expected = prop.getProperty("title");
		String actual = lp.LoginPageTitle();
		Assert.assertEquals(actual,expected);
		Thread.sleep(1000);
	}


	@Then("user enters username and password")
	public void user_enters_username_and_password() {
	   
		lp = new LoginPage();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
	  
		lp.loginClick();
	}

	@Then("user verify the error message")
	public void user_verify_the_error_message() {
	    
		String expected = prop.getProperty("errormsg");
		String actual = lp.Errormsg();
		Assert.assertEquals(actual, expected);
	}

	@Then("user quit")
	public void user_quit() {
	 
		lp.closeBrowser();
	}

}
