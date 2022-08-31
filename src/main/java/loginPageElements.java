import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginPageElements extends Utility{


        String BaseUrl = "https://www.esteelauder.com/";
        String SignInButton = "//span[contains(@class,'signin-text')]";
        String EmailBoxID = "form--signin--field--EMAIL_ADDRESS";
        String PasswordBoxId = "form--signin--field--PASSWORD";
        String SignUppath = "//a[contains(@class, 'sign-in-component__fpw')]";
        String EmailBoxPostFailurePath = "//input[@placeholder='* Email Address']";


}
