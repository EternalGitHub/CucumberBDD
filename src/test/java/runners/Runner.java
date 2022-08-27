package runners;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "V:\\Selenium_Workspace\\CucumberPOM\\src\\test\\java\\features\\login.feature",
	glue = {"stepDefinations"},
	monochrome = true,
	plugin = {"pretty","html:target/login.html"},
	dryRun = false
//	strict = true

		)
public class Runner
{

}
