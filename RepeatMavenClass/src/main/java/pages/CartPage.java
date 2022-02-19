package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import com.bit.common.Utility;

public class CartPage extends LoadableComponent<CartPage>{
	public WebDriver dr;

	public CartPage(WebDriver x) {
		dr = x;
		PageFactory.initElements(dr, this);
	}


	@FindBy(xpath = "list of option tag") List<WebElement> options;
	@FindBy(xpath = "") WebElement initPrice;
	@FindBy(xpath = "") WebElement changedPrice;
	public void compareQntAndPrice(int expQnt) {
		String initP = initPrice.getText().replace("$", "");
		double initPr = Double.parseDouble(initP);
		for(WebElement option:options) {
			String op = option.getText().replace("Qty ", "");
			int actQnt = Integer.parseInt(op);
			if(actQnt == expQnt) {
				option.click();
				String changedP = changedPrice.getText().replace("$", "");
		          double changedPr = Double.parseDouble(changedP);
		         if(initPr * expQnt == changedPr) {
		        	 System.out.println(" Price is ok");
		         }
			}
		}
	}
	@FindBy(xpath = "") WebElement checkOut;
	public SignInPage clickOnCheckOut() {
		Utility u = new Utility(dr);
		u.clickOnAnyElement(checkOut);
		return new SignInPage(dr);
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
