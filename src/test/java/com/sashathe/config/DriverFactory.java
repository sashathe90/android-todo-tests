package com.sashathe.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Обязательные W3C capabilities
            caps.setCapability("platformName", "Android");

            // Appium-специфические с префиксом "appium:"
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:deviceName", "Android Device");
            caps.setCapability("appium:udid", "R5CT41YS7TJ");
            caps.setCapability("appium:appPackage", "com.sanjay.udacity.todolist");
            caps.setCapability("appium:appActivity", "com.sanjay.udacity.todolist.MainActivity");
            caps.setCapability("appium:autoGrantPermissions", true);
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:fullReset", false);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


