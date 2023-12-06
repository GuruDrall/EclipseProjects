package module3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().browserVersion("116.0.5845.96");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com");

	}

}
