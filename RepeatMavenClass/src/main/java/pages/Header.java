package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div[2]/div/div[1]/ul/li/a") List<WebElement> allHeader;
	public WebDriver dr;
	 public Header(WebDriver x) {
		 dr = x;
		 PageFactory.initElements(dr, this);
	 }
	 

}
