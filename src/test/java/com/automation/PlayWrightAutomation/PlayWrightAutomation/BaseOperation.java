package com.automation.PlayWrightAutomation.PlayWrightAutomation;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;


public abstract class BaseOperation  {

    @Autowired
    protected PlayWrightReusableMethod playWrightReusableMethod;



}
