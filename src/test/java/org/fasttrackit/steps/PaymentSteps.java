package org.fasttrackit.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.Payment;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class PaymentSteps extends TestBase {

    private Payment payment = PageFactory.initElements(driver, Payment.class);

    @When("^I click to pay installments$")
    public void iClickToPayInstallments() throws InterruptedException {
        Thread.sleep(2000);
        waitForPageToLoad(5000);


    }

    @Then("^the payment was approved$")
    public void thePaymentWasApproved() {

        int number = 1;
        int column = 1;
        int celHalf = 1;
        int limit = 12;

        for (int i = 1; i <= limit; i++) {
            Actions actions = new Actions(driver);
            actions.doubleClick(payment.getButtonPay(driver, number)).perform();
            number++;
            waitForPageToLoad(7000);

            if (driver.findElements(By.xpath("//div[@class='action-btns']//button[contains(text(), 'Pay')]")).size() != 0) {
                waitForPageToLoad(7000);
                payment.getApprovePaymentButton().click();
                waitForPageToLoad(7000);

            }else if (payment.getRemovePaymentButton().isDisplayed()){
                waitForPageToLoad(7000);
                payment.getRemovePaymentButton().click();
                waitForPageToLoad(7000);
            }
                String price = payment.getPrice(driver, column, celHalf);
                System.out.println(price);
                celHalf++;

                for (int j = 1; j <= celHalf; j++) {
                    waitForPageToLoad(7000);
                    String price1 = payment.getPrice(driver, column, celHalf);
                    System.out.println(price1);
                    celHalf--;
                }
                column++;
        }
    }

    @Then("^I expect the total price to be correct$")
    public void iExpectTheTotalPriceToBeCorrect() {

        int column = 1;
        int limit = 7;
        double totalPrice = 0;

        for (int i = 1; i <= limit; i++) {
            waitForPageToLoad(5000);
            String ratesPrice = payment.getRatesPrice(driver, column);
            System.out.println(ratesPrice);
            String[] priceSplit = ratesPrice.split(" ");
            String firstSplit = priceSplit[0];
            totalPrice += Double.parseDouble(firstSplit);
            column++;
        }
        double round = Math.round((totalPrice * 100) / 100);
        System.out.println(round);
        double expectedTotalPrice = Double.parseDouble(payment.getTotalPrice().getText());
        assertThat(" The total price is wrong", round, is(expectedTotalPrice));

    }
}
