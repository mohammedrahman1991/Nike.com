import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;


public class Example2 {
        public static void main(String[] args) {
            // declaration and instantiation of objects/variables
//            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
//            WebDriver driver = new FirefoxDriver();
            //comment the above 2 lines and uncomment below 2 lines to use Chrome
            //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver","/Users/mohammedrahman/Downloads/chromedriver 3");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "https://www.esteelauder.com/products/19239/product-catalog/last-chance";
            String expectedTitle = "Last Chance Beauty Products | Estée Lauder";
            String actualTitle = "";

            // launch Fire fox and direct it to the Base URL
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // get the actual value of the title
            actualTitle = driver.getTitle();
            System.out.println(actualTitle);

            /*
             * compare the actual title of the page with the expected one and print
             * the result as "Passed" or "Failed"
             */
            if (actualTitle.contentEquals(expectedTitle)){
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed");
            }

            //close browser
            driver.close();

        }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite method");
    }
    @Test
    public void testMethod(){
        Assert.assertTrue(false);
    }
}






