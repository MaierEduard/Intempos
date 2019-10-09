package org.fasttrackit.steps;

import cucumber.api.java.en.Given;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;

public class LoginPageSteps extends TestBase {



    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        driver.get(AppConfig.getSiteUrl());
    }
}
