package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private WebDriver driver;


    //Locators declared as private final. This means they can't be accidentally modified.
    private final By elements= By.xpath("//h5[text()='Elements']");

    //Constructor
    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    //Methods
    public void clickOnElements(){
        driver.findElement(elements).click();
    }
}
