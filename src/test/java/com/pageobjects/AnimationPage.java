package com.pageobjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AnimationPage {
 public AnimationPage(AppiumDriver<MobileElement>driver) {
	super();
	 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
 }
	    @FindBy(id = "android:id/action_bar")
		private MobileElement apidemos;
	    @FindBy(xpath = "//android.widget.TextView[@content-desc='Animation']")
		private MobileElement animation;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Bouncing Balls']")
		private MobileElement bouncingballs;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Cloning']")
		private MobileElement cloning;
		public MobileElement getRunbtn() {
			return runbtn;
		}
		public MobileElement getPlaybtn() {
			return playbtn;
		}
		public MobileElement getAddbtn() {
			return addbtn;
		}
		public MobileElement getEventplaybtn() {
			return eventplaybtn;
		}
		public MobileElement getCustomanimation() {
			return customanimation;
		}
		public MobileElement getHide() {
			return hide;
		}
		public MobileElement getNumberbtn() {
			return numberbtn;
		}
		@FindBy(xpath = "//android.widget.Button[@content-desc='Run']")
		private MobileElement runbtn;
		
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Custom Evaluator']")
		private MobileElement customevalutor;
		@FindBy(xpath = "//android.widget.Button[@content-desc='Play']")
		private MobileElement playbtn;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Default Layout Animations']")
		private MobileElement defaultlayoutanimations;
		@FindBy(xpath = "//android.widget.Button[@content-desc='Add Button']")
		private MobileElement addbtn;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Events']")
		private MobileElement Events;
		@FindBy(xpath = "//android.widget.Button[@content-desc='Play']")
		private MobileElement eventplaybtn;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Hide-Show Animations']")
		private MobileElement HideShowAnimations;
		@FindBy(xpath = "//android.widget.CheckBox[@content-desc='Custom Animations']")
		private MobileElement customanimation;
		@FindBy(id = "io.appium.android.apis:id/hideGoneCB")
		private MobileElement hide;
		@FindBy(xpath = "(//android.widget.Button[@index='0'])[2]")
		private MobileElement numberbtn;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Layout Animations']")
		private MobileElement LayoutAnimations;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Loading']")
		private MobileElement Loading;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Multiple Properties']")
		private MobileElement MultipleProperties;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Reversing']")
		private MobileElement Reversing;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='Seeking']")
		private MobileElement Seeking;
		@FindBy(xpath = "//android.widget.TextView[@content-desc='View Flip']")
		private MobileElement ViewFlip;
		
		public void getApiDemosText() {
			try {
				String s = apidemos.getText();
				System.out.println(s);
			} catch (Exception e) {
				System.out.println("API Demos Field is Not Avaliable");
			}
		}
		public void clickAnimation() {
			animation.click();
			
		}
		public void clickBouncingballs() {
			bouncingballs.click();
		}
		public void clickCloning() {
			 cloning.click();
		}
		
		public void clickRunBtn() {
			 runbtn.click();
		}
		public void clickCustomevalutor() {
			customevalutor.click();
		}
		public void clickCustomevalutorPlayBtn() {
			playbtn.click();
		}
		
		
		public void clickDefaultlayoutanimations() {
			defaultlayoutanimations.click();
		}
		public void clickDefaultlayoutanimationsAddBtn() {
			addbtn.click();
		}
		
		public void clickEvents() {
			Events.click();
		}
		public void clickEventsPlayBtn() {
			playbtn.click();
		}
		public void clickHideShowAnimations() {
			HideShowAnimations.click();
		}
		public void clickCustomAnimationsBtn() {
			customanimation.click();
		}
		public void clickHideBtn() {
			hide.click();
		}
		public void clickNumber() {
			numberbtn.click();
		}
		public void clickLayoutAnimations() {
			LayoutAnimations.click();
		}
		public void clicklLoading() {
		Loading.click();
		}
		public void clickMultipleProperties() {
			MultipleProperties.click();
		}
		public void clickReversing() {
			Reversing.click();
		}
		public void clickSeeking() {
			Seeking.click();
		}
		public void clickViewFlip() {
			ViewFlip.click();
		}
		public MobileElement getApidemos() {
			return apidemos;
		}
		public MobileElement getAnimation() {
			return animation;
		}
		public MobileElement getBouncingballs() {
			return bouncingballs;
		}
		public MobileElement getCloning() {
			return cloning;
		}
		public MobileElement getCustomevalutor() {
			return customevalutor;
		}
		public MobileElement getDefaultlayoutanimations() {
			return defaultlayoutanimations;
		}
		public MobileElement getEvents() {
			return Events;
		}
		public MobileElement getHideShowAnimations() {
			return HideShowAnimations;
		}
		public MobileElement getLayoutAnimations() {
			return LayoutAnimations;
		}
		public MobileElement getLoading() {
			return Loading;
		}
		public MobileElement getMultipleProperties() {
			return MultipleProperties;
		}
		public MobileElement getReversing() {
			return Reversing;
		}
		public MobileElement getSeeking() {
			return Seeking;
		}
		public MobileElement getViewFlip() {
			return ViewFlip;
		}
	 
	 
	 
	 
 }

