package test_case_mac;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_mac;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class M01_T01 {
	
	func_appium_mac app_func = new func_appium_mac();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I01_T01_case(IOSDriver<IOSElement> driver) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I01_T01 실행");
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("btn info blue");
		app_info_btn.click();
		
		MobileElement lb_app_info_client_version = (MobileElement) driver.findElementByAccessibilityId("lb_app_info_client_version");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + lb_app_info_client_version.getText());
			
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//app_func.delay("xpath", "//XCUIElementTypeButton[@name=\"setting\"]", 10);		
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
