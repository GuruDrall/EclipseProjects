package com.action.perform;

import org.openqa.selenium.WebElement;

import com.main.base.BaseClass1;

public class Action extends BaseClass1 {
	
	public static void enterValue(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}
	
	public static void clickOn(WebElement ele) {
		ele.click();		
	}

}
