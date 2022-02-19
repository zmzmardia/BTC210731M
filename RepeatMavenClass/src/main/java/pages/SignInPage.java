package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.bit.common.Utility;

public class SignInPage extends LoadableComponent<SignInPage>{
	
	public WebDriver dr;
	public SignInPage(WebDriver x) {
		dr = x;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath = "") WebElement email;
	@FindBy(xpath = "") WebElement password;
	@FindBy(xpath = "") WebElement checkBox;
	@FindBy(xpath = "") WebElement signIn;
	@FindBy(xpath = "") WebElement notFindAcc;
	public void SignIn(String expectedText) {
		Utility u = new Utility(dr);
		u.typeOnAnyElement(email, "ertyurtyu@gmail.com");
		u.typeOnAnyElement(password, "ertyuQ345");
		u.clickOnAnyElement(checkBox);
		u.clickOnAnyElement(signIn);
		String actualText = notFindAcc.getText();
		if(actualText.equals(expectedText)) {
			System.out.println("the masseage is "+ expectedText);
		}
	}
	@FindBy(xpath = "") WebElement accEmail;
	@FindBy(xpath = "") WebElement accPassword;
	@FindBy(xpath = "") WebElement fname;
	@FindBy(xpath = "") WebElement lname;
	@FindBy(xpath = "") WebElement keepMe;
	@FindBy(xpath = "") WebElement creatAcc;
	public CirclePage creatAccount() {
		Utility u = new Utility(dr);
		u.typeOnAnyElement(email, "ertyurtyu@gmail.com");
		u.typeOnAnyElement(fname, "Fghjkk");
		u.typeOnAnyElement(lname, "Avbnghj");
		u.typeOnAnyElement(password, "ertyuQ345");
		u.clickOnAnyElement(keepMe);
		u.clickOnAnyElement(creatAcc);
		return new CirclePage(dr);
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
