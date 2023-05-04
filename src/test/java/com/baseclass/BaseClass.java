package com.baseclass;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AppiumDriver<MobileElement> driver;
	@BeforeSuite
	@Test(groups= {"smoke"})
	public void setDesiredCapabilities() throws  Throwable {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "RedmiNote8pro");
		
		//This is for installation app in device
		//dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/app/ApiDemos-debug.apk");
		dc.setCapability("autoGrantPermissions", true);
		 dc.setCapability("appPackage", "io.appium.android.apis");
		 dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		 Thread.sleep(2000);
		URL remoteUrl=new URL("http://localhost:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(remoteUrl, dc);
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}
	
	
	
	
	
	
	
}
