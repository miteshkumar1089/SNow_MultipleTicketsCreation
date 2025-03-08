Feature: Inactive catalog item validation
  I want to use this feature file to check catalog item is inactive in Maintain Items table

Background: 
    Given User opens the application
    When User enters username and password
    And User clicks on the submit button
    Then User lands to homepage

  Scenario Outline: validate catalog item is marked inactive
    When User opens Maintain items table
    And User enters "<Catalog>" item in Action/Name field
    Then User validates if Active checkbox is unchecked

    Examples:

      | Catalog                               |
      | Access to a public folder             |
      | Access to Network                     |
      | ATS Printer - Move-Add-Change Request |
      | DataCenter Operations/Maintenance     |

