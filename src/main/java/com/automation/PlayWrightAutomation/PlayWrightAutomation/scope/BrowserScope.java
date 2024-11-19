package com.automation.PlayWrightAutomation.PlayWrightAutomation.scope;

import com.automation.PlayWrightAutomation.PlayWrightAutomation.config.PlayWrightReusableMethod;
import com.microsoft.playwright.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object o = super.get(name, objectFactory);

        Object sessionId = null;

        if(o.getClass().getTypeName().toString().contains("Page"))
        {
             sessionId = ((Page)o).context().pages().get(0);
        }
        else if(o.getClass().getTypeName().toString().contains("Browser"))
        {
             sessionId = ((BrowserContext)o).browser().contexts().get(0);
        }
        else {
             sessionId = ((PlayWrightReusableMethod)o).getPlayWrightBrowser();
        }

        if(Objects.isNull(sessionId)){
            super.remove(name);
            o = super.get(name, objectFactory);
        }
        return o;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }
}
