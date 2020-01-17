package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;

public class TestPage {

    @FindBy(className = "icon-plus")
    private WebElement addInbox;

    @FindBy(xpath = "//p[contains(text(), 'Bimba și parola')]")
    private WebElement contentMailAsText;

    @FindBy(xpath = "//div[contains(text(), 'butterflylocal@gmail.com')]")
    private WebElement expectedMail;

    @FindBy(className = "user_name")
    private WebElement userName;

    @FindBy(className = "success")
    private WebElement accept;

    @FindBy(className = "msg_item")
    private List<WebElement> mailContent;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getAddInbox() {
        return addInbox;
    }

    public WebElement getAccept() {
        return accept;
    }

    public List<WebElement> getMailContent() {
        return mailContent;
    }

    public WebElement getExpectedMail() {
        return expectedMail;
    }

    public WebElement getContentMailAsText() {
        return contentMailAsText;
    }
}
