package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables {

    private WebDriver driver;

    //Locators declared as private final. This means they can't be accidentally modified.
    private final By addButton = By.id("addNewRecordButton");

    //Registration form locators
    private final By firstNameRegForm = By.id("firstName");
    private final By lastNameRegForm = By.id("lastName");
    private final By emailRegForm = By.id("userEmail");
    private final By ageRegForm = By.id("age");
    private final By salaryRegForm = By.id("salary");
    private final By departmentForm = By.id("department");
    private final By submitButtonRegForm = By.id("submit");
    private final By filledRows = By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']");

    //Constructor
    public WebTables(WebDriver driver){
        this.driver=driver;
    }

    //Methods
    public void clickOnAddButton(){
        driver.findElement(addButton).click();
    }
    public void addNewEntryInRegFormAndClickOnSubmit(String firstName,String lastName, String email, Integer age, Integer salary, String department){
        driver.findElement(firstNameRegForm).sendKeys(firstName);
        driver.findElement(lastNameRegForm).sendKeys(lastName);
        driver.findElement(emailRegForm).sendKeys(email);
        driver.findElement(ageRegForm).sendKeys(age.toString());
        driver.findElement(salaryRegForm).sendKeys(salary.toString());
        driver.findElement(departmentForm).sendKeys(department);
        driver.findElement(submitButtonRegForm).click();
    }

    public int nrOfFilledRowsFromTable(){
        List<WebElement> filledRowList = driver.findElements(filledRows);
        return filledRowList.size();
    }

    public String getRowNrValues(int index){
        return driver.findElements(filledRows).get(index).getText();
    }
}
