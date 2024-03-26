package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import utils.JSONUtils;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.DriverManager.getDriver;
import static utils.DriverManager.setDriver;

public class BaseTest {
    public static AndroidDriver driver;
    public static JSONUtils testData;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:appPackage", "com.amazon.mShop.android.shopping");
        desiredCapabilities.setCapability("appium:appActivity", "com.amazon.mShop.home.HomeActivity");
        desiredCapabilities.setCapability("appium:autoGrantPermissions", "true");
        desiredCapabilities.setCapability("appium:autoAcceptAlerts", "true");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 10000);
        desiredCapabilities.setCapability("location", "40.7128, -74.0060");
        desiredCapabilities.setCapability("gpsEnabled", false);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), desiredCapabilities);
        setDriver(driver);
    }

    @AfterMethod
    public void restartApp() {
        ((AndroidDriver) getDriver()).resetApp();
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }

    public String getTestData(String jsonPath) throws FileNotFoundException {
        return testData.getTestData(jsonPath);
    }

}
