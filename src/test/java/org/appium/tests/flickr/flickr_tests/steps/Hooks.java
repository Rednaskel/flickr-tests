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
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iPhone 6");
			capabilities.setCapability("platformVersion", "9.3");
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
}
