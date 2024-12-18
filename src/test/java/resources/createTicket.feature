Feature: Login functionlity
  I want to use this to check the loin functionlity for ServiceNow

Background: 
    Given User opens the application
    When User enters username and password
    And User clicks on the submit button
    Then User lands to homepage
  
Scenario: validate user is able to login
  And User fills Requestor Information
  And User selects Multilingual Support
  And User selects Source
  And User selects Reported for
  And User enters Site
  And User adds Description
  And User enters "Access to a public folder" item
  And User clicks on Next button
  And User clicks on Save & Submit button
  And User gets the ticket number
    

