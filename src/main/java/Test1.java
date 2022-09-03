import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

 /*
    Note to reader: this was made quickly, for job application for Estee Lauder
    -Author : Mohammed Rahman
            - this is the test page  that contains 2 tests.
            a. first validates URL
            b. goes to a specific item, and validates add to cart functionality
            - note : a lot of the links take extra time to load, perhaps this is a work in progress
            - also i did not create any other classes like the Base class as this was only for
            demonstrative purposes. I can certainly continue to build using this Page Object Model
*/


public class Test1 extends loginPageElements {

    /**
     * The above function is a test case that tests the login page of the website.
     * Then we click on ForgotPassword and Validate Customer Service Number is True or Not
     */
    @Test(priority = 0)
    public  void LoginPage() throws InterruptedException {
        String baseUrl = "https://www.esteelauder.com/";
        clickbyXpath(SignInButton);
        //--------------
        System.out.println("Asssertions for loginPage begins");
        Thread.sleep(2000);

        String Actual = driver.findElement(By.xpath(SignInButton)).getText();
        print1(Actual);

        Assert.assertEquals(Actual,"SIGN IN");
        print1("Sign In button text is valid /true = test passed ");
        Thread.sleep(2000);
        //--------------
        isShown(LogoLink);
        isShownID(EmailBoxID);
        isShownID(PasswordBoxId);
        isShown(SignInButton);


        SendKeysId(EmailBoxID, "mohammedb.rahman2018@gmail.com");
        SendKeysId(PasswordBoxId, "random1234");

        holdYourHorses(5);
        try{
            driver.findElement(By.xpath("//span[@class='drawer-formatter__close']")).click();
        }catch (Exception NoSuchElementException){
            System.out.println("Detected no pop up elem");
        }
        String ActualTextFB = driver.findElement(By.cssSelector(FBloginDiscplaimer)).getText();
        print1(ActualTextFB);

        Assert.assertEquals(ActualTextFB,"By clicking “Continue with Facebook\" " +
                "I agree to Estée Lauder’s Terms & Conditions and Privacy Policy.");
        print1("FB login disclaimer is Present  = test passed ");
        Thread.sleep(2000);

        clickbyXpath(SignUppath);
        SendKEYSxpath(EmailBoxPostFailurePath , "mohammedb.rahman2018@gmail.com");

        // Validate Correct Customer Service Phone
        ArrayList<String> PhoneNum = new ArrayList<>(Arrays.asList(driver.findElement(By.xpath(CustomerServicePhoneBoxText)).getText().split(" ")));
        // get number from splitting the text field from above element
        System.out.println("This is actual phoneNumber: "+ PhoneNum.get(15));
        String ActualPhoneNum = PhoneNum.get(15);
        Assert.assertEquals(ActualPhoneNum,"1.877.311.3883.");
        print1("Phone Number is Valid -Present : Test Passed");
       // ---------------
    }
    /**
     * This function will open a browser, navigate to a specific URL, click on a button, and then verify that the item was
     * added to the cart
     */
    @Test(priority = 0, enabled = false)
    public void validateAddtoCart() {
        String baseUrl = "https://www.esteelauder.com/product/684/25713/product-catalog/skincare/cleanser-makeup-remover/perfectly-clean/multi-action-foam-cleanserpurifying-mask?size=5.0_oz.";
        driver.get(baseUrl);
        holdYourHorses(5);
        try{
            driver.findElement(By.xpath("//button[@class='gnav-signup-" +
                    "overlay__close js-gnav-signup-overlay-close']")).click();
        }catch (Exception NoSuchElementException){
            System.out.println("Detected no pop up elem");
        }
        //get cost of item
        String itemCost = driver.findElement(By.xpath("(//h4[contains(.,'$')])[1]")).getText();
        itemCost = itemCost.replace("$","");
        Double itemCostDouble = Double.parseDouble(itemCost);

        String itemname = driver.findElement(By.xpath("//div[@class='elc-right-column-section js-right-column-section']//following-sibling::h4")).getText();
        driver.findElement(By.xpath("//button[@title='Add To Bag']")).click();
        holdYourHorses(5);
        driver.findElement(By.xpath(("//span[@class='utility-nav__cart-icon']"))).click();

        WebElement element = driver.findElement(By.xpath("//a[@class='cart-item__product-subname--text']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        holdYourHorses(5);

        //verify cart contain item and cost of item
        String cartItemName= element.getText().toLowerCase(Locale.ROOT);
        Assert.assertTrue(cartItemName.contains(itemname.toLowerCase(Locale.ROOT)));
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