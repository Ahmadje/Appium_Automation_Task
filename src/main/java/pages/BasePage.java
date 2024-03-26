package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotUtils;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static utils.DriverManager.getDriver;
import static utils.FrameworkConstants.TEXT;

public class BasePage {
    public static final long WAIT = 30;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void waitForElementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By element) {
        waitForElementToBeClickable(element);
        findElement(element).click();
    }

    public void clickSkip(By element) {
        waitForVisibility(element);
        findElement(element).click();
    }

    public void sendKeys(By mobileElement, String txt) {
        waitForVisibility(mobileElement);
        clear(mobileElement);
        findElement(mobileElement).sendKeys(txt);
    }

    public void clear(By mobileElement) {
        waitForVisibility(mobileElement);
        findElement(mobileElement).clear();
    }

    public String getAttribute(By element, String attribute) {
        waitForVisibility(element);
        return findElement(element).getAttribute(attribute);
    }

    public String getElementText(By element) {
        waitForVisibility(element);
        return findElement(element).getAttribute(TEXT);
    }

    private boolean isDisplayed(By element) {
        waitForVisibility(element);
        return findElement(element).isDisplayed();
    }

    public void scrollDown() {
        TouchAction<?> touchAction = new TouchAction<>((PerformsTouchActions) getDriver());
        Dimension size = getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8); // 80% from the top
        int endY = (int) (size.height * 0.2); // 20% from the top

        touchAction.press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(startX, endY)).release().perform();
    }

    public void scrollUntilElementVisible(By by) {
        int scrollAttempts = 0;
        while (scrollAttempts < 50) {
            if (findElement(by) != null && findElement(by).isDisplayed()) {
                break;
            } else {
                scrollDown();
                scrollAttempts++;
            }
        }
    }

    private WebElement findElement(By by) {
        try {
            return getDriver().findElement(by);
        } catch (Exception e) {
            return null;
        }
    }

}
