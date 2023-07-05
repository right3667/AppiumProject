package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A06_T05 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A06_T05_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T05 실행");
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		test_func.connect_server(driver, "172.16.150.41", "443");
		
		test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editUserID", 5);
		
		//틀린 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "default_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("default_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		test_func.sleep(driver, 1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		test_func.delay(driver, "id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (test_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인됨을 확인
		test_func.login_server(driver, "default_user", "admin123!", 2, 0);
		
		if (test_func.login_confirm(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T05 종료");
	}
}
