package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;


public class A06_T02 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A06_T02_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T02 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.22", "443");
		
		//틀린 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!", "12345678900");
		
		app_func.login_server(driver, "user_mobile_otp", "admin123!", 3, 0);

		if (app_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인됨을 확인
		app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!", "1234567890");
		
		app_func.login_server(driver, "user_mobile_otp", "admin123!", 3, 0);
		
		if (app_func.login_confirm(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A06_T02 종료");
	}
}
