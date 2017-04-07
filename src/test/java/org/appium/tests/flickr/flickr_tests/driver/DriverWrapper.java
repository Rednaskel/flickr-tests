package org.appium.tests.flickr.flickr_tests.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;

import io.appium.java_client.ios.IOSDriver;

@ContextConfiguration("classpath:cucumber.xml")
public class DriverWrapper {

	public WebDriver driver = null;
	
	public void initialize(IOSDriver iosDriver) {
		driver = iosDriver;
	}

	public void close() {
		driver.quit();
	}

	public boolean isInitialised() {
		return driver != null;
	}

	public void pressKey(String key) {
		driver.findElement(By
				.xpath("//UIAButton[@name='" + key + "']")).click();
	}

	public void searchText(String query) {
		driver.findElement(By.xpath("//UIAWindow/descendant::UIASearchBar[1]"))
		.sendKeys(query);;
		
	}

	public void clearSearchField() {
		driver.findElement(By
				.xpath("//UIAWindow/descendant::UIASearchBar[1]")).clear();
	}
}
