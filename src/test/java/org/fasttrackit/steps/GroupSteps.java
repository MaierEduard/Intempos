package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.GroupsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupSteps extends TestBase {

    private GroupsPage groupsPage = PageFactory.initElements(driver, GroupsPage.class);

    @And("^I click on add student button$")
    public void iClickOnAddStudentButton() {
        waitForPageToLoad(6000);
        List<WebElement> studentRegisteredOnWebsiteList = groupsPage.getStudentsRegistered();
        int sizeListBeforeAdded = studentRegisteredOnWebsiteList.size();

        getStepVariables().put("sizeListBeforeAdded", sizeListBeforeAdded);
        groupsPage.getAddStudent().click();
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String statutePerson) {
        waitForPageToLoad(6000);
        groupsPage.getStatutePerson(statutePerson).click();

    }

    @And("^In the student form I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void inTheStudentFormIFillInWith(String fieldName, String populatedValue) {
        groupsPage.getFieldsInAddStudent(fieldName).sendKeys(populatedValue);

    }

    @And("^I select location \"([^\"]*)\" in student form$")
    public void iSelectLocationInStudentForm(String locationCourse) {
        waitForPageToLoad(5000);
        groupsPage.getCourseLocationInStudentForm().selectByValue(locationCourse);
    }

    @And("^For Accreditation I select \"([^\"]*)\"$")
    public void forAccreditationISelect(String accreditationType) {
        groupsPage.getCourseAccreditation(accreditationType);

    }

    @And("^I select course \"([^\"]*)\" in student form$")
    public void iSelectCourseInStudentForm(String typeCourse) {
        waitForPageToLoad(5000);
        groupsPage.getTypeCourseInStudentForm().selectByVisibleText(typeCourse);


    }

    @And("^I select Language level \"([^\"]*)\"$")
    public void iSelectLanguageLevel(String languageLevel) {
        groupsPage.getLanguageLevel().selectByValue(languageLevel);
    }

    @And("^I click add study in student form$")
    public void iClickAddStudyInStudentForm() {

        groupsPage.getAddStudy().click();
    }

    @And("^I click add language in student form$")
    public void iClickAddLanguageInStudentForm() {
        waitForPageToLoad(6000);
        groupsPage.getAddLanguage().click();
    }

    @When("^I click submit button$")
    public void iClickSubmitButton() {
        groupsPage.getSubmitButton().click();
    }

    @And("^I select location \"([^\"]*)\" in group page$")
    public void iSelectLocationInGroupPage(String locationName) {
        waitForPageToLoad(5000);
        groupsPage.getLocationFieldInGroup().selectByValue(locationName);
    }

    @And("^I select course \"([^\"]*)\" in group page$")
    public void iSelectCourseInGroupPage(String courseName) {
        waitForPageToLoad(6000);
        groupsPage.getCourseFieldInGroup().selectByVisibleText(courseName);

    }

    @Then("^I expect the student to be added$")
    public void iExpectTheStudentToBeAdded() {
        waitForPageToLoad(6000);
        List<WebElement> studentRegisteredOnWebsiteList = groupsPage.getStudentsRegistered();
        int sizeAfterAdded = studentRegisteredOnWebsiteList.size();
        assertThat("The student doesn't added", getStepVariables().get("sizeListBeforeAdded"), is(sizeAfterAdded-1));

    }


    @Then("^I expect all the students to be registered on the course \"([^\"]*)\"$")
    public void iExpectAllTheStudentsToBeRegisteredOnTheCourse(String courseName) {
        waitForPageToLoad(6000);
        List<WebElement> editStudentsButtonList = groupsPage.getEditStudentsButtonList();

        for (WebElement containEditButtons : editStudentsButtonList) {
            containEditButtons.click();
            waitForPageToLoad(6000);

            List<String> studentsDetail = new ArrayList<>();
            for (WebElement contentStudent : groupsPage.getStudentDetail()) {
                waitForPageToLoad(6000);
                String text = contentStudent.getText();
                studentsDetail.add(text);
            }

            boolean courseNameFound = studentsDetail.stream().anyMatch(detail -> detail.contains(courseName));

//            Optional<String> any = studentDetail.stream()
//                    .filter(detail -> detail.contains(courseName))
//                    .findAny();
//
//            if (any.isPresent()) {
//                any.get();
//            }
            waitForPageToLoad(6000);
            assertThat("Course " + courseName + " not found.", courseNameFound);
//            assertThat("dsfsfsdfsdfs", studentsDetail.toString(), containsString(courseName));
            waitForPageToLoad(6000);
            groupsPage.getCancelButtonInStudentDetail().click();

        }
    }

    @When("^I search student by \"([^\"]*)\"$")
    public void iSearchStudentBy(String keyword) {
        groupsPage.search(keyword);
    }

    @Then("^all the students contain the name \"([^\"]*)\"$")
    public void allTheStudentsContainTheName(String expectedName) {
        List<String> studentsRegistered = new ArrayList<>();

        for (WebElement student : groupsPage.getStudentsRegistered()) {
            studentsRegistered.add(student.getText());
            System.out.println(student.getText());
            assertThat(" no elements found to contain the word " + expectedName, student.getText(), containsString(expectedName)  );

//            boolean studentFound = studentsRegistered.stream().anyMatch(detail -> detail.contains(expectedName));
//            assertThat(" no elements found how contain the word " + expectedName, studentFound);
        }

    }

    @And("^I click on edit student button$")
    public void iClickOnEditStudentButton() {
        waitForPageToLoad(5000);
        groupsPage.getEditButtonStudentsEnrolledWebsite().click();
    }

    @When("^I click to generate contract in table enrolled Website$")
    public void iClickToGenerateContractInTableEnrolledWebsite() {
        waitForPageToLoad(5000);
        groupsPage.getGenerateContractButtonEnrolledWebsite().click();
    }

    @Then("^I expect to be redirect to the generate contract page$")
    public void iExpectToBeRedirectToTheGenerateContractPage() throws InterruptedException {
        Thread.sleep(18000);
        String receivedPage = groupsPage.getGenerateContractPage().getText();
        String expectedPage = "Detalii Contract";
        assertThat(" redirect to the wrong page", receivedPage, is(expectedPage));
    }
}

