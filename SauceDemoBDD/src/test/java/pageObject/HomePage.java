package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinations.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#shopping_cart_container")
	WebElement cartIcon;


	@FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_label']/a")
	List<WebElement> productList; 

	@FindBy(css = ".inventory_item_name")
	WebElement productsName;

	@FindBy(css = ".btn")
	WebElement addCartBtn;
	
	By productBy = By.cssSelector(".inventory_item_name");
	

	public boolean cartIconDisplayed() {
		return cartIcon.isDisplayed();
	}

	public CartPage clickOnCartIcon() {
		cartIcon.click();
		return new CartPage();
	}

}
