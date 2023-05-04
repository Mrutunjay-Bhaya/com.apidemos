package com.pageobjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(id = "android:id/action_bar")
	private MobileElement apidemos;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Accessibility']")
	private MobileElement accessibility;
	//@FindBy(xpath = "//android.widget.TextView[@content-desc='Animation']")
	private MobileElement animation;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='App']")
	private MobileElement app;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Content']")
	private MobileElement content;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Graphics']")
	private MobileElement graphics;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
	private MobileElement media;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='NFC']")
	private MobileElement nfc;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='OS']")
	private MobileElement os;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Preference']")
	private MobileElement preference;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Text']")
	private MobileElement text;
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
	private MobileElement views;

	public boolean accessibilityisDisplay() {
		boolean yes = accessibility.isDisplayed();
		return yes;

	}
public void getApiDemosText() {
	try {
		String s = apidemos.getText();
		System.out.println(s);
	} catch (Exception e) {
		System.out.println("API Demos Field is Not Avaliable");
	}
}
	public void getAccessibilityText() {

		try {
			String s = accessibility.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Accessibility Field is Not Avaliable");
		}

	}

	public void getAnimationText() {

		try {
			String s = animation.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("Animation Field is Not Avaliable");
		}

	}

	public void getAppText() {

		try {
			String s = app.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("App Field is Not Avaliable");
		}

	}

	public void getContentText() {

		try {
			String s = content.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("content Field is Not Avaliable");
		}

	}

	public void getGraphicsText() {

		try {
			String s = graphics.getText();
			System.out.println(s);
		} catch (Exception e) {

			System.out.println("graphics Field is Not Avaliable");
		}

	}

	public void getNfcText() {

		try {
			String s = nfc.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("nfc Field is Not Avaliable");
		}

	}

	public void getOsText() {

		try {
			String s = os.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("os Field is Not Avaliable");
		}

	}

	public void getMediaText() {

		try {
			String s = media.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("media Field is Not Avaliable");
		}

	}

	public void getPreferenceText() {

		try {
			String s = preference.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("preference Field is Not Avaliable");
		}

	}

	public void getTextText() {

		try {
			String s = text.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("text Field is Not Avaliable");
		}

	}

	public void getViewsText() {

		try {
			String s = views.getText();
			System.out.println(s);
		} catch (Exception e) {
			System.out.println("views Field is Not Avaliable");
		}

	}

	public MobileElement getApidemos() {
		return apidemos;
	}

	public MobileElement getAccessibility() {
		return accessibility;
	}

	public MobileElement getAnimation() {
		return animation;
	}

	public MobileElement getApp() {
		return app;
	}

	public MobileElement getContent() {
		return content;
	}

	public MobileElement getGraphics() {
		return graphics;
	}

	public MobileElement getMedia() {
		return media;
	}

	public MobileElement getNfc() {
		return nfc;
	}

	public MobileElement getOs() {
		return os;
	}

	public MobileElement getPreference() {
		return preference;
	}

	public MobileElement getText() {
		return text;
	}

	public MobileElement getViews() {
		return views;
	}

}