package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class appiumtest {

	private AndroidDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:platformVersion", "11");
		dc.setCapability("appium:udid", "y5dudepvnzpbd6jj");
		dc.setCapability("appium:ensureWebviewsHavePages", true);
		dc.setCapability("appium:nativeWebScreenshot", true);
		dc.setCapability("appium:newCommandTimeout", 3600);
		dc.setCapability("appium:connectHardwareKeyboard", true);
	   	dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorTabActivity");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, dc);
	}

	@Test
	public void sampleTest() throws Throwable {
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.ImageView[@content-desc=\"Messaging\"]")).click();
		 * driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
		 * "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]"
		 * +
		 * "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"
		 * + "/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).
		 * click(); Thread.sleep(2000); driver.findElement(By.xpath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.EditText"
		 * )) .sendKeys("I LOVE YOU"); Thread.sleep(2000);
		 * 
		 * 
		 * driver.findElement(By.id("com.android.mms:id/send_button")).click();
		 */

	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
