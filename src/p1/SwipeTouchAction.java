package p1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeTouchAction {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File f = new File("src");
		File fs = new File(f, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Emulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		// views--Date widget-- 2.Inline
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		List<AndroidElement> afterDateWid = driver.findElementsByClassName("android.widget.TextView");
		afterDateWid.get(2).click();

		// driver.findElementByXPath("//android.widget.RadialTimePickerView$RadialPickerTouchHelper[@content-desc='10']").click();
		// above is not working since special character is present in tagname/className
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@content-desc='10']").click();
		Thread.sleep(3000);
		AndroidElement source = driver.findElementByXPath("//*[@content-desc='15']");
		Thread.sleep(3000);
		AndroidElement dest = driver.findElementByXPath("//*[@content-desc='45']");
		Thread.sleep(3000);
		TouchAction t = new TouchAction(driver);
		Thread.sleep(3000);
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source))
				.withDuration(Duration.ofSeconds(3))).moveTo(ElementOption.element(dest)).release().perform();
	}
}