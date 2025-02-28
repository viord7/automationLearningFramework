package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Forms;
import pages.LandingPage;

public class FormsTest extends BaseTest {

    private LandingPage landingPage;
    private Forms formsPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        landingPage= new LandingPage(driver);
        formsPage = new Forms(driver);
    }

    @Test
    public void verifyFormsPage(){
        landingPage.clickOnForms();
        formsPage.clickOnPracticeForm();
        formsPage.addANewEntryInStudentRegForm("John", "Doe", "John.Doe@test.com", "1234567891", "src/test/resources/aiStudent.jpg", "Male", "Social", "Street:  662 Raintree Boulevard", "NCR", "Noida");
        formsPage.clickOnSubmitButton();
        formsPage.clickOnCloseButton();
    }

}
