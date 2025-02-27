package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Interactions;
import pages.LandingPage;

import java.util.List;

public class InteractionsTest extends BaseTest {

    private LandingPage landingPage;
    private Interactions interactions;
    private List<String> expectedTextForList= List.of("One", "Two","Three","Four","Five", "Six");

    @BeforeMethod
    public void setUp(){
        super.setUp();
        landingPage = new LandingPage(driver);
        interactions = new Interactions(driver);
    }

    @Test
    public void verifyInteractions(){
        landingPage.clickOnInteractions();
        interactions.clickOnSortable();

        //Get actual text from Interactions page
        List<String> actualValuesList=interactions.getElementsText();

        //Assertion
        Assert.assertEquals(actualValuesList, expectedTextForList, "Text values do not match!");
    }
}
