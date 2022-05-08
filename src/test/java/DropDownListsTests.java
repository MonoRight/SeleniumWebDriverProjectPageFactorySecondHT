import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class DropDownListsTests extends BaseTest{
    private static final String KEY_WORD = "Samsung";
    @Test(priority = 1)
    public void dropDownListMoveToCategoriesAndPageWithCategoriesIsOpened() {
        getHomePage().clickOnProductInCategoryList();
        assertTrue(getSamsungSmartphonesPage().searchSamsungProducts(KEY_WORD));
    }
}
