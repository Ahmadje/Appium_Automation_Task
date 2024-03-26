package pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.IOException;

import static io.appium.java_client.touch.offset.PointOption.point;
import static utils.DriverManager.getDriver;
import static utils.ScreenshotUtils.takeScreenShot;

public class P03_ProductsPage extends BasePage {


    By filterElectronicsBtn = new By.ByXPath("//android.view.View[@resource-id=\"apb-browse-search-filter\"]//android.widget.Button");
    By filterBtn = new By.ByXPath("//android.widget.Button[@text=\"Filters\"]");
    By forYouBtn = new By.ByXPath("//android.widget.ToggleButton[@text=\"For you\"]");
    By departmentTitle = new By.ByXPath("//android.widget.TextView[@text=\"Department\"]");
    By seeAllFilters = new By.ByXPath("//android.widget.ToggleButton[@resource-id=\"s-all-filters\"]");
    By departmentBtn = new By.ByXPath("//android.widget.Button[@text=\"Department\"]");
    By departmentSeeMore = new By.ByXPath("//android.widget.Button[@text=\"See more\"]");

    public By selectCatagoery(String catagoery) {
        return new By.ByXPath("//android.view.View[@content-desc='" + catagoery + "']/android.view.View/android.widget.TextView[1]");
    }

    public By selectDepartment(String department) {
        return new By.ByXPath("//android.widget.ToggleButton[@text='" + department + "']");
    }

    @Step("Filter Electronic Products")
    public P03_ProductsPage filterProduct(String catagoery) throws InterruptedException {
        click(filterElectronicsBtn);
        click(departmentTitle);
        click(selectCatagoery(catagoery));
        Thread.sleep(3000);
        return this;
    }

    @Step("Click on See All Filters")
    public P03_ProductsPage customizeYourFilter() throws InterruptedException, IOException {
        Thread.sleep(2000);
        click(seeAllFilters);
        Thread.sleep(2000);
        takeScreenShot();
        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(1167, 2811))
                .release().perform();
        return this;
    }

    @Step("Select For You Offers then Filter by Software")
    public P03_ProductsPage filterForYou(String dep) throws InterruptedException {
        waitForVisibility(filterBtn);
        click(forYouBtn);
        Thread.sleep(1000);
        click(filterBtn);
        scrollUntilElementVisible(departmentBtn);
        click(departmentSeeMore);
        scrollUntilElementVisible(selectDepartment(dep));
        click(selectDepartment(dep));
        Thread.sleep(2000);
        new TouchAction((PerformsTouchActions) getDriver())
                .press(point(1167, 2711))
                .release().perform();
        return this;
    }

}
