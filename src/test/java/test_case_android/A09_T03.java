package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;


public class A09_T03 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A09_T03_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A09_T03 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.44", "443");
		
		//틀린 OTP 입력 시 RADIUS, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "radius_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("radius_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		app_func.sleep(driver, 1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		app_func.delay(driver, "id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (app_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 RADIUS, OTP(내부, sms) 사용자 로그인됨을 확인
		app_func.login_server(driver, "radius_user", "admin123!", 2, 0);
		
		if (app_func.login_confirm(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A09_T03 종료");
	}
}
