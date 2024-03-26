package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utils.JSONUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import static utils.FrameworkConstants.RESOURCES_TEST_PATH;
import static utils.ScreenshotUtils.takeScreenShot;


public class S01_FilterTests extends BaseTest {
    P01_LoginPage onBoarding;

    @BeforeMethod
    public void beforeMethod(Method method) throws FileNotFoundException {
        testData = new JSONUtils(RESOURCES_TEST_PATH + "testData/testData.json");
        onBoarding = new P01_LoginPage();
    }

    @Test(description = "Verify Filter Deals For You")
    public void TC01() throws InterruptedException, IOException {
        onBoarding.skipWithoutLogin().
                scrollToDeals(getTestData("deals")).
                filterForYou(getTestData("department"));
        takeScreenShot();
    }

    @Test(description = "Verify Filter Electronics Department")
    public void TC02() throws InterruptedException, IOException {
        onBoarding.skipWithoutLogin().
                scrollToElectronics(getTestData("section")).
                filterProduct(getTestData("category")).
                customizeYourFilter();
        takeScreenShot();
    }


}
