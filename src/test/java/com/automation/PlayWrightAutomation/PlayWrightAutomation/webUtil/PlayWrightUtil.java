package com.automation.PlayWrightAutomation.PlayWrightAutomation.webUtil;


import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import com.automation.PlayWrightAutomation.PlayWrightAutomation.utility.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayWrightUtil{
  @Autowired
   PlayWrightReusableMethod playWrightReusableMethod;
    public void navigate()
    {
        this.playWrightReusableMethod.getPlayWrightPage().navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void fill(Locator locator,String locatorValue, String valueToEnter)
    {
        switch(locator.name())
        {
            case "GET_BY_PLACEHOLDER" :
                this.playWrightReusableMethod.getPlayWrightPage().getByPlaceholder(locatorValue).fill(valueToEnter);
                break;
            case "GET_BY_TEXT" :
                this.playWrightReusableMethod.getPlayWrightPage().getByText(locatorValue).fill(valueToEnter);
                break;
            case "GET_BY_ROLE" :
                this.playWrightReusableMethod.getPlayWrightPage().getByRole(AriaRole.HEADING,
                        new Page.GetByRoleOptions().setName(locatorValue)).fill(valueToEnter);
                break;
            case "XPATH" :
                this.playWrightReusableMethod.getPlayWrightPage().locator(locatorValue).fill(valueToEnter);
                break;
            default:

        }

    }

    public void click(Locator locator, String locatorValue) {

        switch(locator.name())
        {
            case "GET_BY_PLACEHOLDER" :
                this.playWrightReusableMethod.getPlayWrightPage().getByPlaceholder(locatorValue).click();
                break;
            case "GET_BY_TEXT" :
                this.playWrightReusableMethod.getPlayWrightPage().getByText(locatorValue).click();
                break;
            case "GET_BY_ROLE" :
                this.playWrightReusableMethod.getPlayWrightPage().getByRole(AriaRole.HEADING,
                        new Page.GetByRoleOptions().setName(locatorValue)).click();
                break;
            case "XPATH" :
                this.playWrightReusableMethod.getPlayWrightPage().locator(locatorValue).click();
                break;
            default:

        }
    }
    public boolean validation(Locator locator, String locatorValue) {

        switch(locator.name())
        {
            case "GET_BY_PLACEHOLDER" :
               return this.playWrightReusableMethod.getPlayWrightPage().getByPlaceholder(locatorValue).isVisible();
            case "GET_BY_TEXT" :
                return this.playWrightReusableMethod.getPlayWrightPage().getByText(locatorValue).isVisible();
            case "GET_BY_ROLE" :
                return this.playWrightReusableMethod.getPlayWrightPage().getByRole(AriaRole.HEADING,
                        new Page.GetByRoleOptions().setName(locatorValue)).isVisible();
            case "XPATH" :
                return  this.playWrightReusableMethod.getPlayWrightPage().locator(locatorValue).isVisible();
            default:
                return false;

        }
    }

}
