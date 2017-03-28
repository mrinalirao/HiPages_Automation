package com.hipages.pages;

import com.hipages.config.Setup;
import com.hipages.core.PageObject;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by mrinalirao on 28/03/17.
 *
 * This is the HomePage class
 */
public class HomePage extends PageObject {


    public String pageName;
    By topArboristCards = By.className("basic-listing");

    public void loadHomePage(){
        driver.get(Setup.baseUrl);
    }

    public void getMaxPageReccomendations() {

        int maxCount=0;

        List<WebElement> list = driver.findElements(topArboristCards);
        for (WebElement ele : list) {

            WebElement name = ele.findElement(By.xpath(".//a[@class='basic-listing__title']"));

            //Check if Page has reccomendations
             Boolean isPresent =  ele.findElements(By.xpath(".//a[@class='basic-listing__recommendation-count']")).size() > 0;

             if (isPresent) {
                 WebElement count = ele.findElement(By.xpath(".//a[@class='basic-listing__recommendation-count']"));
                 String num = count.getText();
                 num = num.substring(0,num.indexOf(' '));
                 int maxNum = Integer.parseInt(num);
                 if(maxNum>maxCount){
                     maxCount=maxNum;
                     pageName = name.getText();
                 }
             }
        }

        System.out.println(maxCount+ " Recommendations for Page ::: " + pageName);

    }


}
