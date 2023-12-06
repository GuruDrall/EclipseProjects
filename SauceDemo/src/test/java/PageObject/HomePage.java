package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ctc.wstx.sr.ElemAttrs;

import TestCases.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#shopping_cart_container")
	WebElement cartIcon;

//	@FindBy(xpath = "//div[@class='inventory_item']")
//	List<WebElement> productList;

	@FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_label']/a")
	List<WebElement> productList; // path for exact text tag

	@FindBy(css = ".inventory_item_name")
	WebElement productsName;

	@FindBy(css = ".btn")
	WebElement addCartBtn;
	
	By productBy = By.cssSelector(".inventory_item_name");
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productBy);
		return productList;
	}

	public boolean cartIconDisplayed() {
		return cartIcon.isDisplayed();
	}

	public void selectProductByName(String prodName) {
		int count = 0;
		for (WebElement product : productList) {
			String productName = product.getText();
			System.out.println(productName + "-->" + prodName);

			if (productName.equalsIgnoreCase(prodName)) {
				product.findElement(By.xpath("(//div[@class='inventory_item']//button)[3]")).click();
				count++;
				break;
			} else {
				System.out.println("finding");
			}
		}
		int cartCount = Integer.parseInt(cartIcon.getText());
		if (count == cartCount && count != 0) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	public CartPage clickOnCartIcon() {
		cartIcon.click();
		return new CartPage();
	}

}
