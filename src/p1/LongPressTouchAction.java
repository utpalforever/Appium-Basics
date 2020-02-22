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
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LongPressTouchAction {

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

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		Thread.sleep(3000);
		AndroidElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		Thread.sleep(3000);
		TouchAction ta = new TouchAction(driver);
		ta.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames))
				.withDuration(Duration.ofSeconds(3000))).perform();

	}
}