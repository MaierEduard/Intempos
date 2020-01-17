package org.fasttrackit.pageobjects;

import org.fasttrackit.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Calendar{
    public Select getMonth() {
        return new Select(DriverConfiguration.getDriver().findElement(By.className("react-datepicker__month-select")));
    }

    public Select getYear() {
        return new Select(DriverConfiguration.getDriver().findElement(By.className("react-datepicker__year-select")));
    }

    public WebElement getDay(String day) {
        return DriverConfiguration.getDriver().findElement(By.xpath("//div[@class='react-datepicker__month']//div[contains(text(), '" + day + "')]"));
    }
}
