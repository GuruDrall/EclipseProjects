package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleCalendar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\Drivers\\chromedriver.exe");
		// Handling the Notification pop up - this is browser popup, can be handle by
		// passing it to WebDriver's constructor.
		ChromeOptions co = new ChromeOptions();
		// Disabling the notification popup
		co.addArguments("disable-notifications");

		// Creating Web driver
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		// Opening website
		driver.get("https://www.redbus.in/");

		// clicking on date icon on page
		driver.findElement(By.className("dateText")).click();

		// below mentions are the date needed to test
		String eDate = "26";
		String eMonth = "Oct";
		String eYear = "2024";
		// combining month and year
		String eMonthYear = eMonth + " " + eYear;

		// Selecting webElement where displayed month and year is shown
		WebElement displayedMonth = driver
				.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]"));
		String dMonthYear = displayedMonth.getText().substring(0, 8);

//		Condition applied
		while (!(dMonthYear.equals(eMonthYear))) {
//			System.out.println("A : " + dMonthYear + "--" + dMonthYear.length());
//			System.out.println("B : " + eMonthYear + "--" + eMonthYear.length());
//			System.out.println();

			// Finding xpath of next button - which will change the month and year in
			// calendar
			WebElement moveToNextMonth = driver
					.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][3]"));
			// after finding the element, now clicking on it until condition applied
			moveToNextMonth.click();
			dMonthYear = displayedMonth.getText().substring(0, 8);
			// Changing value of month and year every time
			displayedMonth = driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]"));
		}
//		System.out.println("A : " + dMonthYear + "--" + dMonthYear.length());
//		System.out.println("B : " + eMonthYear + "--" + eMonthYear.length());
//		System.out.println();

		// Creating xpath for expected date
		String dateXPath = "//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']/span[text()='" + eDate
				+ "']";
		// finding web element for that date
		WebElement date = driver.findElement(By.xpath(dateXPath));
		// after finding the element, now clicking on it
		date.click();
	}

}
