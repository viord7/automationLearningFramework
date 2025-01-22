package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements;
import pages.LandingPage;
import pages.WebTables;

public class WebTableTest extends BaseTest {

    private LandingPage landingPage;
    private Elements elementsPage;
    private WebTables webTables;

    @BeforeMethod
    public void setUp(){
        // Ensure the BaseTest setUp() is executed
        super.setUp();
        landingPage=new LandingPage(driver);
        elementsPage=new Elements(driver);
        webTables=new WebTables(driver);

    }

    @Test
    public void verifyUserCanAddEntriesInWebTables(){
        landingPage.clickOnElements();
        elementsPage.clickOnWebTables();
        webTables.clickOnAddButton();
        webTables.addNewEntryInRegFormAndClickOnSubmit("John", "Doe", "john.doe@test.com", 32,1200, "Testing");
    }
}
