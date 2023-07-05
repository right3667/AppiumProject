package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A10_T01 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A10_T01_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A10_T01 실행");
		
		if (test_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		test_func.connect_server(driver, "172.16.150.34", "443");
		
		//LDAP 사용자 로그인
		test_func.login_server(driver, "ldap_user", "admin123!", 0, 0);

		if (test_func.login_confirm(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (test_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A10_T01 종료");
	}
}
