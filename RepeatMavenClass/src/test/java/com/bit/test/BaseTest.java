package com.bit.test;

import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.db.ReadFile;

public class BaseTest {
	public WebDriver dr;
	@Before
	public void openBrowser() throws IOException {
		//from properties file
		Properties p = ReadFile.readProp("C:\\Users\\Mounia2016\\OneDrive\\Desktop\\BTC31072021M\\MavenRepeatClass\\src\\test\\resources\\config.properties");
	    String br = p.getProperty("browser");
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mounia2016\\Downloads\\chromedriver_win32\\chromedriver.exe");
	       dr = new ChromeDriver();
	    }else if(br.equals("firefox")) {
	    	
	    }
	    dr.get(p.getProperty("url"));
	}
	
	@After
	public void closeBrowser() {
		dr.quit();
	}

	/*public void openBrowser2() throws IOException {
		//from command line using System class
		
	    String br = System.getProperty("browser");
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mounia2016\\Downloads\\chromedriver_win32\\chromedriver.exe");
	       dr = new ChromeDriver();
	    }else if(br.equals("firefox")) {
	    	
	    }
	}*/
	
}
