package module3;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v85.page.model.JavascriptDialogOpening;

public class JavaScriptExecutorClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// Creating Java Script Object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// ======== Hit URL using Java Script - Using "window.location" =====================
		js.executeScript("window.location='https://www.linkedin.com/'");

		// =============== BROWSER RELATED SCRIPT =====================
		// Get Domain
		String domain = js.executeScript("return document.domain;").toString();
		System.out.println(domain);

		// Get URL
		String url = js.executeScript("return document.URL;").toString();
		System.out.println(url);

		// Get URL
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);

		// ================ WINDOW RELATED SCRIPT =======================
		// ====== To Scroll Down =============
//		// by scrollBy pixel (x axis,y axis)
//		js.executeScript("window.scrollBy(0,500)");
//		// by scrollBy document.body.scrollHeight
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// by scrollTo pixel (x axis,y axis)
//		js.executeScript("window.scrollTo(0,500)");
//		Thread.sleep(2000);
		// by scrollTo document.body.scrollHeight
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		// ====== To Scroll Up =============
//		// by scrollBy pixel (x axis,y axis)
//		js.executeScript("window.scrollBy(0,-500)");
//		// by scrollBy document.body.scrollHeight
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		// by scrollTo pixel (x axis,y axis)
//		js.executeScript("window.scrollTo(0,500)");
//		Thread.sleep(2000);
		// by scrollTo document.body.scrollHeight
//		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

		// ====== To Scroll Right Left =============
//		// by scrollBy pixel (x axis,y axis) - FOR RIGHT SCROLL by pixel
//		js.executeScript("window.scrollBy(100,0)");
//		Thread.sleep(2000);
		// by scrollBy pixel (x axis,y axis) - FOR LEFT SCROLL by pixel
//		js.executeScript("window.scrollBy(-100,0)");
//		// by scrollBy document.body.scrollWidth - RIGTH upto end
//		js.executeScript("window.scrollBy(document.body.scrollWidth,0)");
//		Thread.sleep(2000);
		// by scrollBy document.body.scrollWidth - LEFT upto end
//		js.executeScript("window.scrollBy(-document.body.scrollWidth,0)");

		// ====== To ZOOM Page =============
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='100'");

		// ============ To get the heigth and width of a webpage
		// =========================
		String height = js.executeScript("return window.innerHeight").toString();
		String width = js.executeScript("return window.innerWidth").toString();
		System.out.println("Height is : " + height + " And Width is : " + width);
		
		//===================== To generate the ALERT popup ===================
		js.executeScript("alert('Alert Popup');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

}
