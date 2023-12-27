package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.sun.org.apache.bcel.internal.generic.IMUL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class appiumtest {

	private AndroidDriver<MobileElement> driver;
	//public static AppiumDriverLocalService service;
//	public static String NodeExePath = "C:\\Program Files\\nodejs\\node.exe";
//	public static String NodeJsMainPath = "C:\\Users\\MRUTUNJAY BHAYA\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	public static String ServerAddress = "127.0.0.1"; // or 0.0.0.0
	public static String NodeJsMainPath1 = "C:\\Users\\MRUTUNJAY BHAYA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	@BeforeTest
	public void startAppiumServer() {

		/*
		 * service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		 * .usingDriverExecutable(new File(NodeExePath)).withAppiumJS(new
		 * File(NodeJsMainPath))
		 * .withIPAddress(ServerAddress).withArgument(GeneralServerFlag.BASEPATH,
		 * "/wd/hub").usingPort(4723));
		 */

		/*
		 * service = new AppiumServiceBuilder().withAppiumJS(new
		 * File(NodeJsMainPath1)).withIPAddress(ServerAddress) .usingPort(4723).build();
		 * 
		 * System.out.println("starting appimu server"); service.start();
		 */
	}

	@Test(priority = 0)
	public void setUp() throws MalformedURLException, Throwable {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");// XCUITest for iOS device
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");// platform name should be iOS or Android
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi");// device name can be anything
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3600);
		dc.setCapability("autoGrantPermissions", true);
		//dc.setCapability(MobileCapabilityType.NO_RESET, true);
		//dc.setCapability(MobileCapabilityType.FULL_RESET, false);
//dc.setCapability("chromeOptions", ImmutableMap.of("w3c",false));
		/*
		 * adb shell dumpsys window | find "mCurrentFocus" type this command in cmd to
		 * know you apppackage and appactivity on current device
		 */
          // on mac system
		//adb shell dumpsys window | grep -E "mCurrentFocus"
		
		// dc.setCapability("appPackage", "io.appium.android.apis");
		// dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation testing"+Keys.ENTER);
		
		//driver.findElements(By.id("tsf")).get(1).click();
			//	try {
		//driver.findElement(By.xpath("//android.widget.Button[@text='Google Search']")).click();//.sendKeys("automation testing"+Keys.ENTER);
				//}catch(Exception e) {
					//System.out.println(e);
				//}
		
		//driver.findElement(By.name("q")).sendKeys("automation");
		
		 
		  try { boolean
		  logo=driver.getPageSource().contains("testing");
		  System.out.println(logo);
		  Assert.assertEquals(logo, true);
		  }catch(Exception e) {
		  System.out.println("No such element found"); }
		 
		/*
		 * driver.removeApp("io.appium.android.apis"); Thread.sleep(5000);
		 * driver.installApp(System.getProperty("user.dir") +
		 * "/app/ApiDemos-debug.apk");
		 * 
		 * driver.startActivity(new Activity("io.appium.android.apis",
		 * "io.appium.android.apis.ApiDemos")); Thread.sleep(3000);
		 */
	}

	@Test(priority = 1)
	public void sampleTest() throws Throwable {
driver.unlockDevice();
//		driver.toggleData();
//	
//		//driver.toggleWifi();
//		  Thread.sleep(2000);
		// driver.hideKeyboard();
		//driver.removeApp("io.appium.android.apis");
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
		AndroidTouchAction ac = new AndroidTouchAction(driver);

		
		
		// drag and drop
		ac.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
		
		
		driver.navigate().back();
		driver.navigate().back();
		driver.findElementsById("android:id/text1").get(10).click();
		Dimension size = driver.manage().window().getSize();

		
		//LongPress 
		LongPressOptions lo=new LongPressOptions();
		WebElement element1=driver.findElement(By.xpath(""));
		lo.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(element1));
		ac.longPress(lo).release().perform();
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

		//service.stop();
		System.out.println("appium stop");
	}
}
