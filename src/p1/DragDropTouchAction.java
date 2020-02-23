package p1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragDropTouchAction {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File f = new File("src");
		File fs = new File(f, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Emulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// views--Expandable list--Custom Adaptor--People names
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		WebElement src = driver.findElementByXPath("//android.view.View[@index='1']");
		WebElement des = driver.findElementByXPath("//android.view.View[@index='2']");

		TouchAction t = new TouchAction(driver);
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(src))
				.withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(des)).release().perform();

		// Below also can be used
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		Thread.sleep(2000);
		t.longPress(ElementOption.element(src)).moveTo(ElementOption.element(des)).perform().release();// StaleElementException
	}
}