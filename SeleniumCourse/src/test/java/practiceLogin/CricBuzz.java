package practiceLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricBuzz {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		// xpath to enter into desired page
		driver.findElement(By.xpath("//div[@title='23rd Match • ICC Cricket World Cup 2023']")).click();

		// xpath of score board
		WebElement score = driver.findElement(By.xpath("//h2[@class='cb-font-20 text-bold inline-block ng-binding']"));
		String tScore = score.getText();
		String tiScore = "";
		String nTScore = "";
		String over = "24";

		while (!tScore.equals(tiScore)) {

			if (!nTScore.equals(tScore)) {
				System.out.println(tScore);
				nTScore = tScore;
			} else {
				// xpath of score board
				score = driver.findElement(By.xpath("//h2[@class='cb-font-20 text-bold inline-block ng-binding']"));
				tScore = score.getText();
//				Thread.sleep(5000);
			}

//			Thread.sleep(15000);
			WebElement iScore;
			try {
				// xpath of score board with condition of over
				iScore = driver.findElement(
						By.xpath("//h2[@class='cb-font-20 text-bold inline-block ng-binding'][contains(text(),'(" + over
								+ ")')]"));
				tiScore = iScore.getText();
				System.out.println(tScore);
				System.out.println("Finished");
				break;

			} catch (Exception e) {

			}

		}
		driver.close();
	}

}
