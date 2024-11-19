package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
@Data
public class BrowserConfig {

    @org.springframework.beans.factory.annotation.Value("${Browser.name}")
    String browserName;
    @Value("${Browser.headless}")
    Boolean headlessFlag;
}
