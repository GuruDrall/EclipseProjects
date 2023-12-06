/**
 * 
 */
package testngPackage;

import org.testng.annotations.Test;

/**
 * 
 */
public class Annotation_group {
	@Test (testName = "openURL",groups = "open") // groups name can be mentioned in only "" if it is single
	void openURL() throws InterruptedException {
		Thread.sleep(1500);
		System.out.println("opening URL");
	}

	@Test (groups = "open")
	void openBrowser() {
		System.out.println("Opening Browser");
	}
	
	@Test (description = "Login by entering correct credentials", groups = {"after open"})// or group name can be mentioned in {""} also
	void login() {
		System.out.println("Login");
	}

	@Test (description = "Redirected to Home Page", groups = {"after open"})
	void homePage() {
		System.out.println("Redirected to Home Page");
	}

}
