package com.hipages.tests;

import com.hipages.pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by mrinalirao on 28/03/17.
 */
public class UITest {

    HomePage homePage = new HomePage();

    @Test
    public void getMaxRecommendationPage(){
        homePage.loadHomePage();

        homePage.getMaxPageReccomendations();
    }
}
