package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;

public class I02_T02 {
	
	func_appium_ios app_func = new func_appium_ios();
	Date date_now = new Date(System.currentTimeMillis());

	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void I02_T02_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T02 실행");
		app_func.sleep(driver, 3);
	
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		driver.findElementByAccessibilityId("top icon setting").click();;
	
		//자동로그인 on
		MobileElement sw_setting_auto_login1 = (MobileElement) driver.findElementByAccessibilityId("sw_setting_auto_login");
		if (sw_setting_auto_login1.getAttribute("value").equals("0")) {
			sw_setting_auto_login1.click();
		}
		
		driver.findElementByAccessibilityId("Back").click();
		app_func.delay(driver, "id", "top icon setting", 30);
		
		//로그인 상태에서 앱 종료 후 로그인되는지 확인
		app_func.connect_server(driver, server_ip, server_port);
		
		app_func.login_server(driver, "auto_login_test", "admin123!", 0, 0);
		app_func.logout_server(driver);
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		int temp1 = app_func.login_confirm(driver, "login");
		if (temp1 == 1) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + temp1);
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		driver.findElementByAccessibilityId("top icon setting").click();
		app_func.sleep(driver, 1);

		//자동로그인 off
		MobileElement sw_setting_auto_login2 = (MobileElement) driver.findElementByAccessibilityId("sw_setting_auto_login");
		if (sw_setting_auto_login2.getAttribute("value").equals("1")) {
			sw_setting_auto_login2.click();
		}
		
		driver.findElementByAccessibilityId("Back").click();;
		app_func.delay(driver, "id", "top icon setting", 30);
	
		app_func.login_server(driver,  "auto_login_test",  "admin123!", 0, 0);
		app_func.logout_server(driver);
		
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		int temp2 = app_func.login_confirm(driver, "logout");
		if (temp2 == 1) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T02 종료");
	}
}
