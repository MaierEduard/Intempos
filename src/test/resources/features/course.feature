Feature: Course Test

  Scenario: Verify that when clicking on Cursuri it redirects to right page
    Given I am on the login page
    And I clean all fields
    And I fill in User name with "admin"
    And I fill in Password with "123456"
    And I press Login button
    When I click on "Cursuri" section
    Then I expect to be redirected to the "Cursuri" page


  Scenario: Add course in Oradea location with valid credential
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I press add course button
    And I select location "Oradea" for new course
    And I fill in Curs with "Bimba"
    And I fill in Price with accreditation with "1400" Euro
    And I fill in Price without accreditation with "1000" Euro
    And I fill in Start Date with "1986-08-09"
    When I click on save course button
    And I sort courses by location "Oradea"
    Then I expect the course to be created

  Scenario: Add course in Cluj location with valid credential
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Cluj"
    And I press add course button
    And I select location "Cluj" for new course
    And I fill in Curs with "Bimba"
    And I fill in Price with accreditation with "1400" Euro
    And I fill in Price without accreditation with "1000" Euro
    And I fill in Start Date with "1986-08-09"
    When I click on save course button
    And I sort courses by location "Cluj"
    Then I expect the course to be created

  Scenario: Add course in Timisoara location with valid credential
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Timisoara"
    And I press add course button
    And I select location "Timisoara" for new course
    And I fill in Curs with "Bimba"
    And I fill in Price with accreditation with "1400" Euro
    And I fill in Price without accreditation with "1000" Euro
    And I fill in Start Date with "1986-08-09"
    When I click on save course button
    And I sort courses by location "Timisoara"
    Then I expect the course to be created


  Scenario: Add course in Oradea location and complete all the fields,after which discard them
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I press add course button
    And I select location "Oradea" for new course
    And I fill in Curs with "Bimba"
    And I fill in Price with accreditation with "1400" Euro
    And I fill in Price without accreditation with "1000" Euro
    And I fill in Start Date with "1986-08-09"
    When I click on discard button
    And I sort courses by location "Oradea"
    Then I expect the course to be discarded


  Scenario: Add course in Oradea location and after which discard them
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I press add course button
    When I click on discard button
    And I sort courses by location "Oradea"
    Then I expect the course to be discarded


  Scenario: Edit course name in Oradea location and after which save them
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I click on edit button
    And I clear course name and fill with valid credential
    When I click on save course button
    Then I expect the name of the course to be changed


  Scenario: Edit price in Oradea location and after which save them

    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I click on edit button
    And I clear course price and fill with valid credential
    When I click on save course button
    Then I expect the price of the course to be changed


  Scenario: Edit price in Cluj location and after which save them

    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Cluj"
    And I click on edit button
    And I clear course price and fill with valid credential
    When I click on save course button
    Then I expect the price of the course to be changed


  Scenario: Edit price with empty fields in Oradea location and after which save them
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I click on edit button
    And I clear course price
    When I click on save course button
    Then I expect a confirmation message that the fields price is not populated

  Scenario: Add course in Oradea location with price currency in Lei
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I press add course button
    And I select location "Oradea" for new course
    And I fill in Curs with "Bimba"
    And I fill in Price with accreditation with "1400" Euro
    And I fill in Price without accreditation with "1000" Euro
    When I change price currency "lei"
    And I fill in Start Date with "1986-08-09"
    And I click on save course button
    Then I expect the price currency of the course to be changed in "lei"


  Scenario: Edit course in Oradea location with price currency in Lei
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I click on edit button
    When I change price currency "lei"
    And I click on save course button
    Then I expect the price currency of the course to be changed in "lei"


  Scenario: Delete course in Oradea location
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    When I click on delete course button
    And I am agree to delete the course
    Then I expect the course to be deleted

  Scenario: Decline to delete course in Oradea location
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    When I click on delete course button
    And I am decline to delete the course
    Then I expect the course to not be deleted


  Scenario: Edit course in Oradea location after which discard them
    Given I am on the login page
    And I login with valid credentials
    And I click on "Cursuri" section
    And I sort courses by location "Oradea"
    And I click on edit button
    And I fill in Curs with "Tiby"
    And I fill in Price with accreditation with "599999" Euro
    And I fill in Price without accreditation with "989898" Euro
    When I click on discard button
    Then I expect the course to be the same as before







#    //td[./preceding-sibling::td[.//select[@class='select-item']]]

#  //td[./preceding-sibling::td[.//select[@name='priceWithoutCertification-currency']]]//button[@class='table-btn']//*[@class='table-icon']
#  (//td[./preceding-sibling::td[.//select[@name='priceWithoutCertification-currency']]]//*[@class='table-icon'])[2]

