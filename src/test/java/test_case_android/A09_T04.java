package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A09_T04 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A09_T04_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A09_T04 실행");
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		test_func.connect_server(driver, "172.16.150.32", "443");
		
		//틀린 OTP 입력 시 RADIUS, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		test_func.regist_otp_key(driver, "radius_user", "admin123!", "12345678900");
		
		test_func.login_server(driver, "radius_user", "admin123!", 3, 0);

		if (test_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 RADIUS, OTP(내부, 모바일) 사용자 로그인됨을 확인
		test_func.regist_otp_key(driver, "radius_user", "admin123!", "1234567890");
		
		test_func.login_server(driver, "radius_user", "admin123!", 3, 0);
		
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
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A09_T04 종료");
	}

}
