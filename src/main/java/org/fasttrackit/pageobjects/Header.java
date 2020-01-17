package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Header {

    @FindBy(className = "logout-text")
    private WebElement logoutButton;

    @FindBy(className = "icons-area")
    private WebElement mediaMenu;


    public WebElement selectCategory(String categoryName, WebDriver driver) {
        return driver.findElement(By.xpath("//ul[@class='nav-list']//a[contains(text(), '" + categoryName + "')]"));
    }

    public Select getLocationCourse() {
        return new Select(locationCurs);
    }

    @FindBy(className = "select-item")
    private WebElement locationCurs;


    public WebElement getMediaMenu() {
        return mediaMenu;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}
