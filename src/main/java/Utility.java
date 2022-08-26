import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends Test1{

    public Utility(String s) {

        super();
    }

    public void Actionsclass(String e){
        Actions actions = new Actions(driver);

        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath(e));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Music' from Menu");

    }
    public void SrollDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }
}
