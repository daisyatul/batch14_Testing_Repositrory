package StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BaseTest;
import utils.TestContext;

public class StepDef2 extends BaseTest {

    TestContext testContext;

    public StepDef2(TestContext testContext){
        this.testContext=testContext;

    }
    //WebDriver driver;
    Scenario scenario;
    @Before  //native dependency injection in cucumber
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("Before each step");
    }

    @When("User enters amount and  select sender account number and recipient account number")
    public void user_enters_amount_and_select_sender_account_number_and_recipient_account_number() throws InterruptedException {
        testContext.getDriver().navigate().refresh();
        Thread.sleep(2000);
        testContext.getDriver().findElement(By.id("amount")).sendKeys("2");
        Thread.sleep(2000);
        Select FromAcc = new Select(testContext.getDriver().findElement(By.id("fromAccountId")));
        FromAcc.selectByIndex(0);
    }

    @When("User clicks on TRANSFER button")
    public void user_clicks_on_transfer_button() {
        testContext.getDriver().findElement(By.xpath("//input[@value='Transfer']")).click();

    }

    @Then("Transfer Complete message is  displayed")
    public void transfer_complete_message_is_displayed() {
        WebElement SuccessMsg = testContext.getDriver().findElement(By.xpath("//h1[text()='Transfer Complete!']"));
        Assert.assertEquals(SuccessMsg.isDisplayed(), true);
        WebElement amount = testContext.getDriver().findElement(By.id("amount"));
        WebElement FromAccNo = testContext.getDriver().findElement(By.id("fromAccountId"));
        WebElement ToAccNo = testContext.getDriver().findElement(By.id("toAccountId"));
        String amountText = amount.getText();
        String fromAcNm = FromAccNo.getText();
        String toAcNm = ToAccNo.getText();
        scenario.log("Message : " + amountText + "has been transferred from account " + fromAcNm + "to account " + toAcNm);

    }
}
