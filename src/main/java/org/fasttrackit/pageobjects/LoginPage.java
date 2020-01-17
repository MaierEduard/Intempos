package org.fasttrackit.pageobjects;

import org.fasttrackit.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//div[@id='passwords-too-short-error-msg']//p")
    private WebElement passwordMessage;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirm-password']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='token']")
    private WebElement codeReceiveOnMail;

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//form[@class='form-signin']//p[contains(text(), 'Nume sau parolă incorecte')]")
    private WebElement msgInvalidUserNameOrPassword;

    @FindBy(id = "forgot-password")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//p[contains(text(), 'Introdu numele de utilizator sau email-ul')]")
    private WebElement forgotPasswordTitlePage;

    public WebElement getUserNameOrPasswordField(String userNameOrPassword) {
        return DriverConfiguration.getDriver().findElement(By.id("" + userNameOrPassword +""));
    }

    @FindBy(name = "Submit")
    private WebElement sendButton;

    @FindBy(xpath = "(//input[@class='btn btn-lg submitButton'])[2]")
    private WebElement sendButtonInChangePasswordPage;

    public WebElement getForgotPasswordTitlePage() {
        return forgotPasswordTitlePage;
    }

    public WebElement getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    public WebElement getMsgInvalidUserNameOrPassword() {
        return msgInvalidUserNameOrPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getNewPassword() {
        return newPassword;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getCodeReceiveOnMail() {
        return codeReceiveOnMail;
    }

    public WebElement getSendButtonInChangePasswordPage() {
        return sendButtonInChangePasswordPage;
    }

    public WebElement getPasswordMessage() {
        return passwordMessage;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getSendButton() {
        return sendButton;
    }


}
