package com.bit.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	public WebDriver dr;
	public ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	public ExtentTest test;
	@BeforeSuite
	public void setUp() {
		htmlreporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}
	/*@AfterSuite
	public void TearUp() {
		extent.flush();
	}*/
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mounia2016\\Downloads\\chromedriver_win32\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://www.target.com/");
	}
	@AfterClass
	public void closeBrowser() {
		dr.quit();
	}
	@AfterMethod
	public void CheckingResult(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.pass(result.getName() + " is successed");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL, result.getThrowable());
		File sf=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(sf, new File("C:\\Users\\Mounia2016\\OneDrive\\Desktop\\ScreenShot\\snap.png"),true);
	//test.log(Status.FAIL, " failed method is "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Mounia2016\\OneDrive\\Desktop\\BTC31072021M\\MavHou2\\screeshot.png" ).build());

	test.addScreenCaptureFromPath("C:\\Users\\Mounia2016\\OneDrive\\Desktop\\ScreenShot\\snap.png");
		}else if(result.getStatus() == ITestResult.SKIP) {
			//System.out.println(result.getName() + " is skipped");
		test.skip(result.getName() + " is skipped")	;
		}
		extent.flush();
	}
	
	
}
