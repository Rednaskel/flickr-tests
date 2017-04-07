package org.appium.tests.flickr.flickr_tests.steps;


import java.util.List;
import java.util.stream.Collectors;

import org.appium.tests.flickr.flickr_tests.driver.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import api.helper.FlickrApiHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.*;

@ContextConfiguration("classpath:cucumber.xml")
public class Steps {
	
	@Autowired
	private DriverWrapper driverWrapper;
	
	public void setDriverWrapper(DriverWrapper driverWrapper) {
		this.driverWrapper = driverWrapper;
	}
	
	public DriverWrapper getDriverWrapper() {
		return driverWrapper;
	}

	@Given("^I have empty search field$")
	public void I_have_empty_search_field() throws Throwable {
		driverWrapper.clearSearchField();
	}
	
	@Given("^I enter search query \"([^\"]*)\"$")
	public void I_enter_search_query(String query) throws Throwable {
		driverWrapper.searchText(query);
	}
	
	@When("^I press \"([^\"]*)\" key$")
	public void I_press_key(String arg1) throws Throwable {
		driverWrapper.pressKey("Search");
	}
	
	@Then("^I can see same titles as those from API \"([^\"]*)\"$")
	public void I_can_see_same_titles_as_those_from_API(String query) throws Throwable {
	    FlickrApiHelper apiHelper = new FlickrApiHelper();
	    List<String> titlesFromApi = apiHelper.getTitlesFromJsonResponse(query);
	    
	    List<WebElement> titlesElements = driverWrapper.getAllTitleElements();
	    List<String> titlesFromElements = titlesElements.stream()
	    		.map(titleElement -> titleElement.getAttribute("label")).collect(Collectors.toList());
	    assertThat(titlesFromElements).isEqualTo(titlesFromApi);
	}
	
}
