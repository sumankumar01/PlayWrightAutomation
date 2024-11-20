package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;

import com.microsoft.playwright.*;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class PlayWrightReusableMethodImpl implements PlayWrightReusableMethod {

    Playwright playWright= Playwright.create();
    Browser browser;

    BrowserContext browserContext;

    Page page;

    public PlayWrightReusableMethodImpl(String browser, BrowserType.LaunchOptions launchOption) {
        setPlayWrightBrowser(browser, launchOption);
    }

    @Override
    public void close() {
        CompletableFuture.runAsync(() ->
                page.close());
        browserContext.close();
        playWright.close();
    }

    @Override
    public void setPlayWrightBrowser(String browserType, BrowserType.LaunchOptions launchOptions) {

        if(browserType.equalsIgnoreCase("chrome"))

        {
            browser=playWright.chromium().launch(launchOptions
                    .setArgs(Collections.singletonList("--start-maximize")));
        }
        setPlayWrightBrowserContext();
         setPlayWrightPage();
    }

    @Override
    public void setPlayWrightBrowserContext() {
        browserContext= getPlayWrightBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
    }

    @Override
    public void setPlayWrightPage() {
     page =getPlayWrightBrowserContext().newPage();
    }

    @Override
    public Browser getPlayWrightBrowser() {
        return browser;
    }

    @Override
    public BrowserContext getPlayWrightBrowserContext() {
        return browserContext;
    }

    @Override
    public Page getPlayWrightPage() {
   return page;
    }

    @Override
    public Playwright getPlayWright() {
        return playWright;
    }


}
