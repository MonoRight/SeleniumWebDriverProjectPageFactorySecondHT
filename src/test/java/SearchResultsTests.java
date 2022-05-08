import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SearchResultsTests extends BaseTest{
    private static final String SEARCH_KEYWORD = "Samsung Galaxy S22";
    private static final int FIRST_ITEM = 0;
    @Test(priority = 1)
    public void titleOfThePageContainsSearchProduct(){
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultPage().clickOnSearchResultProductByIndex(FIRST_ITEM);
        assertTrue(getSearchResultPage().getTitleOfPage().contains(SEARCH_KEYWORD));
    }

}
