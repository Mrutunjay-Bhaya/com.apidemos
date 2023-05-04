package utilities;

import java.time.LocalDateTime;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.baseclass.BaseClass;

public class Screenshot implements ITestListener {

	public void onTestFailure(ITestResult result) {
		AppiumDriverUtility au = new AppiumDriverUtility();
		au.takeScreenShot(BaseClass.driver,
				result.getName() + LocalDateTime.now().toString().substring(0, 19).replace(":", "_") + ".png");

	}
}
