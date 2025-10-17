package com.sashathe.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchTodoTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        // Стандартные W3C-capabilities
        options.setPlatformName("Android");
        options.setDeviceName("Android Device");
        options.setUdid("R5CT41YS7TJ");

        // Appium-специфические — теперь все должны идти с префиксом "appium:"
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:appPackage", "com.sanjay.udacity.todolist");
        options.setCapability("appium:appActivity", ".MainActivity");
        options.setCapability("appium:noReset", true);
        options.setCapability("appium:fullReset", false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void launchApp() {
        System.out.println("✅ Приложение успешно запущено через Appium 3 + W3C!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

