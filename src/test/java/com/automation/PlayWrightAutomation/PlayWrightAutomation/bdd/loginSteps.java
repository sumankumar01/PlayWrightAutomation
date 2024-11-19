package com.automation.PlayWrightAutomation.PlayWrightAutomation.bdd;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.BaseOperation;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.util.Utility;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.webUtil.PlayWrightUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.testng.Assert;

import static com.automation.PlayWrightAutomation.PlayWrightAutomation.utility.Locator.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@CucumberContextConfiguration
@SpringBootTest
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class loginSteps {

    @Autowired
    PlayWrightUtil playWrightUtil;

    @Given("I am on the orangehrm sites")
    public void iAmOnTheOrangehrmSites() {

        System.out.println("Thread.."+Thread.currentThread().getName());
        this.playWrightUtil.navigate();
    }

    @When("I enter {string} as a userName to login")
    public void iEnterAsAUserNameToLogin(String arg0) {
        this.playWrightUtil.fill(GET_BY_PLACEHOLDER, "Username",arg0);
    }

    @When("I enter {string} as a password to login")
    public void iEnterAsAPasswordToLogin(String arg0) {
        this.playWrightUtil.fill(GET_BY_PLACEHOLDER,"Password", arg0);
        this.playWrightUtil.click(XPATH, "//button[@type='submit']");
    }

    @Then("I verify home page")
    public void iVerifyHomePage() throws InterruptedException {
        Thread.sleep(1000);
       Assert.assertTrue(this.playWrightUtil.validation(GET_BY_TEXT,"Time at Work"));
    }

    @Then("I verify login error msg")
    public void iVerifyLoginErrorMsg() {
        Assert.assertFalse(this.playWrightUtil.validation(GET_BY_TEXT,"Invalid credentials"));
    }
}
