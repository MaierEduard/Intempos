package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPageSteps extends TestBase {

    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    private Header header = PageFactory.initElements(driver, Header.class);


    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        driver.get(AppConfig.getSiteUrl());
    }

    @And("^I clean all fields$")
    public void iCleanAllFields() {
        loginPage.getUserNameField().clear();
        loginPage.getPasswordField().clear();
    }


    @And("^I fill in User name with \"([^\"]*)\"$")
    public void iFillInUserNameWith(String userName) {
        loginPage.getUserNameField().sendKeys(userName);
    }

    @And("^I fill in Password with \"([^\"]*)\"$")
    public void iFillInPasswordWith(String password) {

        loginPage.getPasswordField().sendKeys(password);
    }

    @When("^I press Login button$")
    public void iPressLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("^I expect a confirmation message that the user name or/and password is incorrect$")
    public void iExpectAConfirmationMessageThatTheUserNameOrAndPasswordIsIncorrect() {

        String invalidCredential = loginPage.getMsgInvalidUserNameOrPassword().getText();

        assertThat("I can login with invalid credential", invalidCredential, is("Nume sau parolă incorecte."));

    }

    @And("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {

        loginPage.getUserNameField().clear();
        loginPage.getPasswordField().clear();
        loginPage.getUserNameField().sendKeys("admin");
        loginPage.getPasswordField().sendKeys("123456");
        loginPage.getLoginButton().click();

    }

    @When("^I click to forgot password button$")
    public void iClickToForgotPasswordButton() {
        loginPage.getForgotPasswordButton().click();
    }

    @Then("^I expect to redirect me to the forget user name or password$")
    public void iExpectToRedirectMeToTheForgetUserNameOrPassword() {
        String forgotPasswordMsg = loginPage.getForgotPasswordTitlePage().getText();
        assertThat("I am not redirected to the forgot password page", forgotPasswordMsg, is("Introdu numele de utilizator sau email-ul"));
    }

    @When("^I am in forgot password or user name page and i fill in \"([^\"]*)\" field with \"([^\"]*)\"$")
    public void iAmInForgotPasswordOrUserNamePageAndIFillInFieldWith(String userNameOrPasswordField, String userNameOrPassword) {
        waitForPageToLoad(6000);
        loginPage.getUserNameOrPasswordField(userNameOrPasswordField).sendKeys(userNameOrPassword);
    }

    @And("^I press Trimite button$")
    public void iPressTrimiteButton() {
        loginPage.getSendButton().click();
    }

    @And("^I login to gmail with valid credential$")
    public void iLoginToGmailWithValidCredential() throws InterruptedException {

        driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("maiereduard86@gmail.com");
        driver.findElement(By.className("RveJvd")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("");
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//table[@id=':2u']//tbody//td//div//div//span[contains(text(), 'Cod unic')]")).click();
        Thread.sleep(3000);
        String mailAsText = driver.findElement(By.xpath("//p[contains(text(), 'parolei:')]")).getText();
        System.out.println(mailAsText);
        String[] mailAsTextSplit = mailAsText.split("parolei: ");
        String codeReceiveOnMail = mailAsTextSplit[1];
        System.out.println(codeReceiveOnMail + "  splitttttttttttttt");

        getStepVariables().put("codeReceiveOnMail", codeReceiveOnMail);

    }

    @Given("^I am on the login page test$")
    public void iAmOnTheLoginPageTest() throws InterruptedException {
        driver.get(AppConfig.getSiteUrl());
        Thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.2:3300/");
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().window(winHandleBefore);
        Thread.sleep(2000);
        loginPage.getUserNameField().clear();
        Thread.sleep(2000);
    }


    @And("^I change my password$")
    public void iChangeMyPassword() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        waitForPageToLoad(6000);
        String password = "1234567";
        getStepVariables().put("password", password);
        loginPage.getNewPassword().sendKeys("1234567");
        loginPage.getConfirmPassword().sendKeys("1234567");
        loginPage.getCodeReceiveOnMail().sendKeys((CharSequence) getStepVariables().get("codeReceiveOnMail"));
        Thread.sleep(2000);
        loginPage.getSendButtonInChangePasswordPage().click();
    }

    @Then("^I can login with a new password$")
    public void iCanLoginWithANewPassword() {

        loginPage.getUserNameField().sendKeys("Eduard");
        loginPage.getPasswordField().sendKeys((CharSequence) getStepVariables().get("password"));
        loginPage.getSendButton().click();
        assertThat(" The new password doesn't work", header.getLogoutButton().isDisplayed());

    }

    @When("^I change my password which is under 6 characters$")
    public void iChangeMyPasswordWhichIsUnderCharacters() {
        waitForPageToLoad(6000);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getNewPassword()));
        loginPage.getNewPassword().sendKeys("1234");
        loginPage.getConfirmPassword().sendKeys("1234");
        loginPage.getCodeReceiveOnMail().sendKeys("1234");
        loginPage.getSendButtonInChangePasswordPage().click();

    }

    @Then("^I expect a message that the password must contain more than 6 characters$")
    public void iExpectAMessageThatThePasswordMustContainMoreThanCharacters() {

        String passwordMessage = loginPage.getPasswordMessage().getText();
        assertThat(" The password is changed", passwordMessage, is("Parolele trebuie să aibă cel puțin 6 caractere."));
    }
}
