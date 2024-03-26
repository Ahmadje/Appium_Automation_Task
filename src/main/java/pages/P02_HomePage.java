package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_HomePage extends BasePage {


    By seeMoreBtn = new By.ByXPath("//android.widget.TextView[@text=\"See more\"]");

    public By getElectronicsBtn(String txt) {
        return new By.ByXPath("//android.widget.TextView[@text='" + txt + "']");
    }
    public By getSeeAllDealsBtn(String txt) {
        return  new By.ByXPath("//android.widget.TextView[@text='"+txt+"']");
    }

    @Step("Scroll till found Deals and open it")
    public P03_ProductsPage scrollToDeals(String deal) {
        scrollUntilElementVisible(getSeeAllDealsBtn(deal));
        click(getSeeAllDealsBtn(deal));
        return new P03_ProductsPage();
    }

    @Step("Scroll till found Electronics and open it")
    public P03_ProductsPage scrollToElectronics(String section) {
        scrollUntilElementVisible(getElectronicsBtn(section));
        scrollDown();
        click(seeMoreBtn);
        return new P03_ProductsPage();
    }

}
