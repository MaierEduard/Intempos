package org.fasttrackit.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddUser {

    @FindBy(css = ".cogo-btn.yes")
    private WebElement agreeDeleteUser;

    @FindBy(xpath = "(//td[@class='actions-td'])[3]")
    private WebElement deleteThirdUser;

    @FindBy(className = "admin-table")
    private WebElement tableUsers;

    @FindBy(xpath = "//input[@placeholder='nume']")
    private WebElement fieldName;

    @FindBy(xpath = "//input[@placeholder='prenume']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//input[@placeholder='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='telefon']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Data nasterii']")
    private WebElement fieldBirthDate;

    @FindBy(xpath = "//input[@placeholder='utilizator']")
    private WebElement userField;

    @FindBy(xpath = "//input[@placeholder='functie']")
    private WebElement functionField;

    @FindBy(xpath = "//table[@class='admin-table']//input")
    List<WebElement> addedUsers;

    @FindBy(xpath = "//input[@placeholder='utilizator']")
    private WebElement fieldUser;

    @FindBy(className = "add-client")
    private WebElement addUser;

    public WebElement addUserFields(String name, WebDriver driver) {
        return driver.findElement(By.xpath("//input[@placeholder='" + name + "']"));
    }

    @FindBy(xpath = "//input[@placeholder")
    private List<WebElement> test;

    @FindBy(xpath = "//input[@value='SALVEAZĂ']")
    private WebElement saveButton;

    public WebElement getFieldName() {
        return fieldName;
    }

    public WebElement getTableUsers() {
        return tableUsers;
    }

    public WebElement getFieldLastName() {
        return fieldLastName;
    }

    public WebElement getFieldEmail() {
        return fieldEmail;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getFieldBirthDate() {
        return fieldBirthDate;
    }

    public WebElement getUserField() {
        return userField;
    }

    public WebElement getFunctionField() {
        return functionField;
    }

    public WebElement getDeleteThirdUser() {
        return deleteThirdUser;
    }

    public List<WebElement> getTest() {
        return test;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getAddUser() {
        return addUser;
    }

    public WebElement getAgreeDeleteUser() {
        return agreeDeleteUser;
    }

    public WebElement getFieldUser() {
        return fieldUser;
    }

    public List<WebElement> getAddedUsers() {
        return addedUsers;
    }
}
