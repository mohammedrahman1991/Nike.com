import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ExmapleNike {
    WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver","/Users/mohammedrahman/Downloads/chromedriver 3");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void openBrowser() throws InterruptedException {
        driver.get("https://www.nike.com/");
        driver.findElement(By.xpath("(//a[@aria-label='Back to School'])[1]")).click();
        driver.findElement(By.xpath("//div[@id='adb8d968-f860-4916-93a4-9a6a45e2ca2f']//div//a[normalize-space()='Shop']")).click();
        // click on bag and add to cart
        // validate cart
        driver.findElement(By.xpath("(//img[contains(@alt,'Nike Hayward Backpack (26L)')])[1]")).click();
        Thread.sleep(2000);
        // add to bag
//        driver.findElement(By.cssSelector("button[aria-label='Add to Bag']")).click();
        // go to cart
//      driver.findElement(By.xpath("//span[@class='pre-jewel pre-cart-jewel text-color-primary-dark']")).click();
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

//    @Test(description="This method validates the add to cart/bag functionality")
//    public void signUp()
//    {
//        driver.findElement(By.id("user_full_name")).sendKeys("user_name");
//        driver.findElement(By.id("user_email_login")).sendKeys("email_id");
//        driver.findElement(By.id("user_password")).sendKeys("password");
//        driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
//        driver.findElement(By.id("user_submit")).click();

    //}

    @AfterMethod
    public void postSignUp()
    {
        System.out.println(driver.getCurrentUrl());

    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }





}
