package uiTests;

import uiTesting.demoWebShopPages.LoginPage;
import uiTesting.demoWebShopPages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiTesting.testRunner.Runner;

public class DemoWebShopTest {

    private WebDriver driver;
    Runner runner = new Runner();

    //    @BeforeMethod
//    @Parameters("browser")
//    public void setup(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = runner.runChrome();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = runner.runFireFox();
//
//        }
//    }

    @BeforeMethod           // solo browser run
    public void setup() {
        driver = runner.runChrome();
    }

    @Test
    public void  registrationTest(){
        driver.get("https://demowebshop.tricentis.com/");
        RegisterPage page = new RegisterPage(driver);
        page.waitForSelectedElementToBeVisible(driver,page.getRegisterSelector(),5);
        page.getRegister().click();
        page.initElements();

        page.getGenderMale().click();
        page.getFirstName().sendKeys("FirstName");
        page.getLastName().sendKeys("LastName");
        page.getEMail().sendKeys("test@mail.com");
        page.getPassword().sendKeys("password");
        page.getConfirmPassword().sendKeys("password");
        page.getRegisterButton().click();

        page.initResultElements();
        Assert.assertEquals(page.getResultText().getText(), "Your registration completed", "Error occurs");

        //TODO Should be realized method to remove created user - Blocked because there is no access to the database or admin panel
    }

    @Test
    public void logInOutTest(){
        driver.get("https://demowebshop.tricentis.com/");
        LoginPage page = new LoginPage(driver);
        page.getLogin().click();
        page.initLoginElements();

        page.getEMail().sendKeys("bleach366test@gmail.com");
        page.getPassword().sendKeys("aezakmi");
        page.getLogInButton().click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".header-links .account")).getText(),"bleach366test@gmail.com");
        Assert.assertEquals(driver.findElement(By.cssSelector(".ico-logout")).getText(), "Log out");
        driver.findElement(By.cssSelector(".ico-logout")).click();
        page.initElements();
        page.waitForSelectedElementToBeVisible(driver, page.getLoginSelector(), 5);
        Assert.assertEquals(page.getLogin().getText(),"Log in");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        driver.quit();
    }
}
