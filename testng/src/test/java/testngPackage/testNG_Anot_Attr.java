/**
 * 
 */
package testngPackage;

import org.testng.annotations.Test;

/**
 * 
 */
public class testNG_Anot_Attr {

		@Test (priority = 2, timeOut = 1000)
		void openURL() throws InterruptedException {
			Thread.sleep(1500);
			System.out.println("opening URL");
		}

		@Test (priority = 1, enabled= true)
		void openBrowser() {
			System.out.println("Opening Browser");
		}
		
		@Test (priority = 3)
		void login() {
			System.out.println("Login");
		}

		@Test (priority = 4, dependsOnMethods = {"openURL"})
		void homePage() {
			System.out.println("Redirected to Home Page");
		}
}

