import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.About;
import testRunner.Runner;

public class ReportDownloadTest {

    private WebDriver driver;
    Runner runner =new Runner();
    About about = new About();
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = runner.runChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = runner.runFireFox();
        }
    }

    @Test
    public void downloadFile(){
        driver.get("https://www.epam.com/about");
//        about.clickDownload();

    }

    @AfterMethod(alwaysRun = true)
    public void cleanup(){
        driver.quit();
    }
}
