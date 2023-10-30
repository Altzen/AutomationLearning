package uiTesting.testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Runner {

    public WebDriver runChrome() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    public WebDriver runFireFox() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        return driver;


    }
}
