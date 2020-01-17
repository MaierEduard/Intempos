Feature: Group Test

  Scenario: Add student with valid credential
    Given I am on the login page
    And I login with valid credentials
    And I click on "Grupe" section
    And I select location "Cluj" in group page
    And I select course "Java 2019-11-13" in group page
    And I click on add student button
    And I select "Persoana fizica"
    And In the student form I fill in "nume" with "Bimba"
    And In the student form I fill in "prenume" with "Loyy"
    And  I fill birth date field with year "1986", month "September" and day "19"
    And In the student form I fill in "telefon" with "222222"
    And In the student form I fill in "email" with "bimba@gmail.com"
    And In the student form I fill in "tara" with "Romania"
    And In the student form I fill in "oras" with "Cluj"
    And In the student form I fill in "cod postal" with "222222"
    And In the student form I fill in "adresa completa" with "Strada Bimba, nr.22, Scara 2, Ap. 22 "
    And In the student form I fill in "Ocupatia" with "Tamplar"
    And In the student form I fill in "cnp" with "222222"
    And In the student form I fill in "numele bancii" with "Bimba Bank"
    And In the student form I fill in "Cont bancar" with "222222"
    And For Accreditation I select "Acreditat"
    And I select location "Cluj" in student form
    And I select course "Java 2019-11-13" in student form
    And In the student form I fill in "scoala" with "Tamplar"
    And In the student form I fill in "specializare" with "Tamplar"
    And I click add study in student form
    And In the student form I fill in "limba" with "Turca"
    And I select Language level "BEGINNER"
    And I click add language in student form
    When I click submit button
    Then I expect the student to be added


  Scenario: Check if all the students are registered in the selected course
    Given I am on the login page
    And I login with valid credentials
    And I click on "Grupe" section
    And I select location "Cluj" in group page
    When I select course "Java 2019-11-13" in group page
    Then I expect all the students to be registered on the course "2019-11-13"


  Scenario: Check if the search work properly
    Given I am on the login page
    And I login with valid credentials
    And I click on "Grupe" section
    And I select location "Cluj" in group page
    And I select course "Java 2019-11-13" in group page
    When I search student by "Dan"
    Then all the students contain the name "Dan"


  Scenario: Check if I can added another course to students, and after that we able to generate a contract
    Given I am on the login page
    And I login with valid credentials
    And I click on "Grupe" section
    And I select location "Cluj" in group page
    And I select course "Java 2019-11-13" in group page
    And I click on edit student button
    And I select location "Cluj" in student form
    And I select course "JAVA 2019-10-29" in student form
    And I click submit button
    And I select location "Cluj" in group page
    And I select course "JAVA 2019-10-29" in group page
    When I click to generate contract in table enrolled Website
    Then I expect to be redirect to the generate contract page






