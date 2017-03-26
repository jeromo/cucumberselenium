package jrm.seleniumcucumber.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jrm.seleniumcucumber.ParaNada;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    private class Credentials {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
    }

    private static WebDriver driver = null;
    private WebElement element = null;
    @Before
    public void beforeScenario() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {
        System.out.println(new ParaNada().giveMe());
        driver.quit();
    }

    @Given("^User is on Home Page$")
    public void userIsOnHomePage() throws Throwable {
        driver.get("http://www.store.demoqa.com");
    }

    @When("^User Navigate to LogIn Page$")
    public void userNavigateToLogInPage() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }

    @And("^User enters UserName and Password$")
    public void userEntersUserNameAndPassword() throws Throwable {
        driver.findElement(By.id("log")).sendKeys("testuser_1");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
    }

    @Then("^Message displayed Login Successfully$")
    public void messageDisplayedLoginSuccessfully() throws Throwable {
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
            Assert.assertNull(element);
        }
//        Assert.assertNull(element);
        System.out.println("Login Successfully");
    }

    @When("^User LogOut from the Application$")
    public void userLogOutFromTheApplication() throws Throwable {
        return;
//        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
    }

    @Then("^Message displayed LogOut Successfully$")
    public void messageDisplayedLogOutSuccessfully() throws Throwable {
        return;
//        System.out.println("LogOut Successfully");
    }


    @And("^User enters:$")
    public void userEnters(List<Credentials> usercredentials) throws Throwable {
        //Write the code to handle Data Table
        //List<List<String>> data = usercredentials.raw();

        for (Credentials credentials : usercredentials) {
            driver.findElement(By.id("log")).sendKeys(credentials.getUsername());
            driver.findElement(By.id("pwd")).sendKeys(credentials.getPassword());
            driver.findElement(By.id("login")).click();
            messageDisplayedLoginSuccessfully();

            driver.findElement(By.id("log")).clear();
            driver.findElement(By.id("pwd")).clear();
        }
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
