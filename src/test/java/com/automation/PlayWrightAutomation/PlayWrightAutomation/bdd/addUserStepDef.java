package com.automation.PlayWrightAutomation.PlayWrightAutomation.bdd;


import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.webUtil.PlayWrightUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static com.automation.PlayWrightAutomation.PlayWrightAutomation.utility.Locator.XPATH;

@SpringBootTest
public class addUserStepDef {
    @Autowired
    loginSteps loginSteps;

    @Autowired
    private ApplicationContext ctx;
    private static final Logger logger = LoggerFactory.getLogger(addUserStepDef.class);
    @Given("the user tries to log in with the following accounts:")
    public void loginUser(DataTable table) {
        this.loginSteps.playWrightUtil.click(XPATH, "//a[span[text()='Admin']]");
        this.loginSteps.playWrightUtil.click(XPATH, "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
        List<List<String>> data = table.asLists(String.class);
        System.out.println(data.get(1).get(1));
      //  PlayWrightReusableMethod playWrightReusableMethod= this.ctx.getBean(PlayWrightReusableMethod.class);
    }

    @When("each user attempts to log in")
    public void eachUserAttemptsToLogIn() {
        
    }

    @Then("each user should access the system successfully")
    public void eachUserShouldAccessTheSystemSuccessfully() {
    }


}

