import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;


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

    @Test(priority = 0)
    public  void LoginPage() {
        String baseUrl = "https://www.esteelauder.com/";
        clickbyXpath(SignInButton);
        SendKeysId(EmailBoxID, "mohammedb.rahman2018@gmail.com");
        SendKeysId(PasswordBoxId, "random1234");
        clickbyXpath(SignUppath);
        SendKEYSxpath(EmailBoxPostFailurePath , "mohammedb.rahman2018@gmail.com");
    }


    @Test(priority = 1)
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