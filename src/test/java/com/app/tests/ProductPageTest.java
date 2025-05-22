package com.app.tests;

import com.app.base.BaseTest;
import com.app.constants.ProductPageConstants;
import com.app.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
    ProductsPage productPage;

    @BeforeMethod
    public void initializeProductPage(){
        if(productPage != null){
            productPage = new ProductsPage(driver);
        }
    }

    @Test(description = "TC-001 Verify correct screen header appears on the Product Page")
    public void verifyProductPageTitle(){
        Assert.assertEquals(productPage.getScreenHeader(), ProductPageConstants.HEADER_PRODUCTS_PAGE,"Products page header not matched");
    }
}
