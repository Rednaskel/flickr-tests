Feature: Search

Scenario Outline: Pictures titles 
	Given I have empty search field
	And I enter search query "<query>"
	When I press "Search" key
	Then I can see same titles as those from API "<query>" 
	
	Examples:
		| query  |
		| London |
		| peanut butter madness | 