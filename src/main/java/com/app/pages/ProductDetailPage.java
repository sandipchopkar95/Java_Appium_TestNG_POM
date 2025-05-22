package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends CommonPage{

    public ProductDetailPage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(accessibility = "product price")
    @iOSXCUITFindBy(accessibility = "product price")
    private WebElement productPrice;

    @NotNull
    private WebElement getElementReviewStar(int ratingInInt){
        String rating = String.valueOf(ratingInInt);
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='review star "+rating+"']"));
    }

    private WebElement getElementColour(String colour){
        String smallCaseColour = colour.toLowerCase();
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='"+smallCaseColour+" circle']/android.view.ViewGroup"));
    }

    @AndroidFindBy(accessibility = "counter minus button")
    @iOSXCUITFindBy(accessibility = "counter minus button")
    private WebElement button_ProductMinus;

    @AndroidFindBy(accessibility = "counter plus button")
    @iOSXCUITFindBy(accessibility = "counter plus button")
    private WebElement button_ProductPlus;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='counter amount']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement label_CounterAmount;

    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(accessibility = "Add To Cart button")
    private WebElement button_AddToCart;


    @AndroidFindBy(accessibility = "cart badge")
    @iOSXCUITFindBy(accessibility = "cart badge")
    private WebElement button_CartBadge;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "cart badge")
    private WebElement button_CartBadgeValue;



}
