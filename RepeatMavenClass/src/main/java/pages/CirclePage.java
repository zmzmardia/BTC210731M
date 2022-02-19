package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class CirclePage extends LoadableComponent<CirclePage>{
	
	public WebDriver dr;
	public CirclePage(WebDriver x) {
		dr = x;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath = "") WebElement skip;
	public ShippingDetailsPage clickOnSkip() {
		Utility u = new Utility(dr);
		u.clickOnAnyElement(skip);
		return new ShippingDetailsPage(dr);
	}
	
	@Override
	protected void load() {
		dr.get("https://www.target.com/s?searchTerm=kids+shoes");
		 Footer f = new Footer(dr);
	}
	@Override
	protected void isLoaded() throws Error {
	    Assert.assertTrue(dr.getCurrentUrl().equals("https://www.target.com/s?searchTerm=kids+shoes"));
	    Footer f = new Footer(dr);
	}

}
