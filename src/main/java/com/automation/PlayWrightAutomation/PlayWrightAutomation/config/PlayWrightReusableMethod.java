package com.automation.PlayWrightAutomation.PlayWrightAutomation.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

public interface PlayWrightReusableMethod {

    void close();

    void setPlayWrightBrowser(String browserType, BrowserType.LaunchOptions launchOptions);

    void setPlayWrightBrowserContext();

    void setPlayWrightPage();

    Browser getPlayWrightBrowser();

    BrowserContext getPlayWrightBrowserContext();

    Page getPlayWrightPage();




}
