package org.fasttrackit.pageobjects;

import org.fasttrackit.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GroupsPage {

    @FindBy(xpath = "//div[@class='modal-description']" )
    private WebElement generateContractPage;

    @FindBy(xpath = "(//td[@class='table-action blue'])[2]")
    private WebElement generateContractButtonEnrolledWebsite;

    public WebElement selectDetailsContract(String contract) {
        return DriverConfiguration.getDriver().findElement(By.xpath("//div[@class ='sc-bxivhb KUZtY animation-div']//a[contains(text(), " + contract + "')]"));
    }

    public void search(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.ENTER);
    }

    public Select getLocationFieldInGroup() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("//div[@class='select-column']//select[@class='select-item']")));
    }

    public Select getCourseFieldInGroup() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("(//select[@class='select-item'])[2]")));
    }

    @FindBy(xpath = "(//td[@class='table-action blue'])[4]")
    private WebElement editButtonStudentsEnrolledWebsite;

    @FindBy(xpath = "//input[@class='select-item']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButtonInStudentDetail;

    @FindBy(xpath = "//table[@class='course-group']//tbody//tr")
    private List<WebElement> studentDetail;

    @FindBy(xpath = "//td[@class='table-action blue' and position()=6]")
    private List<WebElement> editStudentsButtonList;

    @FindBy(xpath = "//table[@class='user-table']//tbody//tr")
    private List<WebElement> studentsRegistered;

    @FindBy(name = "data-nasterii")
    private WebElement birthDateField;

    @FindBy(className = "add-client")
    private WebElement addStudent;

    @FindBy(xpath = "//table[@class='course-group']//tbody//tr")
    private List<WebElement> coursesDetailList;

    @FindBy(className = "add-row-btn")
    private WebElement addStudy;

    @FindBy(xpath = "//div[@class='modal-footer']//input[@class='btn modal-btn']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class='btn add-row-btn']")
    private WebElement addLanguage;

    public WebElement getGenerateContractButtonEnrolledWebsite() {
        return generateContractButtonEnrolledWebsite;
    }

    public Select getLanguageLevel() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("//select[@class='blue-input']")));
    }

    public Select getCourseLocationInStudentForm() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("//select[@class='blue-input select']")));
    }

    public WebElement getCourseAccreditation(String cursAccreditation) {
        return DriverConfiguration.getDriver().findElement(By.xpath("//div[@class='radio-group']//label[contains(text(), '" + cursAccreditation + "')]"));
    }

    public Select getTypeCourseInStudentForm() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("(//select[@class='blue-input select'])[2]")));
    }


    public WebElement getStatutePerson(String statute) {
        return DriverConfiguration.getDriver().findElement(By.xpath("//div[@class='radio-group']//label[contains(text(), '" + statute + "')]"));
    }

    public WebElement getFieldsInAddStudent(String fieldName) {
        return DriverConfiguration.getDriver().findElement(By.xpath("//div[@class='input-label-group']//input[@placeholder='" + fieldName + "']"));
    }

    public WebElement getAddStudent() {
        return addStudent;
    }

    public List<WebElement> getCoursesDetailList() {
        return coursesDetailList;
    }

    public WebElement getCancelButtonInStudentDetail() {
        return cancelButtonInStudentDetail;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getAddStudy() {
        return addStudy;
    }

    public WebElement getAddLanguage() {
        return addLanguage;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getBirthDateField() {
        return birthDateField;
    }

    public List<WebElement> getStudentsRegistered() {
        return studentsRegistered;
    }

    public List<WebElement> getEditStudentsButtonList() {
        return editStudentsButtonList;
    }

    public List<WebElement> getStudentDetail() {
        return studentDetail;
    }

    public WebElement getEditButtonStudentsEnrolledWebsite() {
        return editButtonStudentsEnrolledWebsite;
    }

    public WebElement getGenerateContractPage() {
        return generateContractPage;
    }
}
