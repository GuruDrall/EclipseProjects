package com.functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.action.perform.Action;
import com.main.base.BaseClass1;

public class HomePage extends BaseClass1 {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='Home']")
	WebElement homeBtn;
	
	@FindBy (xpath = "//a[text()='Practice']")
	WebElement practiceBtn;
	
	@FindBy (xpath = "//a[text()='Courses']")
	WebElement coursesBtn;
	
	@FindBy (xpath = "//a[text()='Blog']")
	WebElement blogBtn;
	
	@FindBy (xpath = "//a[text()='Contact']")
	WebElement contactBtn;
	
	@FindBy (xpath = "//a[text()='Log out']")
	WebElement logoutBtn;
	
	@FindBy (xpath = "(//input[@class='mailpoet_text'])[1]")
	WebElement name;
	
	@FindBy (xpath = "(//input[@class='mailpoet_text'])[2]")
	WebElement eMail;
	
	@FindBy (xpath = "//input[@class='mailpoet_submit']")
	WebElement CheatSheetbtn;
	
	public void clickHome() {
		Action.clickOn(homeBtn);
	}
	
	public void enterNameEmail() {
		Action.enterValue(name, "Anil");
		Action.enterValue(eMail, "anil@gmail.com");
	}
	
	public void clickCheatSeet() {
		Action.clickOn(CheatSheetbtn);
	}
	
	
	
}
