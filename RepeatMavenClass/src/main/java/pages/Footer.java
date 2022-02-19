package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
	
	@FindBy(xpath = "//*[@id=\"footer\"]/div/div[1]/a") List<WebElement> allfooter;
	public WebDriver dr;
	public Footer(WebDriver x){
		dr = x;
		PageFactory.initElements(dr, this);
	}

}
