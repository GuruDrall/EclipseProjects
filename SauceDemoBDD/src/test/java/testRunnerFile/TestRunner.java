package testRunnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "Features", 
		glue = "stepDefinations",
		monochrome = true ,
		dryRun = false  ,
		plugin = {"pretty","html:target/cucumber.html"}
		)
public class TestRunner {

}
