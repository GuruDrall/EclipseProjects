package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinations.BaseClass;

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
	
	public void login(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
	}
	
	public HomePage click_submit() {
		submitBtn.click();
		return new HomePage();
	}
	

}
