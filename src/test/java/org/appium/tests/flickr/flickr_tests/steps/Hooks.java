package org.appium.tests.flickr.flickr_tests.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.appium.tests.flickr.flickr_tests.constants.Constants;
import org.appium.tests.flickr.flickr_tests.driver.DriverWrapper;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.Before;
import io.appium.java_client.ios.IOSDriver;
//org.springframework.test.context.ContextConfiguration

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class Hooks {
	
	@Autowired
	private DriverWrapper driverWrapper;
	
	public void setDriverWrapper(DriverWrapper driverWrapper) {
		this.driverWrapper = driverWrapper;
	}
	
	public DriverWrapper getDriverWrapper() {
		return driverWrapper;
	}
	
	@Before
	public void startApplication() throws MalformedURLException {
		if(!driverWrapper.isInitialised()) {			
			String platformName = getDefaultIfNull(System.getProperty("platformName"), "iOS");
			String deviceName = getDefaultIfNull(System.getProperty("deviceName"), "iPhone 6");
			String platformVersion = getDefaultIfNull(System.getProperty("platformVersion"), "9.3");
	
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", platformName);
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", platformVersion);
			capabilities.setCapability("app", Constants.applicationUnderTestPath);
			capabilities.setCapability("browserName", "");
			capabilities.setCapability("deviceOrientation", "portrait");
			capabilities.setCapability("appiumVersion", "1.5.3");
			
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driverWrapper.initialize(new IOSDriver(url, capabilities));
			
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					driverWrapper.close();
				}
			});
		}
	}
	
	private String getDefaultIfNull(String value, String defaultValue) {
		if(value != null) {
			return value;
		}
		return defaultValue;
	}
}
