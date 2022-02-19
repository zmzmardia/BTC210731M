package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class GirlsShoesPage extends LoadableComponent<GirlsShoesPage>{
	public WebDriver dr;
	 public GirlsShoesPage(WebDriver x) {
		 dr = x;
		 PageFactory.initElements(dr, this);
	 }
	 
	 @FindBy(xpath = "//*[@id=\"mainContainer\"]/div[5]/div[1]/div/ul/li[1]/a/div/div[1]/div/div/picture/img") WebElement girls;
	 public ShoesCatagoryPage clickOnGirls() throws InterruptedException {
		 Utility u = new Utility(dr);
		 Thread.sleep(8000);
		 u.clickOnAnyElement(girls);
		 return new ShoesCatagoryPage(dr);
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
