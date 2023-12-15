package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css="#user-name")
	WebElement username;
	
	@FindBy (css="#password")
	WebElement password;
	
	@FindBy (css=".submit-button.btn_action")
	WebElement submitBtn;
	
	public HomePage perform_login(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		submitBtn.click();
		return new HomePage();
	}
	

}
