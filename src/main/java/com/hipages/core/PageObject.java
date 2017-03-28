package com.hipages.core;

import com.hipages.config.Setup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by mrinalirao on 28/03/17.
 *
 * The Page object class is extended by every Page class and can contain wrappers for common
 * Selenium commands
 */
public class PageObject extends Setup {

    protected WebDriver driver;
    JavascriptExecutor jsExecutor;

    public PageObject(){

        this.driver = getWebDriverConfig();
        jsExecutor = (JavascriptExecutor)driver;
        driver.manage().window().maximize();

    }

}
