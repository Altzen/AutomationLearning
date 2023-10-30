package demoWebShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GlobalNavigation {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final String EMAIL = "#Email";
    private final String PASSWORD = "#Password";
    private final String LOG_IN_BUTTON = ".login-button";


    private WebElement eMail;
    private WebElement password;
    private WebElement logInButton;

    public void initLoginElements() {
        this.waitForSelectedElementToBeVisible(driver, EMAIL, 5);
        eMail = driver.findElement(By.cssSelector(EMAIL));
        password = driver.findElement(By.cssSelector(PASSWORD));
        logInButton = driver.findElement(By.cssSelector(LOG_IN_BUTTON));
    }

    public WebElement getEMail() {
        return eMail;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogInButton(){
        return logInButton;
    }
}
