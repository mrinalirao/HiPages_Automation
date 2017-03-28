package com.hipages.config;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by mrinalirao on 28/03/17.
 *
 * The Setup class initializes the driver and reads values from the properties file
 */
public class Setup {

private WebDriver driver;
public static Properties properties = new Properties();
public @Getter @Setter static String baseUrl;
public @Getter @Setter static String brows;

    @BeforeClass
    public static void readValues() {

        try{
            properties.load(new FileInputStream("src/main/java/com/hipages/config/properties/qa.properties"));
        } catch(IOException e){
            e.printStackTrace();
        }
        baseUrl = properties.getProperty("baseUrl");
        brows = properties.getProperty("brows");

    }


    public static DesiredCapabilities getChromeConfig(){

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setJavascriptEnabled(true);
        System.setProperty("webdriver.chrome.driver",properties.getProperty("driverPath"));
        return desiredCapabilities;

    }

    public enum Browser {
        CHROME, FIREFOX
    }

    public static WebDriver getWebDriverConfig() {
        readValues();
        brows = properties.getProperty("browser");
        WebDriver webDriver = null;
        Browser browser = Browser.valueOf(brows.toUpperCase(Locale.ENGLISH));
        switch (browser) {
            case CHROME: {
                webDriver = new ChromeDriver(getChromeConfig());
                break;
            }
            case FIREFOX: {
               // TODO: add implementation for firefox driver
            }
            default:
                return null;
        }
        return webDriver;
    }




}
