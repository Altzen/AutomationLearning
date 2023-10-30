package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    protected WebDriver driver;

    public Wait (WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSelectedElementToBeClickable(WebDriver driver, String selector, int duration) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        }catch (InvalidSelectorException e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector)));
        }
    }
    public void waitForSelectedElementToBeVisible(WebDriver driver, String selector, int duration) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        }catch (InvalidSelectorException e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
        }
    }
    public void waitForUrlChange(WebDriver driver, String url, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public void waitForAttribute (WebDriver driver, WebElement element, String attributeType, String attributeName, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.attributeContains(element,attributeType,attributeName));

    }
}
