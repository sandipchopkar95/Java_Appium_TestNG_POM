package com.app.tests.ui_tests;

import com.app.base.BaseTest;
import com.app.constants.ProductPageConstants;
import com.app.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
    ProductsPage productPage;

    @BeforeClass(dependsOnMethods = "launchApplication")
    public void initializeProductPage(){
        if(productPage == null){
            productPage = new ProductsPage(driver);
        }
    }

    @Test(description = "TC-001 Verify correct screen header appears on the Product Page")
    public void verifyProductPageTitle(){
        Assert.assertEquals(productPage.getScreenHeader(), ProductPageConstants.HEADER_PRODUCTS_PAGE,"Products page header not matched");
    }

    @Test(description = "TC-002 Verify that Cart icon button is available on products screen")
    public void verifyCartIconButton(){
        Assert.assertTrue(productPage.isCartIconButtonAvailable(),"Cart Icon button not displayed");
    }

    @Test(description = "TC-003 Verify that Open Menu button is available on products screen")
    public void verifyOpenMenuButton(){
        Assert.assertTrue(productPage.isOpenMenuButtonAvailable(),"Open Menu button not displayed");
    }

    @Test(description = "TC-004 Verify that Sort item button is available on products screen")
    public void verifySortItemButton(){
        Assert.assertTrue(productPage.isSortButtonAvailable(),"Sort item button not displayed");
    }

    @Test(description = "TC-005 Verify that price is available for the product in the list")
    public void verifyProductPriceAvailableForProduct(){
        String productName = productPage.getFirstProductName();
        Assert.assertTrue(productPage.checkProductPriceAvailableForProduct(productName));
    }
}
