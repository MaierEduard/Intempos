package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.MatcherAssert.assertThat;

public class HeaderSteps extends TestBase {

    Header header = PageFactory.initElements(driver, Header.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Then("^I should be signed in$")
    public void iShouldBeSignedIn()  {

        waitForPageToLoad(6000);
        assertThat("I couldn't log in with valid credentials", header.getLogoutButton().isDisplayed());
    }

    @And("^I click on media menu$")
    public void iClickOnMediaMenu() throws InterruptedException {
        Thread.sleep(3000);
        header.getMediaMenu().click();
    }

    @And("^I click on \"([^\"]*)\" section$")
    public void iClickOnSection(String courseName) {
        waitForPageToLoad(6000);
        header.selectCategory(courseName, driver).click();
    }

    @And("^I sort courses by location \"([^\"]*)\"$")
    public void iSortCoursesByLocation(String location) {
header.getLocationCourse().selectByValue(location);

    }

    @When("^I click on logout button$")
    public void iClickOnLogoutButton() {
        waitForPageToLoad(6000);
        header.getLogoutButton().click();
    }

//    @Then("^I expect to be redirect to the login page$")
//    public void iExpectToBeRedirectToTheLoginPage() {
//
//    }

    @Then("^I should be signed up$")
    public void iShouldBeSignedUp() {
        waitForPageToLoad(6000);
        assertThat("I can't signed up", loginPage.getLoginButton().isDisplayed());
    }
}
