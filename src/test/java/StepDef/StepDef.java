package StepDef;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BaseTest;
import utils.DriverFactory;
import utils.TestContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Log4j2
public class StepDef extends BaseTest {
    TestContext testContext;

    public StepDef(TestContext testContext){
        this.testContext=testContext;

    }


    //Config
    String url = "https://parabank.parasoft.com/parabank/index.htm";
    String userName = "john";
    String password = "demo";



    Scenario scenario;


    @Before  //native dependency injection in cucumber
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("Before each step");
    }


    // Log in
    @Given("User opened the browser")
    public void user_opened_the_browser() {
        String browserName= System.getProperty("browser");
        testContext.setDriver(DriverFactory.createInstance(browserName));
       // driver= DriverFactory.createInstance(browserName);// after dependency injection we do not need driver inplace testContext needed
        //driver = new ChromeDriver();
        log.debug("Chrome initialized");
        testContext.getDriver().manage().window().maximize(); // maximize browser window
        log.debug("window maximize");
        testContext.getDriver().manage().deleteAllCookies(); // delete all cookies
        testContext.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Given("User navigated to the application url")
    public void user_navigated_to_the_application_url() {
        //driver.findElement(By.linkText(linkName)).click();
        testContext.getDriver().get(url);
        log.debug("Navigated to url "+url);

    }

    @When("User enter username as {string} and password as {string} and click on login button")
    public void user_enter_username_as_and_password_as_and_click_on_login_button(String string, String string2) {
        testContext.getDriver().findElement(By.name("username")).sendKeys(string);
        log.debug("Get user name"+userName);
        testContext.getDriver().findElement(By.name("password")).sendKeys(string2);
        log.debug("Get password"+password);
        testContext.getDriver().findElement(By.xpath("//input[@value='Log In']")).click();
        log.debug("Log in button click");
    }

    @Then("User is able to login in the application")
    public void user_is_able_to_login_in_the_application() {
        Assert.assertEquals("ParaBank | Accounts Overview", testContext.getDriver().getTitle());
        boolean actualTableDisplayed = testContext.getDriver().findElement(By.id("accountTable")).isDisplayed();
        Assert.assertEquals(true, actualTableDisplayed);

    }

    ;
    // Transfer Funds

    @Given("User is logged in")
    public void user_is_logged_in() {
        user_opened_the_browser();
        user_navigated_to_the_application_url();
        user_enter_username_as_and_password_as_and_click_on_login_button(userName, password);

    }

    @Given("User clicks on Transfer Funds link")
    public void user_clicks_on_transfer_funds_link() {
        testContext.getDriver().findElement(By.xpath("//a[text()='Transfer Funds']")).click();
        //driver.findElement(By.xpath("//a[text()='Transfer Funds']")).click();
    }

    @Then("User is navigated to {string} page")
    public void user_is_navigated_to_page(String string) {
        Assert.assertEquals(testContext.getDriver().getTitle(), string);
    }


    //Datbase Record
    @Given("I want to do something")
    public void i_want_to_do_something() {

    }
    @When("I have a arguments to send as {string}")
    public void i_have_a_arguments_to_send_as(String arg) {
        System.out.println("Printing the arguments: " + arg);
    }
    @Then("something should happen")
    public void something_should_happen() {

    }
    @When("I have a list of item to send")
    public void i_have_a_list_of_item_to_send(List<String> list) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println("Akash: "+ list.toString());
    }
    @When("I have students and their marks")
    public void i_have_students_and_their_marks(Map<String, String> map) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println(map);
    }

   // Time steps

    @Given("I am on the search page")
    public void i_am_on_the_search_page() {

    }
    @When("I search for a product as {string}")
    public void i_search_for_a_product_as(String string) {
        System.out.println("Product searched: " + string);
    }

    @Then("result should be displayed related to {string}")
    public void result_should_be_displayed_related_to(String string) {
        System.out.println("Product searched success: " + string);
    }






}




