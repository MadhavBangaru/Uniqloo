	Feature: Goibibo Website
	@Homepage
	Scenario Outline: Booking flight tickets 
	
	Given When user in on Goibibo Homepage.
	
	When user selects "<trip>" trip
	
	Then user enters "<from>" and "<destination>"
	And user enters "<departure>" 
	Then user enters travellers "<adults>","<children>","<infants>" and "<class>" type
	And user clicks on search button
	Then user is navigated to selection page
	
	Examples:
	|trip | from 	  | destination |departure| adults | children | infants | class |
	|oneway| Hyderabad | Bengaluru   |28 July | 1 | 2 | 0 |  Economy |
	
	@Reviewpage
	Scenario: Book cheap flight and review
	
	When user is navigated to selection page
	And user selects cheapest flight ticket
	Then user directed to review page
	
	
	
	
