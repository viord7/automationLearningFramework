package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class WebTableTest extends BaseTest {

    private LandingPage landingPage;

    @BeforeMethod
    public void setUp(){
        // Ensure the BaseTest setUp() is executed
        super.setUp();
        landingPage=new LandingPage(driver);
    }

    @Test
    public void automationMethod(){

        landingPage.clickOnElements();
        WebElement webTableLocator=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTableLocator.click();
    }
}
