package pages;

import org.openqa.selenium.*;

import java.io.File;
import java.security.Key;

public class Forms {

    private WebDriver driver;

    //Constructors
    public Forms(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By practiceForm = By.xpath("//span[text()='Practice Form']");
    private final By firstNameForm = By.id("firstName");
    private final By lastNameForm = By.id("lastName");
    private final By emailForm = By.id("userEmail");

    //<label title="" for="gender-radio-1" class="custom-control-label">Male</label>
    // We cannot use the id

    //I cannot declare the variables as WebElement since the driver is null when the app is calling the class constructor from the setUp method(FormsTest class)
private final By genderMaleRadioButton = By.xpath("//label[@for='gender-radio-1']");
private final By genderFemaleRadioButton =By.xpath("//label[@for='gender-radio-2']");
private final By genderOtherRadioButton = By.xpath("//label[@for='gender-radio-3']");

//We have to search the input under the html classes and use that one to add your input
private final By subjectsInput = By.id("subjectsInput");

    /*
    If we do not have id & class defined for this element we could use CSS
    id option:

    private final By mobileNumber=By.id("userNumber");

    The Css doesn't need // as Xpath, you will just have to start with the first tag
    tag[nameOfTheAttribute='valueOfTheAttribute']
     */
    private final By mobileNumberForm = By.cssSelector("input[placeholder='Mobile Number']");
    private final By uploadPictureForm = By.id("uploadPicture");
    private final By currentAddressForm = By.id("currentAddress");

    //If we use the Xpath we will be able to click on the box, but not to fill any input
    private final By stateAndCityForm = By.xpath("//div[text()='Select State']");
    private final By stateAndCityInput = By.id("react-select-3-input");
    private final By cityForm = By.id("react-select-4-input");
    private final By submitButton = By.id("submit");
    private final By closeButton = By.id("closeLargeModal");



    //Methods
    public void clickOnPracticeForm() {
        driver.findElement(practiceForm).click();
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void clickOnCloseButton(){
        driver.findElement(closeButton).click();
    }

    public void addANewEntryInStudentRegForm(String firstName, String lastName, String email, String mobileNumber, String pathToFile, String gender, String subjects, String currentAddress, String state, String city) {
        driver.findElement(firstNameForm).sendKeys(firstName);
        driver.findElement(lastNameForm).sendKeys(lastName);
        driver.findElement(emailForm).sendKeys(email);
       if (driver.findElement(genderMaleRadioButton).getText().equals(gender)) {
            driver.findElement(genderMaleRadioButton).click();
        } else if (driver.findElement(genderFemaleRadioButton).getText().equals(gender)) {
            driver.findElement(genderFemaleRadioButton).click();
        } else {
            driver.findElement(genderOtherRadioButton).click();
        }
        driver.findElement(mobileNumberForm).sendKeys(mobileNumber);
        File file = new File(pathToFile);
        driver.findElement(uploadPictureForm).sendKeys(file.getAbsolutePath());
        driver.findElement(subjectsInput).sendKeys(subjects);// if I will append  + "\n" it will simulate an enter at the form level
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
        driver.findElement(currentAddressForm).sendKeys(currentAddress);

        /*
        driver.findElement(stateAndCityInput).click();
        If I will try to click directly on the element due to the add we will receive the error:
        "element click intercepted: Element <input autocapitalize="none" autocomplete="off" autocorrect="off" id="react-select-3-input"
        To solve the issue we have to use the Javascript executor
         */
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        javaScriptExecutor.executeScript("arguments[0].click();",driver.findElement(stateAndCityInput));
        driver.findElement(stateAndCityInput).sendKeys(state);
        driver.findElement(stateAndCityInput).sendKeys(Keys.ENTER);

        javaScriptExecutor.executeScript("arguments[0].click();",driver.findElement(cityForm));
        driver.findElement(cityForm).sendKeys(city);
        driver.findElement(cityForm).sendKeys(Keys.ENTER);
    }
}
