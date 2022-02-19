package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class ShoeDetailsPage extends LoadableComponent<ShoeDetailsPage>{
	public WebDriver dr;

	public ShoeDetailsPage(WebDriver x) {
		dr = x;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = "") WebElement dropDown;
	@FindBy(xpath = "") List<WebElement> allNum;

	public void selectQuantity(int expectedNum) {
		Utility u = new Utility(dr);
		u.clickOnAnyElement(dropDown);
		for (WebElement num : allNum) {
			String textNum = num.getText();
			int number = Integer.parseInt(textNum);
			if (number == expectedNum) {
				num.click();
			}
		}
	}

	@FindBy(xpath = "//*[@id=\"viewport\"]/div[4]/div/div[2]/div[2]/div[3]/div[1]/div[2]"
			+ "/div/button/img") List<WebElement> allColors;
	
    public void selectColor(String expectedColorName) {
       for(WebElement color:allColors) {
    	   String colorName = color.getAttribute("alt");
    	   if(colorName.equals(expectedColorName)) {
    		   color.click();
    	   }
       }
	}
    
    @FindBy(xpath = "") List<WebElement> allSizes;

	public void selectSize(int expectedSize) {
		for (WebElement size : allSizes) {
			String textNum = size.getText();
			int actualSize = Integer.parseInt(textNum);
			if (actualSize == expectedSize ) {
				size.click();
			}
		}
	}
	
	@FindBy(xpath = "") WebElement shipIt;
	@FindBy(xpath = "") WebElement veiwCart;
	public CartPage clickOnCart() {
		Utility u = new Utility(dr);
		u.clickOnAnyElement(shipIt);
		u.clickOnAnyElement(veiwCart);
		return new CartPage(dr);
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
