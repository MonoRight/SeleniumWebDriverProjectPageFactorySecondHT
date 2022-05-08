package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SamsungSmartphonesPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class, 'prod-cart__descr')]")
    private List<WebElement> searchDescriptionList;

    public SamsungSmartphonesPage(WebDriver driver, int waitSeconds) {
        super(driver, waitSeconds);
    }

    public boolean searchSamsungProducts(final String samsungString){
        return explicitWaitByVisibility(searchDescriptionList.get(0)).getText().contains(samsungString);
    }
}
