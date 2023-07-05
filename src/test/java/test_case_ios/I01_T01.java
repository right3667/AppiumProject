package test_case_ios;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class I01_T01 {
	
	func_appium_ios test_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I01_T01_case(IOSDriver<IOSElement> driver) {
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I01_T01 실행");
		test_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("btn info blue");
		app_info_btn.click();
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//test_func.delay("xpath", "//XCUIElementTypeButton[@name=\"setting\"]", 10);		
		//MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("setting");
//		el1.click();
				
		//sleep(1);
		
		/*
		if (delay() == 1) {
			assertTrue(false);
		}*/
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I01_T01 종료");
		
	}
}
