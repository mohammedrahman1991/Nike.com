import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;


public class Test1 {
    WebDriver driver;
    public Object Utility;

    @BeforeClass
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver", "/Users/mohammedrahman/Downloads/chromedriver 3");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        // Dimension class with browser width and height value passed
        Dimension dem = new Dimension(1350, 850);
        // passing the Dimension object as an argument to setSize method
        driver.manage().window().setSize(dem);
    }
//    @Test
    //This test works
//            public void validateURLv2(){
//
//            String baseUrl = "https://www.esteelauder.com/products/19239/product-catalog/last-chance";
//            String expectedTitle = "Last Chance Beauty Products | Estée Lauder";
//            String actualTitle = "";
//            driver.get(baseUrl);
//
//            // get the actual value of the title
//            actualTitle = driver.getTitle();
//            System.out.println(actualTitle);
//
//            /*
//             * compare the actual title of the page with the expected one and print
//             * the result as "Passed" or "Failed"
//             */
//            if (actualTitle.contentEquals(expectedTitle)){
//                System.out.println("Test Passed!");
//            } else {
//                System.out.println("Test Failed");
//            }
//            Assert.assertEquals(actualTitle,expectedTitle);
//    }
    @Test
    public void validateAddtoCart() throws AWTException, InterruptedException {
        String baseUrl = "https://www.esteelauder.com/product/26389/2650/product-catalog/skinca" +
               "re/toner-treatment-lotion/perfectly-clean/fresh-balancing-lotion?size=13.5_oz.";
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='gnav-signup-" +
                "overlay__close js-gnav-signup-overlay-close']")).click();
//        Robot robot = new Robot();
//        robot.mouseMove(1228, 227); // move mouse point to specific location
////        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step
//        // first click
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        // second click
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        robot.delay(1500);
//        // not working so itried a different method

//        Utility = new Utility("//button[@title='Add To Bag']");
//        ScrollDownUp();
        driver.findElement(By.xpath("//button[@title='Add To Bag']")).click();


        Thread.sleep(5000);
        driver.findElement(By.xpath(("//span[@class='utility-nav__cart-icon']"))).click();
    }

    private void ScrollDownUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();
    }

    @AfterMethod
    public void postSignUp() {
        System.out.println(driver.getCurrentUrl());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}






