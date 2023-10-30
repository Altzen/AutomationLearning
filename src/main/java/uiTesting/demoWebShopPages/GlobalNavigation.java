package uiTesting.demoWebShopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiTesting.tools.Wait;

public class GlobalNavigation extends Wait {

    private final String REGISTER_BUTTON = ".ico-register";
    private final String LOGIN_BUTTON = ".ico-login";



    public GlobalNavigation(WebDriver driver) {
        super(driver);
        initElements();
    }

    private WebElement register;
    private WebElement login;



    public void initElements() {
        register = driver.findElement(By.cssSelector(REGISTER_BUTTON));
        login = driver.findElement(By.cssSelector(LOGIN_BUTTON));
    }

    public WebElement getRegister() {
        return register;
    }
    public String getRegisterSelector() {
        return REGISTER_BUTTON;
    }
    public WebElement getLogin() {
        return login;
    }
    public String getLoginSelector() {
        return LOGIN_BUTTON;
    }

}
