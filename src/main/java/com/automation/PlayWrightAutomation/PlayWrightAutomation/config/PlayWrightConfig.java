package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.LazyConfiguration;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.ThreadScopeBean;
import com.microsoft.playwright.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class PlayWrightConfig {

    private final BrowserConfig browser;

  /*  @ThreadScopeBean
    @ConditionalOnProperty(name = "Browser.name", havingValue = "chrome")
    public BrowserContext init(){
       log.info("Starting playwright ");

       return playWright.chromium().launch(new BrowserType.LaunchOptions()
               .setHeadless(browser.getHeadlessFlag())
               .setArgs(Collections.singletonList("--start-maximize"))).newContext(new Browser.NewContextOptions().setViewportSize(null));
    }*/


    @Bean(name="PlayWrightBrowser", destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PlayWrightReusableMethod init(){
        log.info("Starting playwright ");

        return new PlayWrightReusableMethodImpl(browser.getBrowserName(), new BrowserType.LaunchOptions()
                .setHeadless(browser.getHeadlessFlag()));
    }
}
