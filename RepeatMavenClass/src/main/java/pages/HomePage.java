package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bit.common.Utility;

public class HomePage {
	public WebDriver dr;
 public HomePage(WebDriver x) {
	 dr = x;
	 PageFactory.initElements(dr, this);
 }
 
 @FindBy(xpath = "//*[@id=\"search\"]") WebElement searchBox;
 @FindBy(xpath = "//button[text()='go']") WebElement search;
 public void typeOnSearchBox() {
	 Utility u = new Utility(dr);
	 String atti = searchBox.getAttribute("type");
	 System.out.println(atti);
	 u.typeOnAnyElement(searchBox, "kids shoes");	 
 }
 
 public GirlsShoesPage clickOnSearch() throws InterruptedException {
	 Utility u = new Utility(dr);
	 u.clickOnAnyElement(search);
	 Thread.sleep(8000);
	 return new GirlsShoesPage(dr);
 }
 
 
 
 
}
