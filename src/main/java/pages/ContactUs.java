package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs extends GlobalNavigation {

    public ContactUs(WebDriver driver){
        super(driver);
//        initElements();
    }


    private WebElement reason;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement eMail;
    private WebElement phone;
    private WebElement location;
    private WebElement howDidHear;
    private WebElement policyCheckbox;



}
