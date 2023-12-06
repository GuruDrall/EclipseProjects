package module3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// To handle Authentication Popup, provide the username and password after https:// separation with ":" colon
		// here username = admin and password = admin then @
		// https://Username:Password@URL
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
