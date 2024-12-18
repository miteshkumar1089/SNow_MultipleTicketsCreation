Feature: Login functionlity
  I want to use this to check the loin functionlity for ServiceNow

  Scenario: validate user is able to login
    Given User opens the application
    When User enters username and password
    And User clicks on the submit button
    Then User lands to homepage

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
