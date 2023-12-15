package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinations.BaseClass;

public class CartPage extends BaseClass{
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="#checkout")
	WebElement checkoutBtn;
	
	@FindBy (css="#first-name")
	WebElement firstName;
	
	@FindBy (css="#last-name")
	WebElement lastName;
	
	@FindBy (css="#postal-code")
	WebElement postalCode;
	
	@FindBy (css=".submit-button")
	WebElement submitBtn;
	
	@FindBy (css="#finish")
	WebElement finishBtn;
	
	@FindBy (xpath="//h2[@class='complete-header']")
	WebElement confirmOrder;
	
	
	
	public void clickOnCheckout() {
		checkoutBtn.click();
	}
	
	
	public boolean confirmationMsgCheck() {
		boolean status = confirmOrder.getText().equalsIgnoreCase("Thank you for your order!");
		return status;
	}

}
