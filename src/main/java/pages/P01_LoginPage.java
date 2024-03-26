package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static utils.DriverManager.getDriver;

public class P01_LoginPage extends BasePage {


    By stayInUSA = AppiumBy.id("btn_stay_marketplace");
    By skipLoginBtn = AppiumBy.id("skip_sign_in_button");


    @Step("Select Skip Without Login after Dismiss Alert")
    public P02_HomePage skipWithoutLogin() {
        try {
            clickSkip(stayInUSA);
            click(skipLoginBtn);
        } catch (NoSuchElementException e) {
            click(skipLoginBtn);
        }
        return new P02_HomePage();
    }

}
