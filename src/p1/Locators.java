package p1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Locators {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File f = new File("src");
		File fs = new File(f, "ApiDemos-debug.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Emulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		// xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Accessibility']").click();

//		// AndroidUIAutomator
//		driver.findElementByAndroidUIAutomator("text(\"Accessibility Node Provider\")").click();
//
//		// FindElements--id
//		driver.findElementsById("android:id/text1").get(0).click();
//
//		// id
//		driver.findElementById("android:id/text1").click();
//
//		// className
//		driver.findElementsByClassName("android.widget.TextView").get(1).click();
//
//	
		}

}