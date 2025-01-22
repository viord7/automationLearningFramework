package base;

import config.ConfigLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
To set up and tear down WebDriver
 */
public class BaseTest {

    protected WebDriver driver;

     /*
    Executes once before any test methods in the class.
    Initializes the WebDriver instance.
     */
    @BeforeClass
    public void setUp(){
     driver=new ChromeDriver();
     String baseUrl = ConfigLoader.getProperty("URL");
     if (baseUrl==null || baseUrl.isEmpty()){
         throw new IllegalArgumentException("Base url is not configured");
     }
     driver.get(baseUrl);
     System.out.println("The driver is " + driver.toString());
     driver.manage().window().maximize();

     //Scrolling
     JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
    }

    /*
    Executes once after all test methods in the class.
    Cleans up and quits the WebDriver instance.
     */
    @AfterClass
    public void tearDown(){
     //   driver.quit();
    }

}
