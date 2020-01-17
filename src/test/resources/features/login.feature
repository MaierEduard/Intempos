Feature: Login Tests

  Scenario: Login with valid credentials as admin rol
    Given I am on the login page
    And I clean all fields
    And I fill in User name with "admin"
    And I fill in Password with "123456"
    When I press Login button
    Then I should be signed in


  Scenario: Login with invalid credentials
    Given I am on the login page
    And I clean all fields
    And I fill in User name with "Ochelaristul"
    And I fill in Password with "123456"
    When I press Login button
    Then I expect a confirmation message that the user name or/and password is incorrect

  Scenario: Check if logout button works correctly
    Given I am on the login page
    And I login with valid credentials
    When I click on logout button
    Then I should be signed up

  Scenario: Check if forgot password button works correctly
    Given I am on the login page
    When I click to forgot password button
    Then I expect to redirect me to the forget user name or password


  Scenario: Check if I can change my password that is under 6 characters
    Given I am on the login page
    When I click to forgot password button
    And I am in forgot password or user name page and i fill in "username" field with "Eduardd"
    And I press Trimite button
    When I change my password which is under 6 characters
    Then I expect a message that the password must contain more than 6 characters



#  //td[@class='table-action blue' and position()=6]

#    Scenario: Check if I forgot the user name I can recover it
#      Given I am on the login page
#      And I click to forgot password button
#      And I am in forgot password or user name page and i fill in "username" field with "Eduard"
#      And I press Trimite button
#      And I open a new tab "https://mail.google.com"
#      And I login to gmail with valid credential
#      When I change my password
#      Then I can login with a new password
#
#
#      Scenario: Open multiple browser
#        Given I am on the login page
#        And I open a new Chrome browser





