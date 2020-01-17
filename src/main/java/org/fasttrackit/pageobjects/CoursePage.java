package org.fasttrackit.pageobjects;


import org.fasttrackit.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.sql.DriverManager;
import java.util.List;

public class CoursePage {

    @FindBy(xpath = "//tbody[@class='tbody']//tr")
    List<WebElement> courseList;

    @FindBy(css = ".cogo-btn.no")
    private WebElement declineDeleteCourse;

    @FindBy(css = ".cogo-btn.yes")
    private WebElement agreeDeleteCourse;

    @FindBy(xpath = "(//td[./preceding-sibling::td[.//select[@name='priceWithoutCertification-currency']]]//*[@class='table-icon'])[1]")
    private WebElement saveCourseButton;

    @FindBy(xpath = "(//td[./preceding-sibling::td]//button)[1]")
    private WebElement editButtonCurs;

    @FindBy(xpath = "(//td[./preceding-sibling::td]//button)[2]")
    private WebElement deleteCourse;

    @FindBy(xpath = "(//td[./preceding-sibling::td[.//select[@name='priceWithoutCertification-currency']]]//*[@class='table-icon'])[2]")
    private WebElement discardButton;

    @FindBy(className = "table-description")
    private WebElement courseName;

    @FindBy(className = "add-client")
    private WebElement addCourseButton;

    @FindBy(name = "name")
    private WebElement courseNameInCreateCurse;

    @FindBy(xpath = "//td[@class='location-td']//select[@class='select-item']")
    private WebElement locationFieldInCreateCourse;

    @FindBy(className = "date-picker")
    private WebElement startDateFieldInCreateCourse;

    @FindBy(name = "priceWithCertification")
    private WebElement accreditationPriceFieldInCreateCourse;

    @FindBy(name = "priceWithoutCertification")
    private WebElement priceWithoutAccreditationFieldInCreateCourse;


    public List<WebElement> getCoursePrice(String currencyPrice) {
        return DriverConfiguration.getDriver().findElements(By.xpath("//tbody[@class='tbody']//td[contains(text(), '" + currencyPrice + "')]"));
    }


    public Select getPriceCurrency() {
        return new Select(DriverConfiguration.getDriver().findElement(By.xpath("//select[@name='priceWithCertification-currency']")));
    }

    public WebElement getDeclineDeleteCourse() {
        return declineDeleteCourse;
    }

    public WebElement getAgreeDeleteCourse() {
        return agreeDeleteCourse;
    }

    public WebElement getDeleteCourse() {
        return deleteCourse;
    }

    public WebElement getSaveCourseButton() {
        return saveCourseButton;
    }

    public List<WebElement> getCourseList() {
        return courseList;
    }

    public WebElement getDiscardButton() {
        return discardButton;
    }

    public WebElement getEditButtonCurs() {
        return editButtonCurs;
    }

    public WebElement getPriceWithoutAccreditationFieldInCreateCourse() {
        return priceWithoutAccreditationFieldInCreateCourse;
    }

    public WebElement getAccreditationPriceFieldInCreateCourse() {
        return accreditationPriceFieldInCreateCourse;
    }

    public WebElement getStartDateFieldInCreateCourse() {
        return startDateFieldInCreateCourse;
    }

    public Select getLocationFieldInCreateCourse() {
        return new Select(locationFieldInCreateCourse);
    }

    public WebElement getAddCourseButton() {
        return addCourseButton;
    }

    public WebElement getCourseName() {
        return courseName;
    }

    public WebElement getCourseNameInCreateCurse() {
        return courseNameInCreateCurse;
    }
}
