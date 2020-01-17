package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Payment {

    @FindBy(xpath = "(//div[@class='rate-price'])[1]")
    private WebElement totalPrice;


    @FindBy(xpath = "//div[contains(@class, 'rate-col') and (contains(@class, 'red') or contains(@class, 'green'))]")
    private WebElement buttonPayment;

    @FindBy(css = ".rate-col.rates.red")
    private List<WebElement> buttonPaymentList;

    @FindBy(xpath = "//div[@class='action-btns']//button[contains(text(), 'Pay')]")
    private WebElement approvePaymentButton;

    @FindBy(xpath = "//div[@class='action-btns']//button[contains(text(), 'Remove')]")
    private WebElement removePaymentButton;


    @FindBy(xpath = "//div[@class='rate-col rates red']//div[@class='rate-price']")
    private WebElement priceToPay;

    @FindBy(xpath = "(//div[@class='rate-col rates green']//div[@class='rate-price'])[2]")
    private WebElement pricePaid;

    @FindBy(xpath = "(//div[@class='rate-col rates green']//div[@class='rate-price'])[2]")
    private List<WebElement> pricePaidList;

    @FindBy(xpath = "//div[@class='rate-col rates red']//div[@class='rate-price']")
    private List<WebElement> priceToPayList;

    public List<WebElement> getPriceToPayList() {
        return priceToPayList;
    }

    public List<WebElement> getPricePaidList() {
        return pricePaidList;
    }

    public WebElement getApprovePaymentButton() {
        return approvePaymentButton;
    }

    public WebElement getRemovePaymentButton() {
        return removePaymentButton;
    }

    public WebElement getButtonPayment() {
        return buttonPayment;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getPriceToPay() {
        return priceToPay;
    }

    public WebElement getPricePaid() {
        return pricePaid;
    }

    public List<WebElement> getButtonPaymentList() {
        return buttonPaymentList;
    }

    public WebElement getButtonPay(WebDriver driver, int number) {
        return driver.findElement(By.xpath("(//div[contains(@class, 'rate-col') and (contains(@class, 'red') or contains(@class, 'green'))])[" + number + "]"));
    }

    public String getPrice(WebDriver driver, int column, int cellHalf) {
        WebElement element = driver.findElement(By.xpath("(//div[contains(@class, 'rate-col') and (contains(@class, 'red') or contains(@class, 'green'))])[" +
                column + "]//div[@class='rate-price'][" + cellHalf + "]"));

        return element == null ? null : element.getText();
    }

    public String getRatesPrice(WebDriver driver, int column) {
        WebElement element = driver.findElement(By.xpath("(//div[contains(@class, 'rate-col rates') ])["+ column +"]//div[@class='rate-price'][1]"));
        return element.getText();

    }
}
