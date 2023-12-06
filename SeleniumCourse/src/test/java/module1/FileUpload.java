package module1;
import practiceLogin.Flipkart1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
		
		
// ================= 9. How to upload file with sendkeys? ========================
		WebDriver driver = new ChromeDriver();
		driver.get("https://tus.io/demo");
		driver.manage().window().maximize();
		driver.findElement(By.id("P0-0")).sendKeys("C:\\Users\\gsdra\\OneDrive\\Desktop\\Desktop\\Guru\\Selenium\\FakePath\\TestUpload.txt");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='_buttons_gq6c0_28']/a")).click();
		Thread.sleep(5000);
		
		driver.switchTo().window(Flipkart1.selectWindow(driver, "child"));
		WebElement e = driver.findElement(By.xpath("/html/body/pre"));
		System.out.println(e.getText());
		
// ================= 10. How to upload file without sendkeys using Robot class? =================
	}

}
