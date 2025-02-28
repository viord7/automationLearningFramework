package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Interactions {

    private WebDriver driver;

    //Constructor
    public Interactions(WebDriver driver){
        this.driver=driver;
    }

    //Locators
    private final By sortableMenu = By.xpath("//span[text()='Sortable']");
    private final By sortableList = By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']");

    //Methods
    public void clickOnSortable(){
        driver.findElement(sortableMenu).click();
        Select select;
    }

    public void getElementsFromList(){
        String [] listValues = new String[6];
        for(int i=0;i<6;i++){
            listValues[i]=driver.findElements(sortableList).get(i).getText();
            System.out.println(listValues[i]);
        }
    }

    public List<String> getElementsText(){
        List<WebElement> listWebElements = driver.findElements(sortableList);
        List<String> textsList = new ArrayList<>();
        for(int var=0;var<listWebElements.size();var++){// can be replaced with  for (WebElement element : listWebElements)
            textsList.add(listWebElements.get(var).getText());
        }
        return textsList;
        }

    public void switchingElements(){
        List<WebElement> list = driver.findElements(sortableList);
        Actions actions = new Actions(driver);
        WebElement currentElement;
        WebElement nextElement;
        for(int var=0;var<list.size();var++){
        currentElement=list.get(var);
        nextElement=list.get(var+1);
        actions.clickAndHold(currentElement).moveToElement(nextElement).release().build().perform();
        }
    }
}


