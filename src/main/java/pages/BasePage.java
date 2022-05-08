package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    WebDriverWait waiter;
    Actions actions;

    public BasePage(WebDriver driver, int waitSeconds){
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement explicitWaitByVisibility(WebElement webElement){
        return waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void implicitWait(long timeToWait){
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

}
