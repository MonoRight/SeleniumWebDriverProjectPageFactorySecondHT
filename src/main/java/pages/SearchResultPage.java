package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='prod-cart height']")
    private List<WebElement> searchResultProductList;
    @FindBy(xpath = "//a[@class='prod-cart__buy']")
    private List<WebElement> addToCartButtonList;
    @FindBy(xpath = "//div[@class='prod-cart__prise-new']")
    private List<WebElement> prisesResultProductList;
    @FindBy(xpath = "//div[@class='item-total']/span[@class='prise']")
    private WebElement totalCartPrice;

    public SearchResultPage(WebDriver driver, int waitSeconds) {
        super(driver, waitSeconds);
    }

    public List<WebElement> getSearchResultList(){
        return searchResultProductList;
    }

    public WebElement getSearchResultProductByIndex(int index){
        return searchResultProductList.get(index);
    }

    public void clickOnSearchResultProductByIndex(int index){
        getSearchResultProductByIndex(index).click();
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }

    public boolean addProductToCart(long timeToWait){
        int expectedPrice = Integer.parseInt(prisesResultProductList.get(0).getText().split(" ")[0]);
        addToCartButtonList.get(0).click();
        implicitWait(timeToWait);
        int actualPrice = Integer.parseInt(totalCartPrice.getText().split(" ")[0]);
        return expectedPrice == actualPrice;
    }
}
