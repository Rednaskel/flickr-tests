package org.appium.tests.flickr.flickr_tests.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

import io.appium.java_client.ios.IOSDriver;

@ContextConfiguration("classpath:cucumber.xml")
public class DriverWrapper {

	public WebDriver driver = null;
	
	public void initialize(IOSDriver iosDriver) {
		driver = iosDriver;
	}

	public void close() {
		driver.close();
	}

	public boolean isInitialised() {
		return driver != null;
	}
}
