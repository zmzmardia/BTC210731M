package com.bit.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	public WebDriver dr;
	public Utility(WebDriver dr) {
		this.dr = dr;
	}
	
	public void typeOnAnyElement(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	public void clickOnAnyElement(WebElement ele) {
		ele.click();
	}
	
	public void click() {
		dr.findElement(By.id("")).click();
	}

}
