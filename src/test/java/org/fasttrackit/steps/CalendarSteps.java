package org.fasttrackit.steps;

import cucumber.api.java.en.And;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Calendar;
import org.fasttrackit.pageobjects.GroupsPage;
import org.openqa.selenium.support.PageFactory;

public class CalendarSteps extends TestBase {

    Calendar calendar = PageFactory.initElements(driver, Calendar.class);
    GroupsPage groupsPage = PageFactory.initElements(driver, GroupsPage.class);

    @And("^I fill birth date field with year \"([^\"]*)\", month \"([^\"]*)\" and day \"([^\"]*)\"$")
    public void iFillBirthDateFieldWithYearMonthAndDay(String year, String month, String day) {

        groupsPage.getBirthDateField().click();
        calendar.getYear().selectByVisibleText(year);
        calendar.getMonth().selectByVisibleText(month);
        calendar.getDay(day).click();
    }
}
