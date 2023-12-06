package com.functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.action.perform.Action;
import com.main.base.BaseClass1;

public class LoginPage extends BaseClass1 {
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy (xpath = "//button[@id='submit']")
	WebElement submitBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		Action.enterValue(username, prop.getProperty("username"));
//		username.sendKeys(prop.getProperty("username"));
	}
	
	public void enterPassword() {
		Action.enterValue(password, prop.getProperty("password"));
//		password.sendKeys(prop.getProperty("password"));
	}
	
	public void enterUsername(String user) {
		Action.enterValue(username, user);
	}
	
	public void enterPassword(String pass) {
		Action.enterValue(username, pass);
	}
	
	public HomePage ClickSubmit() {
		Action.clickOn(submitBtn);
//		submitBtn.click();
		return new HomePage();
	}
	
	public HomePage loginWithDP(String uname, String pswd) {
		Action.enterValue(username, uname);
		Action.enterValue(password, pswd);
		Action.clickOn(submitBtn);
		return new HomePage();
	}
	

}
