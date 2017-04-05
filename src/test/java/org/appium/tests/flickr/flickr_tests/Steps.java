package org.appium.tests.flickr.flickr_tests;


import org.appium.tests.flickr.flickr_tests.driver.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Steps extends Driver{
	
	@Test
	public void firstAppiumTest() {
		WebElement searchField = driver.findElement(By.xpath("//UIAWindow/descendant::UIASearchBar[1]"));
		searchField.sendKeys("London");
		WebElement keyboardSearchButton = driver.findElement(By.xpath("//UIAButton[@name='Search']"));
		keyboardSearchButton.click();

	}
	
}
