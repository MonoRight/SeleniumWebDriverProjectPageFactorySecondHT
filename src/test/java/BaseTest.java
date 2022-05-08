import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.SamsungSmartphonesPage;
import pages.SearchResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";
    private static final int TIME_TO_WAIT = 30;

    @BeforeTest
    public void profileSetUp(){
        chromedriver().setup();
    }

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver(),TIME_TO_WAIT);
    }

    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage(getDriver(),TIME_TO_WAIT);
    }

    public SamsungSmartphonesPage getSamsungSmartphonesPage(){
        return new SamsungSmartphonesPage(getDriver(),TIME_TO_WAIT);
    }
}
