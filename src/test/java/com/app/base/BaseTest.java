package com.app.base;

import com.app.drivers.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeTest
    public void startAppiumService(){
        DriverManager.startAppiumService();
    }

    @BeforeMethod
    public void launchApplication() throws Exception {
        driver = DriverManager.setUpApplication();
    }

    @AfterMethod
    public void closeApp() {
        DriverManager.closeApplication();
    }

    @AfterTest
    public void closeAppiumService(){
        DriverManager.closeService();
    }

}
