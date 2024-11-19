package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;

import com.microsoft.playwright.*;

public interface PlayWrightReusableMethod {

    void close();

    void setPlayWrightBrowser(String browserType, BrowserType.LaunchOptions launchOptions);

    void setPlayWrightBrowserContext();

    void setPlayWrightPage();

    Browser getPlayWrightBrowser();

    BrowserContext getPlayWrightBrowserContext();

    Page getPlayWrightPage();

    Playwright getPlayWright();




}
