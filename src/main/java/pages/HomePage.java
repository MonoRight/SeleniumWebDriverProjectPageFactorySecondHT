package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;
    @FindBy(xpath = "//li[@class='parent js_sidebar-item']/a[contains(@href, 'telefonyi-i-aksessuaryi')]")
    private List<WebElement> productCatalogList;
    @FindBy(xpath = "//ul[@class='sidebar-list']//a[contains(@href, 'smartfonyi')]")
    private List<WebElement> productSubcategoriesSmartphonesList;
    @FindBy(xpath = "//ul[@class='sidebar-list']//a[contains(@href, 'aksessuary-dlya-smartfonov')]")
    private List<WebElement> productSubcategoriesAccessoriesList;
    @FindBy(xpath = "//li[@class='single-hover-block']/a[contains(@href, 'smartfonyi/proizvoditel--samsung')]")
    private WebElement samsungSmartphoneCategory;

    public HomePage(WebDriver driver, int waitSeconds) {
        super(driver, waitSeconds);
    }

    public void searchByKeyword(final String keyword){
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnProductInCategoryList(){
        actions.moveToElement(productCatalogList.get(0)).build().perform();
        actions.moveToElement(explicitWaitByVisibility(productSubcategoriesAccessoriesList.get(0))).build().perform();
        actions.moveToElement(productSubcategoriesSmartphonesList.get(0)).build().perform();
        explicitWaitByVisibility(samsungSmartphoneCategory).click();
    }


}
