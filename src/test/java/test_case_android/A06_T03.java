package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;


public class A06_T03 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A06_T03_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T03 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.22", "443");
		
		// ID/PW 정상일 경우 변경됨을 확인
		if (app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!", "1234567890") == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경됨을 확인");
		}
		else {
			assertTrue(false);
		}
		
		// ID가 틀릴 경우 변경되지 않음 확인
		if (app_func.regist_otp_key(driver, "user_mobile_otp2", "admin123!", "1234567890") == 0) {
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경되지 않음 확인");
		}
		
		// PW가 틀릴 경우 변경되지 않음 확인
		if (app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!!", "1234567890") == 0) {
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경되지 않음 확인");
		}
		
		/*
		// OTP 키 값이 빈 값인 경우 초기화됨 (현재 동작되지 않음)
		if (app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!!", "1234567890") == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "초기화 됨");
		}
		else {
			
			assertTrue(false);
		}
		*/
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T03 종료");
	}
}
