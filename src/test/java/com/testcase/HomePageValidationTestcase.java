package com.testcase;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageobjects.HomePage;

public class HomePageValidationTestcase extends BaseClass {

	HomePage hp;

	@Test(groups={"smoke"})
	public void validateHomepage() {
		hp = new HomePage(driver);
		hp.getApidemos().isDisplayed();
		hp.getAccessibilityText();
		hp.getAnimationText();
		hp.getAppText();
		hp.getContentText();
		hp.getGraphicsText();
		hp.getMediaText();
		hp.getNfcText();
		hp.getOsText();
		hp.getPreferenceText();
		hp.getTextText();
		hp.getViewsText();

		
	}

}
