package test_case_android;



import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class A01_T01 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A01_T01_case(AndroidDriver<AndroidElement> driver) {
	app_func.sleep(driver, 3);
	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A01_T01 실행");
	
	app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
	//app_func.activate_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10:id/action_info");
	MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("버전정보");
	app_info_btn.click();
	
	app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvEwalkerName", 30);
	MobileElement version1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvServerVersion");
	MobileElement version2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvClientVersion");
	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "앱 버전 정보 = " + version1.getText() +" " + version2.getText());
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A01_T01 종료");
	
	}
}
