package com.automation.PlayWrightAutomation.PlayWrightAutomation.annotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Bean(name="PlayWrightBrowser", destroyMethod = "close")
@Scope("browserscope")
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadScopeBean {
}
