package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class ShippingDetailsPage extends LoadableComponent<ShippingDetailsPage>{
	
	public WebDriver dr;
	public ShippingDetailsPage(WebDriver x) {
		dr = x;
		PageFactory.initElements(dr, this);
	}
	@FindBy(xpath = "") WebElement FullName;
	@FindBy(xpath = "") WebElement address;
	@FindBy(xpath = "") WebElement zip;
	@FindBy(xpath = "") WebElement MobileNum;
	@FindBy(xpath = "") WebElement saveContinue;
	public void addressDetails() {
		Utility u = new Utility(dr);
		u.typeOnAnyElement(FullName, "ertyfghjk rtyfghj");
		u.typeOnAnyElement(address, "sdfghrtyughj");
		u.typeOnAnyElement(zip, "12347");
		u.typeOnAnyElement(MobileNum, "2345678978");
		u.clickOnAnyElement(saveContinue);
	}
	
	@FindBy(xpath = "") WebElement cardName;
	@FindBy(xpath = "") WebElement cardNum;
	@FindBy(xpath = "") WebElement cvv;
	@FindBy(xpath = "") WebElement saveContinue2;
	@FindBy(xpath = "") WebElement placeOrder;
	public void cardDetailsAndPlaceOrder() {
		Utility u = new Utility(dr);
		u.typeOnAnyElement(cardName, "ertyfghjk rtyfghj");
		u.typeOnAnyElement(cardNum, "2345678978");
		u.typeOnAnyElement(cvv, "12347");
		u.clickOnAnyElement(saveContinue2);
		u.clickOnAnyElement(placeOrder);
	}
	
	@Override
	protected void load() {
		dr.get("https://www.target.com/s?searchTerm=kids+shoes");
		
	}
	@Override
	protected void isLoaded() throws Error {
	    Assert.assertTrue(dr.getCurrentUrl().equals("https://www.target.com/s?searchTerm=kids+shoes"));
	   
	}

}
