package org.appium.tests.flickr.flickr_tests.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.appium.tests.flickr.flickr_tests.constants.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class Driver {

	protected WebDriver driver = null;
	
	@Before
	public void startApplication() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("platformVersion", "9.3");
        capabilities.setCapability("app", Constants.applicationUnderTestPath);
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.5.3");
        
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new IOSDriver(url, capabilities);
	}
	
	@After
	public void closeApplication() {
		driver.close();
	}
}
