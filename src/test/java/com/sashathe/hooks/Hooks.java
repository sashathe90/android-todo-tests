package com.sashathe.hooks;

import com.sashathe.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

public class Hooks {

    public static AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            driver = DriverFactory.getDriver();
            System.out.println("✅ Appium session started.");
        } else {
            System.out.println("♻️ Reusing existing Appium session.");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // 📸 Если тест упал — прикрепляем скриншот в Allure
        if (scenario.isFailed() && driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("🧨 Screenshot on Failure", new ByteArrayInputStream(screenshot));
                System.out.println("📸 Screenshot attached to Allure report.");
            } catch (Exception e) {
                System.out.println("⚠️ Could not capture screenshot: " + e.getMessage());
            }
        }
    }

    // 🚀 Закрытие драйвера после всех сценариев (в конце сессии)
    @io.cucumber.java.AfterAll
    public static void closeSession() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("🧹 Appium session closed.");
        }
    }
}

