package com.automation.PlayWrightAutomation.PlayWrightAutomation.bdd;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.LazyAutowired;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.CompletableFuture;

import static com.automation.PlayWrightAutomation.PlayWrightAutomation.runner.CucumberRunnerCucumberRunner.*;

public class CucumberHooks {
    /*static ExtentTest test;
    static ExtentReports report;

    ExtentTest node;

    static{
        report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Report/ExtantReport.html");
        htmlReporter.config().setReportName("Extent Report for playWright");
        report.attachReporter(htmlReporter);
    }*/

    @Before
    public void beforeScenario(Scenario scenario){
        test = report.createTest(scenario.getName());
        node=test.createNode("step...");
        node.pass("successfull");
    }
    @BeforeStep
    public void beforeStep(Scenario scenario){
        node=test.createNode("step...");
        node.pass("successfull");


      /*  if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
            //scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }*/
    }

    @AfterStep
    public void afterStep(Scenario scenario){
      /*  if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
            //scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }*/
    }

    @After
    public void afterScenario(){
       // this.applicationContext.getBean(PlayWrightReusableMethod.class).close();
       /* CompletableFuture.runAsync(() ->
                page.close());
        browserContext.close();
        playWright.close();*/

    }



}
