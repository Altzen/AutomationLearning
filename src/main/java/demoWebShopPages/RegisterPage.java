package demoWebShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GlobalNavigation {

    private final String GENDER_MALE = "#gender-male";
    private final String FIRST_NAME = "#FirstName";
    private final String LAST_NAME = "#LastName";
    private final String EMAIL = "#Email";
    private final String PASSWORD = "#Password";
    private final String CONFIRM_PASSWORD = "#ConfirmPassword";
    private final String REGISTER_BUTTON = "#register-button";
    private final String RESULT_TEXT = ".registration-result-page .result";

    private WebElement genderMale;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement eMail;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement registerButton;
    private WebElement resultText;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void initElements() {
        genderMale = driver.findElement(By.cssSelector(GENDER_MALE));
        firstName = driver.findElement(By.cssSelector(FIRST_NAME));
        lastName = driver.findElement(By.cssSelector(LAST_NAME));
        eMail = driver.findElement(By.cssSelector(EMAIL));
        password = driver.findElement(By.cssSelector(PASSWORD));
        confirmPassword = driver.findElement(By.cssSelector(CONFIRM_PASSWORD));
        registerButton = driver.findElement(By.cssSelector(REGISTER_BUTTON));

    }
    public void initResultElements(){
        this.waitForSelectedElementToBeVisible(driver,RESULT_TEXT,10);
        resultText = driver.findElement(By.cssSelector(RESULT_TEXT));
    }

    public WebElement getGenderMale() {
        return genderMale;
    }
    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEMail() {
        return eMail;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }
    public WebElement getRegisterButton(){
        return registerButton;
    }

    public WebElement getResultText() {
        return resultText;
    }

}
