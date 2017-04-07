package org.appium.tests.flickr.flickr_tests.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.ContextConfiguration;

import io.appium.java_client.ios.IOSDriver;

@ContextConfiguration("classpath:cucumber.xml")
public class DriverWrapper {

	private WebDriver driver = null;
	private String KEYBOARD_KEY_XPATH = "//UIAButton[@name='%s']";
	private final By SEARCH_FIELD_BY = By.xpath("//UIAWindow/descendant::UIASearchBar[1]");
	private final By ALL_TITLE_ELEMENTS_BY = By.xpath("//UIACollectionCell/UIAStaticText");
	
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
				.xpath(String.format(KEYBOARD_KEY_XPATH, key))).click();
	}

	public void searchText(String query) {
		driver.findElement(SEARCH_FIELD_BY).sendKeys(query);;
		
	}

	public void clearSearchField() {
		driver.findElement(SEARCH_FIELD_BY).clear();
	}

	public List<WebElement> getAllTitleElements() {
		return driver.findElements(ALL_TITLE_ELEMENTS_BY);
	}
}
