package test_case_mac;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class M02_T02 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I02_T02_case(IOSDriver<IOSElement> driver) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T02 실행");
		try {
		app_func.sleep(driver, 3);

		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");

		MobileElement app_setting_btn1 = (MobileElement) driver.findElementByAccessibilityId("btn setting blue");
		app_setting_btn1.click();
		
		MobileElement sw_setting_auto_login1 = (MobileElement) driver.findElementByAccessibilityId("sw_setting_auto_login");
		
		//자동로그인 on
		if (sw_setting_auto_login1.getAttribute("value").equals("0")) {
			sw_setting_auto_login1.click();
		}
		
		MobileElement Back1 = (MobileElement) driver.findElementByAccessibilityId("Back");
		Back1.click();
		app_func.delay(driver, "id", "btn info blue", 30);
		
		//로그인 상태에서 앱 종료 후 로그인되는지 확인
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "auto_login_test", "admin123!", 0, 0);
		
		app_func.logout_server(driver);
				
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");

		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");

		int temp1 = app_func.login_confirm(driver, "login");
		if (temp1 == 1) {
			assertTrue(false);
		}
		
		
		app_func.logout_server(driver);
		
		MobileElement app_setting_btn2 = (MobileElement) driver.findElementByAccessibilityId("btn setting blue");
		app_setting_btn2.click();
		
		MobileElement sw_setting_auto_login2 = (MobileElement) driver.findElementByAccessibilityId("sw_setting_auto_login");
		
		//자동로그인 off
		if (sw_setting_auto_login2.getAttribute("value").equals("1")) {
			sw_setting_auto_login2.click();
		}
		
		MobileElement Back2 = (MobileElement) driver.findElementByAccessibilityId("Back");
		Back2.click();
		app_func.delay(driver, "id", "btn info blue", 30);
	
		app_func.login_server(driver,  "auto_login_test",  "admin123!", 0, 0);
		app_func.logout_server(driver);
		
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		int temp2 = app_func.login_confirm(driver, "logout");
		if (temp2 == 1) {
			assertTrue(false);
		}
		}catch(Exception e) {
			driver.terminateApp("com.soosanint.ewalker.vpn.v10");
			
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T02 종료");
	}
}
