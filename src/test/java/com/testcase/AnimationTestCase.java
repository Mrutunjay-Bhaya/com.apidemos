package com.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import com.pageobjects.AnimationPage;
import com.pageobjects.HomePage;
import junit.framework.Assert;
import utilities.AppiumDriverUtility;

public class AnimationTestCase extends BaseClass {
	AnimationPage ap;
	AppiumDriverUtility au;
	HomePage hp;
	Logger logger = LogManager.getLogger(this.getClass());

	@Test(priority = 1, groups = { "sanity" })
	public void validateBouncingBalls() {

		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		au.takeScreenShot(driver, "HomePage.png");
		logger.info("Click Animation");
		ap.clickAnimation();
		logger.info("clickBouncingballs ");
		ap.clickBouncingballs();
		logger.info("vertically swip ");
		au.scrollBySize(driver);
		logger.info("click on back ");
		au.back(driver);
		logger.info("check APIDemos text display or not ");
		boolean apidemos = ap.getApidemos().isDisplayed();
		logger.info("validate the result ");
		Assert.assertEquals(apidemos, true);
		logger.info("sucssesfully matched ");

	}

	@Test(priority = 2, groups = {
			"sanity" }, description = "This is cloning testcase", dependsOnMethods = "validateBouncingBalls")
	public void validateCloning() {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		ap.clickCloning();
		ap.clickRunBtn();
		au.back(driver);
		boolean apidemos = ap.getApidemos().isDisplayed();
		Assert.assertEquals(apidemos, true);
	}

	@Test(priority = 3, groups = { "sanity" })
	public void validateCustomEvalator() {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		ap.clickCustomevalutor();
		ap.clickCustomevalutorPlayBtn();
		au.back(driver);
		boolean apidemos = ap.getApidemos().isDisplayed();
		Assert.assertEquals(apidemos, true);
	}

	@Test(priority = 4)
	public void validateDefaultLayoutAnimation() {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		ap.clickDefaultlayoutanimations();
		WebElement element = ap.getAddbtn();
		au.doubleTap(driver, element);
		au.back(driver);
		boolean apidemos = ap.getApidemos().isDisplayed();
		Assert.assertEquals(apidemos, true);
	}

	@Test(priority = 5)
	public void validateEvents() {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		ap.clickEvents();
		ap.clickEventsPlayBtn();
		au.back(driver);
		boolean apidemos = ap.getApidemos().isDisplayed();
		Assert.assertEquals(apidemos, true);
	}

	@Test(priority = 6)
	public void validateHideShowAnimation() throws Throwable {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		hp = new HomePage(driver);
		ap.clickHideShowAnimations();
		ap.clickCustomAnimationsBtn();
		ap.clickHideBtn();
		ap.clickNumber();
		Thread.sleep(1000);
		ap.clickNumber();
		Thread.sleep(1000);
		ap.clickNumber();
		au.back(driver);
		au.back(driver);
		boolean apidemos = ap.getApidemos().isDisplayed();
		Assert.assertEquals(apidemos, true);
	}

	@Test(priority = 7)
	public void validate() throws Throwable {
		ap = new AnimationPage(driver);
		au = new AppiumDriverUtility();
		hp = new HomePage(driver);
		hp.getViews().click();
		String s = "\"WebView\"";
		au.scrollIntoView(driver, s).click();
		au.back(driver);

	}
}
