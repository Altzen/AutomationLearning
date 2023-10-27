package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Runner {

    public WebDriver runChrome() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    public WebDriver runFireFox() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        return driver;


    }
}
