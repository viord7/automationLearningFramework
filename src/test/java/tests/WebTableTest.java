package tests;

import base.BaseTest;
import org.testng.Assert;
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

        //Verify the number of existing entries in table(3)
        Assert.assertEquals(webTables.nrOfFilledRowsFromTable(),3);
        webTables.clickOnAddButton();
        webTables.addNewEntryInRegFormAndClickOnSubmit("John", "Doe", "john.doe@test.com", 32,1200, "Testing");

        //Verify the number of existing entries in table was increased to 4 after adding a new entry
        Assert.assertEquals(webTables.nrOfFilledRowsFromTable(),4);

        //Verify the values entered by the user(last row)
        Assert.assertEquals(webTables.getRowNrValues(webTables.nrOfFilledRowsFromTable()-1),"John\n" +
                "Doe\n" +
                "32\n" +
                "john.doe@test.com\n" +
                "1200\n" +
                "Testing");
        /*
        Instead of only one check and assertEquals we can use assertTrue
        e.g. Assert.assertTrue(webTables.getRowNrValues(index).contains("John"))
        Assert.assertTrue(webTables.getRowNrValues(webTables.nrOfFilledRowsFromTable()-1).contains("John"));

         */
    }
}
