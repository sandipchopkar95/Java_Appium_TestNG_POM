package com.app.drivers;

import com.app.utils.LoggerUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();
    private static final Logger logger = LoggerUtility.getLogger(DriverManager.class);

    public static String capabilityName = System.getProperty("capabilityName", "MyDevice");

    public static AppiumDriver setUpApplication() throws Exception {
        logger.info("SETUP : Entered Device Capability name is : {}", capabilityName);
        try {
            AppiumDriver appiumDriver = new AppiumDriver(service.get(),
                    CapabilityReader.getDesiredCapabilities(capabilityName, "./src/main/resources/config/DeviceConfig.json")
            );
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.set(appiumDriver);
            logger.info("SETUP : Connected to Appium Server, Launching Application. . .");
        } catch (Exception e) {
            logger.error("ERROR : Error initializing Appium Driver: ", e);
        }
        return driver.get();
    }

    public static void closeApplication() {
        if (driver.get() != null) {
            driver.get().quit();
            logger.info("TEAR-DOWN : Driver quit successfully.");
            driver.remove();
        }
    }

    public static void closeService(){
        if (service.get() != null && service.get().isRunning()) {
            service.get().stop();
            logger.info("TEAR-DOWN : Appium service stopped.");
            service.remove();
        }
    }

    public static void startAppiumService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort();
        AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(builder);
        localService.start();
        service.set(localService);
    }

}
