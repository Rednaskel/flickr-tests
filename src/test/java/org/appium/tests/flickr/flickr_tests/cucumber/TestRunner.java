package org.appium.tests.flickr.flickr_tests.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/org/appium/tests/flickr/flickr_tests/features",
		glue = "org.appium.tests.flickr.flickr_tests.steps",
		format = {"pretty", "html:target/Destination"})
public class TestRunner {

}
