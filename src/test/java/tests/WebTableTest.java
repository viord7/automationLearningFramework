package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements;
import pages.LandingPage;

public class WebTableTest extends BaseTest {

    private LandingPage landingPage;
    private Elements elementsPage;

    @BeforeMethod
    public void setUp(){
        // Ensure the BaseTest setUp() is executed
        super.setUp();
        landingPage=new LandingPage(driver);
        elementsPage=new Elements(driver);

    }

    @Test
    public void verifyUserCanAddEntriesInWebTables(){
        landingPage.clickOnElements();
        elementsPage.clickOnWebTables();
    }
}
