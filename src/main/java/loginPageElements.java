import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginPageElements extends Utility{


        String BaseUrl = "https://www.esteelauder.com/";
        String SignInButton = "//span[contains(@class,'signin-text')]";
        String EmailBoxID = "form--signin--field--EMAIL_ADDRESS";
        String LogoLink = "(//a[@class='page-branding__logo js-brand-logo-link'])[1]";
        String PasswordBoxId = "form--signin--field--PASSWORD";
        String SignUppath = "//a[contains(@class, 'sign-in-component__fpw')]";
        String FBloginDiscplaimer = ".return-user-disclaimer.js-return-user-disclaimer";
        String CustomerServicePhoneBoxText = "//p[contains(text(),'If you need help or would like to order by phone c')]";
        String EmailBoxPostFailurePath = "//input[@placeholder='* Email Address']";


}
