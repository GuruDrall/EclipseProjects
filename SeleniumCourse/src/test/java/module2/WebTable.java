package module2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/gsdra/OneDrive/Desktop/Table.html");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
		String s = e.getText();
		System.out.println(s);
		
		//Count Row
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Total Rows are : " + row.size());
		
		//Count Column
		List<WebElement> col = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("Total Columns are : " + col.size());
		
		//Printing Table
		for(int i=2; i<=row.size(); i++) {
			for(int j=1; j<=col.size();j++) {
				System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText());
			}
		}
	}

}
