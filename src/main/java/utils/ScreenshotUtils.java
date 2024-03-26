
package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static utils.DriverManager.getDriver;

public final class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static void takeScreenShot() throws IOException {
		File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		Allure.addAttachment("ScreenShot", FileUtils.openInputStream(source));
	}

}
