package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.LazyConfiguration;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation.ThreadScopeBean;
import com.microsoft.playwright.*;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class PlayWrightConfig {

    private final BrowserConfig browser;
    PlayWrightReusableMethod playWrightReusableMethod;
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
        playWrightReusableMethod= new PlayWrightReusableMethodImpl(browser.getBrowserName(), new BrowserType.LaunchOptions()
                .setHeadless(browser.getHeadlessFlag()));
        return playWrightReusableMethod;
    }

    @PreDestroy
    public void close() {
        CompletableFuture.runAsync(() ->
                playWrightReusableMethod.getPlayWrightPage().close());
        playWrightReusableMethod.getPlayWrightBrowserContext().close();
        playWrightReusableMethod.getPlayWright().close();
    }
}
