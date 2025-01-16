package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements {

    private WebDriver driver;

    //Locators declared as private final. This means they can't be accidentally modified.
     private final By webTablesElement = By.xpath("//span[text()='Web Tables']");

    //Constructor
    public Elements(WebDriver driver){
        this.driver=driver;
    }

    //Methods

    public void clickOnWebTables(){
        driver.findElement(webTablesElement).click();
    }



}
