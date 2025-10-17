package com.sashathe.tests;

import com.sashathe.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.getDriver();
        System.out.println("✅ Driver initialized successfully");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("🧹 Driver closed successfully");
    }
}

