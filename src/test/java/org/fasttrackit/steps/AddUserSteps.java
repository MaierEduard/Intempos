package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.AddUser;
import org.fasttrackit.pageobjects.CoursePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class AddUserSteps extends TestBase {

    AddUser addUser = PageFactory.initElements(driver, AddUser.class);
    CoursePage coursePage = PageFactory.initElements(driver, CoursePage.class);

    @And("^I press add user$")
    public void iPressAddUser() throws InterruptedException {
        Thread.sleep(3000);
        addUser.getAddUser().click();
    }

    @And("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iFillInWith(String fieldName, String firstName) throws InterruptedException {
        addUser.addUserFields(fieldName, driver).sendKeys(firstName);

        getStepVariables().put("populated credential", firstName);
        Thread.sleep(500);

    }

    @When("^I click on save button$")
    public void iClickOnSaveButton() {
        String value = addUser.getFieldUser().getAttribute("value");
        getStepVariables().put("user", value);

        addUser.getSaveButton().click();
    }

    @Then("^I expect the user to be created$")
    public void iExpectTheUserToBeCreated() throws InterruptedException {
        Thread.sleep(5000);

//        for (Map.Entry<String, Object> entry : TestBase.getStepVariables().entrySet()) {
//            if (entry.getKey().equalsIgnoreCase("populated credential"));
//
//            {
//                Object value = entry.getValue();
//                System.out.println(value + "value");
//            }
//        }

        List<WebElement> usersList = addUser.getAddedUsers();
        String userAsText = "";

        for (WebElement containsUsers : usersList) {
            String user = containsUsers.getAttribute("value");
            userAsText += user + " ";
        }


        System.out.println(getStepVariables().get("user") + " User");
        System.out.println(userAsText + "User As Text");


        assertThat("User id not created", userAsText, containsString((String) getStepVariables().get("user")));

    }


    @And("^I fill all fields with valid credential$")
    public void iFillAllFieldsWithValidCredential() {

        addUser.getFieldName().sendKeys("Loyyy");
        addUser.getFieldLastName().sendKeys("Bimbaa");
        addUser.getFieldEmail().sendKeys("bimbaa@gmail.com");
        addUser.getPhoneNumber().sendKeys("123456789");
        addUser.getFieldUser().sendKeys("Eduardd");
        addUser.getFunctionField().sendKeys("Fumator");
        addUser.getFieldBirthDate().sendKeys("08.09.1699");

        String name = addUser.getFieldName().getAttribute("value");
        String lastName = addUser.getFieldLastName().getAttribute("value");
        String user = addUser.getFieldUser().getAttribute("value");

        getStepVariables().put("name", name);
        getStepVariables().put("lastName", lastName);
        getStepVariables().put("user", user);

    }

    @Then("^I expect the user to be created \\(Test\\)$")
    public void iExpectTheUserToBeCreatedTest() throws InterruptedException {

        Thread.sleep(5000);

        List<WebElement> usersList = addUser.getAddedUsers();

        String usersAsText = addUser.getTableUsers().getText();

        String user = "";

        for (WebElement containsUsers : usersList) {
            String usersValue = containsUsers.getAttribute("value");
            user += usersValue + " ";
        }

        assertThat("User id not created", usersAsText, containsString((String) getStepVariables().get("name")));
        assertThat("User id not created", usersAsText, containsString((String) getStepVariables().get("lastName")));
        assertThat("User id not created", user, containsString((String) getStepVariables().get("user")));

    }

    @When("^I delete the user$")
    public void iDeleteTheUser() {

        List<WebElement> userListBeforeDelete = addUser.getAddedUsers();

        addUser.getDeleteThirdUser().click();
        waitForPageToLoad(2000);
        addUser.getAgreeDeleteUser().click();
        getStepVariables().put("userListBeforeDelete", userListBeforeDelete.size());

    }

    @Then("^I expect the user to be deleted$")
    public void iExpectTheUserToBeDeleted() {
        waitForPageToLoad(5000);
        List<WebElement> userListAfterDelete = addUser.getAddedUsers();


        System.out.println(userListAfterDelete);
        assertThat(userListAfterDelete.size() + 1, is(getStepVariables().get("userListBeforeDelete")));
    }
}


//for (Map.Entry<String, Object> entry : TestBase.getStepVariables().entrySet()) {
//        if (entry.getKey().equalsIgnoreCase("populated credential")) {
//        entry.getValue().
//        }
//        }