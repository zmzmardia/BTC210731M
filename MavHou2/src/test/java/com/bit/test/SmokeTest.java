package com.bit.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest{
	@Test
	public void targetScenario() {
		test = extent.createTest("target Scenario", "from the homepage it will click on Registry");
		dr.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div[1]/li[1]/a")).click();
	}
	
	@Test(priority = 1)
	public void targetScenario2() {
		test = extent.createTest("target Scenario 2", "from the homepage it will click on Registry");
	     dr.findElement(By.xpath("//*[@id=\"headerMain\"]/a[3]")).click();
	     dr.findElement(By.xpath("//*[@id=\"categoriesMenu\"]/ul/li[1]")).click();
	}
	
	public void target() {
		dr.findElement(By.className("")).click();
	}

}
