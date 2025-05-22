package com.app.pages;

import com.app.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {

    public CommonPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "")
    private WebElement screenHeader;

    public String getScreenHeader(){
        return waitAndGetText(screenHeader);
    }

}
