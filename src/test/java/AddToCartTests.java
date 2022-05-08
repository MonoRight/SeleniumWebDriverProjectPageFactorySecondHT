import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTests extends BaseTest{
    private static final String SEARCH_KEYWORD = "Samsung Galaxy S22";
    private static final long TIME_TO_WAIT = 30;
    @Test(priority = 1)
    public void productIsAddedToCart(){
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getSearchResultPage().addProductToCart(TIME_TO_WAIT));
    }
}
