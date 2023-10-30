package uiTesting.epamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs extends GlobalNavigation {

    private final String REASON_LIST = "div #_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_mail_subjects";
    private final String FIRST_NAME = "#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_first_name";
    private final String LAST_NAME = "#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_last_name";
    private final String EMAIL = "#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email";
    private final String PHONE = "#_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone";
    private final String LOCATION = ".location-fields .form-component__input span.select2-selection.select2-selection--single.validation-focus-target";
    private final String HOW_DID_HEAR = ".dropdown-list .form-component__input #_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_comment_how_hear_about";
    private final String POLICY_CHECK_BOX = "input[name='gdprConsent']";


    public ContactUs(WebDriver driver) {
        super(driver);
        initElements();
    }


    private WebElement reason;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement eMail;
    private WebElement phone;
    private WebElement location;
    private WebElement howDidHear;
    private WebElement policyCheckbox;

    private void initElements() {
        reason = driver.findElement(By.cssSelector(REASON_LIST));
        firstName = driver.findElement(By.cssSelector(FIRST_NAME));
        lastName = driver.findElement(By.cssSelector(LAST_NAME));
        eMail = driver.findElement(By.cssSelector(EMAIL));
        phone = driver.findElement(By.cssSelector(PHONE));
        location = driver.findElement(By.cssSelector(LOCATION));
        howDidHear = driver.findElement(By.cssSelector(HOW_DID_HEAR));
        policyCheckbox = driver.findElement(By.cssSelector(POLICY_CHECK_BOX));
    }


    public String getReasonSelector() {
        return REASON_LIST;
    }

    public String getFirstNameSelector() {
        return FIRST_NAME;
    }

    public String getLastNameSelector() {
        return LAST_NAME;
    }

    public String getEMailSelector() {
        return EMAIL;
    }

    public String getPhoneSelector() {
        return PHONE;
    }

    public String getLocationSelector() {
        return LOCATION;
    }

    public String getHowDidHearSelector() {
        return HOW_DID_HEAR;
    }

    public String getPolicyCheckBoxSelector() {
        return POLICY_CHECK_BOX;
    }

    public WebElement getReason() {
        return reason;
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

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getLocation() {
        return location;
    }

    public WebElement getHowDidHear() {
        return howDidHear;
    }

    public WebElement getPolicyCheckbox() {
        return policyCheckbox;
    }


}
