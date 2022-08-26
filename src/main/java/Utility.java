import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

 /*
    Note to reader: this was made quickly, for job application for Estee Lauder
    -Author : Mohammed Rahman
            - the utlities here are some of the tools i used to maneuvar the website
            - note : a lot of the links take extra time to load, perhaps this is a work in progress
            - there are popup links appearing constantly on the webpage, which delays automation
            i created different methods to bypass such concerns, but in the end a
             try catch worked the best, where i catch the link and use .click to close the elmenet
*/

public class Utility {
    WebDriver driver;
    public Object Utility;



    @BeforeClass
    public void testSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        Dimension dem = new Dimension(1350, 850);
        driver.manage().window().setSize(dem);
    }


    public void tryHover(String e){
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath(e));
        actions.moveToElement(menuOption).perform();
//        System.out.println("Done Mouse hover on 'Music' from Menu");
    }

    public void SrollDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void holdYourHorses(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception InterruptedException){
            System.out.println("Thread exception");
        }
    }
}