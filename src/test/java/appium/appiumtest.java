package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.App;
import com.sun.accessibility.internal.resources.accessibility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class appiumtest {

	private AndroidDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	public static String NodeExePath = "C:\\Program Files\\nodejs\\node.exe";
	public static String NodeJsMainPath = "C:\\Users\\MRUTUNJAY BHAYA\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	public static String ServerAddress = "127.0.0.1";

	@BeforeTest
	public void startAppiumServer() {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(NodeExePath)).withAppiumJS(new File(NodeJsMainPath))
				.withIPAddress(ServerAddress).withArgument(GeneralServerFlag.BASEPATH, "/wd/hub").usingPort(4723));
System.out.println("starting appimu server");
service.start();
	}

	@Test (priority=0)
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");// XCUITest for iOS device
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");// platform name should be iOS or Android
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi");// device name can be anything
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3600);
		dc.setCapability("autoGrantPermissions", true);
		/*
		 * adb shell dumpsys window | find "mCurrentFocus" type this command in cmd to
		 * know you apppackage and appactivity on current device
		 */
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test (priority=1)
	public void sampleTest() throws Throwable {
//		driver.unlockDevice();
//		driver.toggleData();
//	
//		//driver.toggleWifi();
//		  Thread.sleep(2000);
		// driver.hideKeyboard();

//		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	        
//			FileUtils.copyFile(scrFile, new File("./screen/image.png"));
		// Get the size of the device screen
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		// we can use this xpath or find the element from list of element

		// driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElementsById("android:id/text1").get(10).click();
		// WebElement el=driver.findElement(By.id("android:id/text1"));
		WebElement list = driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().description(\"Splitting Touches across Views\"));"));
		list.click();
		WebElement list1 = driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brin\"));"));
		list1.click();
		driver.navigate().back();
		driver.navigate().back();

		driver.findElementsById("android:id/text1").get(10).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		WebElement target = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		TouchAction ac = new TouchAction(driver);

		// drag and drop
		ac.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElementsById("android:id/text1").get(10).click();
		Dimension size = driver.manage().window().getSize();

		// Set the start and end coordinates for the scrolling action
		int startX = size.width / 2;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.1);

		// Create a TouchAction instance

		// Thread.sleep(5000);
		// Perform the scrolling action
		ac.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(startX, endY)).release().perform();
		driver.findElementsById("android:id/text1").get(8).click();
		driver.findElementsById("android:id/text1").get(10).click();
		WebElement al = driver.findElementsById("android:id/text1").get(0);
		// al.click();
		// Thread.sleep(1000);
		// al.click();
		driver.findElementByAccessibilityId("");
		driver.findElement(MobileBy.AccessibilityId(""));
		ac.tap(TapOptions.tapOptions().withElement(ElementOption.element(al)))
				.tap(TapOptions.tapOptions().withElement(ElementOption.element(al))).perform();

		KeyEvent ky = new KeyEvent();
		ky.withFlag(KeyEventFlag.FROM_SYSTEM);

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}
