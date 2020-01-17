package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.CoursePage;
import org.fasttrackit.pageobjects.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CourseSteps extends TestBase {

    Header header = PageFactory.initElements(driver, Header.class);
    CoursePage coursePage = PageFactory.initElements(driver, CoursePage.class);


    public void getAllCredentialOfCourse() {

        List<String> courseList = new ArrayList<>();
        waitForPageToLoad(6000);

        for (WebElement containCourse : coursePage.getCourseList()) {
            String courseAsText = containCourse.getText();
            System.out.println(courseAsText);
            courseList.add(courseAsText);
        }
        System.out.println(courseList);
        getStepVariables().put("courseList", courseList);
    }

    @Then("^I expect to be redirected to the \"([^\"]*)\" page$")
    public void iExpectToBeRedirectedToThePage(String course) {
        waitForPageToLoad(6000);

        String courseName = coursePage.getCourseName().getText();
        assertThat("The page could not be accessed", courseName, is(course));

    }

    @And("^I press add course button$")
    public void iPressAddCourseButton() {
        waitForPageToLoad(6000);

        List<String> courseList = new ArrayList<>();

        for (WebElement containCourse : coursePage.getCourseList()) {
            String courseAsText = containCourse.getText();
            courseList.add(courseAsText);
        }
        int size = courseList.size();
        int size1 = courseList.size() + 1;
        getStepVariables().put("size +1", size1);
        getStepVariables().put("size", size);
        coursePage.getAddCourseButton().click();
    }

    @And("^I select location \"([^\"]*)\" for new course$")
    public void iSelectLocationForNewCourse(String courseLocation) throws InterruptedException {
        Thread.sleep(500);
        coursePage.getLocationFieldInCreateCourse().selectByValue(courseLocation);
        getStepVariables().put("courseLocation", courseLocation);

    }


    @And("^I fill in Curs with \"([^\"]*)\"$")
    public void IFillInCursWith(String courseName) {
        coursePage.getCourseNameInCreateCurse().sendKeys(courseName);
        getStepVariables().put("courseName", courseName);
    }


    @And("^I fill in Start Date with \"([^\"]*)\"$")
    public void iFillInStartDateWith(String startDate) {
        coursePage.getStartDateFieldInCreateCourse().sendKeys(startDate);
        getStepVariables().put("startDate", startDate);
    }


    @And("^I fill in Price with accreditation with \"([^\"]*)\" Euro$")
    public void iFillInPriceWithAccreditationWithEuro(String accreditationPrice) throws InterruptedException {
        Thread.sleep(3000);
        coursePage.getAccreditationPriceFieldInCreateCourse().sendKeys(accreditationPrice);
        getStepVariables().put("accreditationPrice", accreditationPrice);

    }

    @And("^I fill in Price without accreditation with \"([^\"]*)\" Euro$")
    public void iFillInPriceWithoutAccreditationWithEuro(String priceWithoutAccreditation) {
        coursePage.getPriceWithoutAccreditationFieldInCreateCourse().sendKeys(priceWithoutAccreditation);
        getStepVariables().put("priceWithoutAccreditation", priceWithoutAccreditation);

    }


    @When("^I click on save course button$")
    public void iClickOnSaveCourseButton() {

        coursePage.getSaveCourseButton().click();
    }

    @Then("^I expect the course to be created$")
    public void iExpectTheCourseToBeCreated() {

        List<String> courseList = new ArrayList<>();
        waitForPageToLoad(6000);

        for (WebElement containCourse : coursePage.getCourseList()) {
            String courseAsText = containCourse.getText();
            System.out.println(courseAsText);
            courseList.add(courseAsText);
        }

        System.out.println(getStepVariables().get("size +1"));
        System.out.println(courseList.size());
        System.out.println(getStepVariables().get("priceWithoutAccreditation"));
        System.out.println(getStepVariables().get("accreditationPrice"));
        System.out.println(getStepVariables().get("startDate"));
        System.out.println(getStepVariables().get("courseName"));
        System.out.println(getStepVariables().get("courseLocation"));


        assertThat("Can't added a new course", getStepVariables().get("size +1"), is(courseList.size()));
        assertThat("Can't added a new course", courseList.toString(), containsString((String) getStepVariables().get("priceWithoutAccreditation")));
        assertThat("Can't added a new course", courseList.toString(), containsString((String) getStepVariables().get("accreditationPrice")));
        assertThat("Can't added a new course", courseList.toString(), containsString((String) getStepVariables().get("startDate")));
        assertThat("Can't added a new course", courseList.toString(), containsString((String) getStepVariables().get("courseName")));
        assertThat("Can't added a new course", courseList.toString(), containsString((String) getStepVariables().get("courseLocation")));

    }

    @When("^I click on discard button$")
    public void iClickOnDiscardButton() {

        coursePage.getDiscardButton().click();
    }

    @Then("^I expect the course to be discarded$")
    public void iExpectTheCourseToBeDiscarded() {

        List<String> courseList = new ArrayList<>();
        waitForPageToLoad(6000);

        for (WebElement containCourse : coursePage.getCourseList()) {
            String courseAsText = containCourse.getText();
            System.out.println(courseAsText);
            courseList.add(courseAsText);
        }

        System.out.println(getStepVariables().get("size"));
        System.out.println(courseList.size());

        assertThat("The course is not discarded", getStepVariables().get("size"), is(courseList.size()));

    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() {
        waitForPageToLoad(6000);
        List<WebElement> courseList = coursePage.getCourseList();
        WebElement firstCourse = courseList.get(0);
        getStepVariables().put("firstCourse", firstCourse);
        coursePage.getEditButtonCurs().click();
    }


    @And("^I clear course name and fill with valid credential$")
    public void iClearCourseNameAndFillWithValidCredential() {
        coursePage.getCourseNameInCreateCurse().clear();
        coursePage.getCourseNameInCreateCurse().sendKeys("Javra");
        String courseNameChanged = coursePage.getCourseNameInCreateCurse().getAttribute("value");
        getStepVariables().put("courseNameChanged", courseNameChanged);
    }

    @Then("^I expect the name of the course to be changed$")
    public void iExpectTheNameOfTheCourseToBeChanged() {

        getAllCredentialOfCourse();
        System.out.println(getStepVariables().get("courseNameChanged"));
        assertThat("The course name doesn't change", getStepVariables().get("courseList").toString(), containsString((String) getStepVariables().get("courseNameChanged")));

    }

    @And("^I clear course price and fill with valid credential$")
    public void iClearCoursePriceAndFillWithValidCredential() {

        coursePage.getAccreditationPriceFieldInCreateCourse().clear();
        coursePage.getAccreditationPriceFieldInCreateCourse().sendKeys("1000");


        coursePage.getPriceWithoutAccreditationFieldInCreateCourse().clear();
        coursePage.getPriceWithoutAccreditationFieldInCreateCourse().sendKeys("500");

        String accreditationPrice = coursePage.getAccreditationPriceFieldInCreateCourse().getAttribute("value");
        String withoutAccreditationPrice = coursePage.getPriceWithoutAccreditationFieldInCreateCourse().getAttribute("value");

        getStepVariables().put("accreditationPrice", accreditationPrice);
        getStepVariables().put("withoutAccreditationPrice", withoutAccreditationPrice);
    }

    @Then("^I expect the price of the course to be changed$")
    public void iExpectThePriceOfTheCourseToBeChanged() {

        getAllCredentialOfCourse();

        assertThat("The price of the course doesn't change", getStepVariables().get("courseList").toString(), containsString((String) getStepVariables().get("accreditationPrice")));
        assertThat("The price of the course doesn't change", getStepVariables().get("courseList").toString(), containsString((String) getStepVariables().get("withoutAccreditationPrice")));

    }

    @And("^I clear course price$")
    public void iClearCoursePrice()  {
        coursePage.getAccreditationPriceFieldInCreateCourse().clear();
        coursePage.getPriceWithoutAccreditationFieldInCreateCourse().clear();

        String value = coursePage.getAccreditationPriceFieldInCreateCourse().getAttribute("value");
        System.out.println(value);
    }

    @Then("^I expect a confirmation message that the fields price is not populated$")
    public void iExpectAConfirmationMessageThatTheFieldsPriceIsNotPopulated() {

        assertThat("The course was edited", coursePage.getSaveCourseButton().isDisplayed());

    }

    @When("^I change price currency \"([^\"]*)\"$")
    public void iChangePriceCurrency(String priceCurrency) {

        coursePage.getPriceCurrency().selectByValue(priceCurrency);
        getStepVariables().put("priceCurrency", priceCurrency);
    }


    @Then("^I expect the price currency of the course to be changed in \"([^\"]*)\"$")
    public void iExpectThePriceCurrencyOfTheCourseToBeChangedIn(String currency) {
        List<WebElement> coursePrice = coursePage.getCoursePrice(currency);

        for (WebElement containsPrice : coursePrice) {
            String coursePriceAsText = containsPrice.getText();
            assertThat("Currency price doesn't change", coursePriceAsText, containsString((String) getStepVariables().get("priceCurrency")));
        }
    }

    @When("^I click on delete course button$")
    public void iClickOnDeleteCourseButton() {
        waitForPageToLoad(6000);
        List<WebElement> courseList = coursePage.getCourseList();
        int sizeCourseListBeforeDecline = courseList.size();
        int sizeCourseListBeforeDelete = courseList.size() - 1;
        getStepVariables().put("sizeCourseListBeforeDecline", sizeCourseListBeforeDecline);
        getStepVariables().put("sizeCourseListBeforeDelete", sizeCourseListBeforeDelete);
        waitForPageToLoad(6000);
        coursePage.getDeleteCourse().click();
    }


    @And("^I am agree to delete the course$")
    public void iAmAgreeToDeleteTheCourse() {
        coursePage.getAgreeDeleteCourse().click();
    }

    @Then("^I expect the course to be deleted$")
    public void iExpectTheCourseToBeDeleted() {
        waitForPageToLoad(6000);
        List<WebElement> courseList = coursePage.getCourseList();
        int sizeCourseListAfterDelete = courseList.size();
        System.out.println(getStepVariables().get("sizeCourseListBeforeDelete") + " Before");
        System.out.println(sizeCourseListAfterDelete + " After");

        assertThat("The course can't be deleted", sizeCourseListAfterDelete, is(getStepVariables().get("sizeCourseListBeforeDelete")));
    }

    @And("^I am decline to delete the course$")
    public void iAmDeclineToDeleteTheCourse() {
        waitForPageToLoad(6000);
        coursePage.getDeclineDeleteCourse().click();

    }

    @Then("^I expect the course to not be deleted$")
    public void iExpectTheCourseToNotBeDeleted() {

        List<WebElement> courseList = coursePage.getCourseList();
        int sizeCourseListAfterDecline = courseList.size();
        assertThat("The course is deleted", sizeCourseListAfterDecline, is(getStepVariables().get("sizeCourseListBeforeDecline")));
    }

    @Then("^I expect the course to be the same as before$")
    public void iExpectTheCourseToBeTheSameAsBefore() {

        List<WebElement> courseList = coursePage.getCourseList();
        WebElement firstCourse = courseList.get(0);
        System.out.println(getStepVariables().get("firstCourse"));
        System.out.println(firstCourse);

        assertThat("The course is not the same", getStepVariables().get("firstCourse"), is(firstCourse));
    }
}
