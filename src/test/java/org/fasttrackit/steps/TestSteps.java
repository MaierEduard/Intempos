package org.fasttrackit.steps;

import cucumber.api.java.en.And;

import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.LoginPage;
import org.fasttrackit.pageobjects.TestPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class TestSteps extends TestBase {

    TestPage testPage = PageFactory.initElements(driver, TestPage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @And("^I open a new tab \"([^\"]*)\"$")
    public void iLoginTo(String siteAddress)  {

        ((JavascriptExecutor) driver).executeScript("window.open ('about:blank','-blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        waitForPageToLoad(6000);
        driver.get(siteAddress);
        waitForPageToLoad(6000);

    }

    @And("^I open a new Chrome browser$")
    public void iOpenANewChromeBrowser() throws InterruptedException {

        driver.get("http://192.168.1.2:3300");
        waitForPageToLoad(6000);
       loginPage.getForgotPasswordButton().click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        System.out.println(allWindows.length);
        driver.switchTo().window(allWindows[0].toString());
        driver.switchTo().window(allWindows[1].toString());

//        driver.get("http://192.168.1.2:3300");
//        Thread.sleep(2000);
//        Object[] allWindows = driver.getWindowHandles().toArray();
//        Thread.sleep(2000);
//        System.out.println(allWindows.length);
//        driver.switchTo().window(allWindows[0].toString());
//        Thread.sleep(2000);
//        driver.switchTo().window(allWindows[1].toString());



    }
}
