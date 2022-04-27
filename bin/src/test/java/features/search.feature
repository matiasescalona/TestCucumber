Feature: search
  Scenario: buscar dress
    Given the user is in the index page
    When the user enters deesses in the search bar
    And the user clicks the search button
    Then the dress page appears