import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class LunchAppium {
	@Test
	public void desiredCapabilitiesForAndriod() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("deviceName", "mi");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("udid", device_udid);
		// dc.setCapability("unlockType", "password");
		// dc.setCapability("unlockKey", "");
		dc.setCapability("adbExecTimeout", 20000);
		// if application not install in device
		// dc.setCapability("app", "E:\\ApiDemos-debug.apk");
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);
		// if application install in device
		 dc.setCapability("appPackage", "io.appium.android.apis");
		 dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<>(url, dc);
		// driver.lockDevice(Duration.ofSeconds(10));
		/*
		 * // driver.executeScript("mobile: shell", ImmutableMap.of("command", "dumpsys
		 * // window windows | grep -E 'mCurrentFocus'")); //
		 * driver.executeScript("mobile: shell", ImmutableMap.of("command", "adb shell
		 * // input keyevent 3")); Map<String, Object> argv = new HashMap<>();
		 * argv.put("command", "adb shell input keyevent 3"); // argv.put("args",
		 * Lists.newArrayList("")); String result =
		 * driver.executeScript("mobile: shell", argv).toString();
		 * System.out.println(result);
		 */
		
		//List<String> removePicsArgs = Arrays.asList("devices");
		Map<String, Object> removePicsCmd = ImmutableMap.of("command", "devices", "args", "-l");
		String output=(String)driver.executeScript("mobile: shell", removePicsCmd);
System.out.println(output);

   Map <object>map=driver.getCapabilities().asMap().get("deviceName");
/*
 * List<String> removePicsArgs = Arrays.asList("keyevent", "3"); Map<String,
 * Object> removePicsCmd = ImmutableMap.of("command", "input", "args",
 * removePicsArgs); String output=(String)driver.executeScript("mobile: shell",
 * removePicsCmd); System.out.println(output);
 */
	}

	@Test
	public void desiredCapabilitiesForiOS() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "iOS");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("deviceName", "apple");
		dc.setCapability("automationName", "XCUITest");
		dc.setCapability("xcodeOrgId", "L8T9J323");
		dc.setCapability("xcodeSigningId", "iPhone Devloper");
		// if application not install in device
		dc.setCapability("app", "E:\\ApiDemos-debug.app");
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);
		// if application install in device
		dc.setCapability("bundleId", "com.apple-samplecode.UIcatlog");
		dc.setCapability("updatedWDABundleId", " ");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		AppiumDriver<WebElement> driver = new IOSDriver<>(url, dc);
	}
}