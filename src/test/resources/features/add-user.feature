Feature: Add User Test

  Scenario Outline: Add user with valid credential

    Given I am on the login page
    And I clean all fields
    And I fill in User name with "admin"
    And I fill in Password with "123456"
    And I press Login button
    And I click on media menu
    And I press add user
    And I fill in "nume" with "<populated first name>"
    And I fill in "prenume" with "<populated second name>"
    And I fill in "email" with "<populated email>"
    And I fill in "telefon" with "<populated phone>"
    And I fill in "utilizator" with "<populated user>"
    And I fill in "functie" with "<populated function>"
    And I fill in "Data nasterii" with "<populated birth date>"
    When I click on save button
    Then I expect the user to be created
    When I delete the user
    Then I expect the user to be deleted

    Examples:
      | populated first name | populated second name | populated email         | populated phone | populated birth date | populated user | populated function |
      | Cuba                 | Buna din              | Bimbadincuba@gmail.com | 123456789       | 09/08/1986           | Bimba         | Fumator            |


  Scenario: Add user with invalid credential

    Given I am on the login page
    And I clean all fields
    And I fill in User name with "admin"
    And I fill in Password with "123456"
    And I press Login button
    And I click on media menu
    And I press add user
    And I fill all fields with valid credential
    When I click on save button
    Then I expect the user to be created (Test)

