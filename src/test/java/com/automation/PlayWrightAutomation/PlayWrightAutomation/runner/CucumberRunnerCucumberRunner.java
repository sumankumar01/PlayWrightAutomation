package com.automation.PlayWrightAutomation.PlayWrightAutomation.runner;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.LazyAutowired;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.automation.PlayWrightAutomation.PlayWrightAutomation.bdd",
        //tags =  "@smoke",
        plugin = {
                "pretty",
                "html:target/index.html"
        }
)

public class CucumberRunnerCucumberRunner extends AbstractTestNGCucumberTests {

    public static ExtentTest test;
    public static ExtentReports report;
    public static ExtentTest node;

    static{
        report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Report/ExtantReport.html");
        htmlReporter.config().setReportName("Extent Report for playWright");
        report.attachReporter(htmlReporter);
    }


    @AfterSuite
    public void afterSuite(){
        report.flush();
    }


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
