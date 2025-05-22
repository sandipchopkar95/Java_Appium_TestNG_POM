package com.app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends CommonPage {

    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    @NotNull
    private WebElement getElementProductName(String productName){
        return driver.findElement(By.xpath("//android.widget.TextView[@content-desc='store item text' and @text='"+productName+"']"));
    }

    @NotNull
    private WebElement getElementProduct(String productName){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='store item' and .//android.widget.TextView[@text='"+productName+"']]"));
    }

    @NotNull
    private WebElement getElementRatingStar(String productName, int ratingInInt){
        String rating = String.valueOf(ratingInInt);
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='store item' and .//android.widget.TextView[contains(@text, '"+productName+"')]]//android.view.ViewGroup[@content-desc='review star "+rating+"']"));
    }

    @NotNull
    private WebElement getElementProductPrice(String productName){
        return driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='store item' and .//android.widget.TextView[@text='"+ productName + "']]//android.widget.TextView[@content-desc='store item price']"));
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_CartIcon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_OpenMenu;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='sort button']/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement button_Sort;

    public boolean isCartIconButtonAvailable(){
        return waitAndCheckVisibilityOfElement(button_CartIcon);
    }

    public boolean isOpenMenuButtonAvailable(){
        return waitAndCheckVisibilityOfElement(button_OpenMenu);
    }

    public boolean isSortButtonAvailable(){
        return waitAndCheckVisibilityOfElement(button_Sort);
    }

}

