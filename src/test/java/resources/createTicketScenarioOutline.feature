Feature: Login functionality
  I want to use this to check the loin functionality for ServiceNow

	Background:
		Given User opens the application
		When User enters username and password
		And User clicks on the submit button
		Then User lands to homepage
		  
Scenario Outline: validate user is able to login
	And User fills Requestor Information
	And User selects Multilingual Support
	And User selects Source
	And User selects Reported for
	And User enters Site
	And User adds Description
	And User enters "<Catalog>" item
	And User clicks on Next button
	And User clicks on Save & Submit button
	And User gets the ticket number
    
Examples:

	 | Catalog |
	 | Access to Application |
	 | Access to Network |
	 | ATS Printer - Move-Add-Change Request |
	 | DataCenter Operations/Maintenance |
	
