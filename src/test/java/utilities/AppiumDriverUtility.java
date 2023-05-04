package utilities;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumDriverUtility {

	public void swapScreen(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "left", "percent", 0.75));
	}

	// This method is use for perform scroll operation using X and Y-coordinate in
	// mobile application
	public void scrollBySize(WebDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.1);
		// Perform the scrolling action
		// Create a TouchAction instance
		AndroidTouchAction ac = new AndroidTouchAction((PerformsTouchActions) driver);
		ac.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(startX, endY)).release().perform();

	}
// string value pass in Testcase class which you want scrollIntoView -- Example: "\"AnyText\""

	public WebElement scrollIntoView(WebDriver driver, String uitext) {
		WebElement element = driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(" + uitext + "));"));
		return element;
	}

	// This method is use for perform Back operation in mobile application
	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	// This method is use for perform doubleTap activity in mobile application
	public void doubleTap(WebDriver driver, WebElement element) {
		AndroidTouchAction ac = new AndroidTouchAction((PerformsTouchActions) driver);
		ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
				.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}

//This method is use for perform drag and drop activity in mobile application
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		AndroidTouchAction ac = new AndroidTouchAction((PerformsTouchActions) driver);
		ac.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
	}

// This method is use for perform longpress activity in mobile application
	public void longPress(WebDriver driver, WebElement element) {

		LongPressOptions lo = new LongPressOptions();
		AndroidTouchAction ac = new AndroidTouchAction((PerformsTouchActions) driver);
		lo.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(element));
		ac.longPress(lo).release().perform();

	}

	public String takeScreenShot(WebDriver driver, String filename) {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./screen/" + filename);
		try {
			FileUtils.copyFile(srcfile, destfile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
		

	}

	

	

}
