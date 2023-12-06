package module2;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotClassFileUpload {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		// Browser Open
		WebDriver driver = new ChromeDriver();
		// Open Site
		driver.get("https://demoqa.com/upload-download");
		// Maximizing Window
		driver.manage().window().maximize();
		
		// Creating WE of uploadFile
		WebElement e1 = driver.findElement(By.id("uploadFile"));
		
		Actions ac = new Actions(driver);
		ac.click(e1).perform();
		
		// Creating Robot Class to perform Ctrl+V+Enter and giving the path of file to System Clipboard
		Robot rc = new Robot();
		StringSelection copy = new StringSelection("C:\\Users\\gsdra\\eclipse-workspace\\siteAutomation\\ScreenShot\\AlertBoxSS.png");
		// Using Toolkit to Set path to Clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);
//		Key Press
		rc.keyPress(KeyEvent.VK_CONTROL);
		rc.keyPress(KeyEvent.VK_V);
		rc.keyPress(KeyEvent.VK_ENTER);
//		Key Release
		rc.keyRelease(KeyEvent.VK_CONTROL);
		rc.keyRelease(KeyEvent.VK_V);
		rc.keyRelease(KeyEvent.VK_ENTER);
		

	}

}
