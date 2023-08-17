package test_case_android;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;


public class A00 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());

	public void A00(AndroidDriver<AndroidElement> driver) throws IOException {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 실행");
		
		//driver.execute_script("adb -e emu finger touch 1");
		//driver.fingerPrint(0);
		//Runtime.getRuntime().exec("adb -e emu finger touch Fingerprint 1");			
		driver.executeScript("mobile: fingerPrint", "{\"fingerprintId\": 1)");
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 종료");
	}
}
