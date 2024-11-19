package com.automation.PlayWrightAutomation.PlayWrightAutomation;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class BaseOperation  {



}
