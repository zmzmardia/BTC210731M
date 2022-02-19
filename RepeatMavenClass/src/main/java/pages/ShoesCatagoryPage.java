package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class ShoesCatagoryPage extends LoadableComponent<ShoesCatagoryPage>{
	public WebDriver dr;
	 public ShoesCatagoryPage(WebDriver x) {
		 dr = x;
		 PageFactory.initElements(dr, this);
	 }
	 
	 @FindBy(xpath = "") WebElement anyShoe;
	 public ShoeDetailsPage clickOnAnyShoe() {
		 Utility u = new Utility(dr);
		 u.clickOnAnyElement(anyShoe);
		return new ShoeDetailsPage(dr);
	 }
	 
	 @Override
		protected void load() {
			dr.get("https://www.target.com/s?searchTerm=kids+shoes");
			 Header h = new Header(dr);
			 Footer f = new Footer(dr);
		}
		@Override
		protected void isLoaded() throws Error {
		    Assert.assertTrue(dr.getCurrentUrl().equals("https://www.target.com/s?searchTerm=kids+shoes"));
		    Header h = new Header(dr);
		    Footer f = new Footer(dr);
		}

}
