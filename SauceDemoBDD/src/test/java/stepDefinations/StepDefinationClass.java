package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationClass extends BaseClass {
	
	
	@Given("open browser {string}")
	public void open_browser(String browserName) {
	    launchBrowser(browserName);
	}

	@When("open url {string}")
	public void open_url(String string) {
	    lp = openURL(string);
	}

	@When("enter username {string} and password {string}")
	public void enter_username_and_password(String uname, String pass) {
	    lp.login(uname, pass);
	}

	@When("click submit")
	public void click_submit() {
	    hp = lp.click_submit();
	}

	@Then("User should be on home page")
	public void user_should_be_on_home_page() {
		hp.cartIconDisplayed();
		Assert.assertTrue(true);
	}
	
	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}

}
