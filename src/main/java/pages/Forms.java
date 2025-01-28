package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

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

    private final By genderMaleRadioButton = By.xpath("//label[@for='gender-radio-1']");
    private final By genderFemaleRadioButton = By.xpath("//label[@for='gender-radio-2']");
    private final By genderOtherRadioButton = By.xpath("//label[@for='gender-radio-3']");

    /*
    If we do not have id & class defined for this element we could use CSS
    Id option:

    private final By mobileNumber=By.id("userNumber");

    The Css doesn't need // as Xpath, you will just have to start with the first tag
    tag[nameOfTheAttribute='valueOfTheAttribute']
     */
    private final By mobileNumberForm = By.cssSelector("input[placeholder='Mobile Number']");

    private final By uploadPictureForm = By.id("uploadPicture");

    //Methods
    public void clickOnPracticeForm() {
        driver.findElement(practiceForm).click();
    }

    public void addANewEntryInStudentRegForm(String firstName, String lastName, String email, String mobileNumber, String pathToFile, Character gender) {
        driver.findElement(firstNameForm).sendKeys(firstName);
        driver.findElement(lastNameForm).sendKeys(lastName);
        driver.findElement(emailForm).sendKeys(email);
        if (gender == 'M') {
            driver.findElement(genderMaleRadioButton).click();
        } else if (gender == 'F') {
            driver.findElement(genderFemaleRadioButton).click();
        } else {
            driver.findElement(genderOtherRadioButton).click();
        }
        driver.findElement(mobileNumberForm).sendKeys(mobileNumber);
        File file = new File(pathToFile);
        driver.findElement(uploadPictureForm).sendKeys(file.getAbsolutePath());
    }
}
