Feature: Payment Tests

  Scenario: check if I can pay installments
    Given I am on the login page
    And I login with valid credentials
    And I click on "Plati" section
    And I select location "Cluj" in group page
    And I select course "Java 2019-11-13" in group page
    When I click to pay installments
    Then the payment was approved

Scenario: Check the total price is correct
  Given I am on the login page
  And I login with valid credentials
  And I click on "Plati" section
  And I select location "Cluj" in group page
  When I select course "Java 2019-11-13" in group page
  Then I expect the total price to be correct
