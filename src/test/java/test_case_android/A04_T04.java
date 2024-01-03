package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;

public class A04_T04 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A04_T04_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T04 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//idle time 적용 테스트 (약 3분 동안 목적지 접속 후 5분 뒤 종료 여부 확인)
		app_func.login_server(driver, "idle_time_user", "admin123!", 0, 0);
		
		for(int i=1; i<=10; i++) {
			app_func.connect_destination_chrome(driver);
			app_func.connect_ping_chk(driver, "30.0.0.5");
		}
		
		if (app_func.delay(driver, "id", "android:id/button1", 310) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("android:id/button1");
			idle_time_alert_btn.click();
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
			assertTrue(false);
		}
		
		//idle time 미적용 테스트 (330 초 동안 종료되지 않음 확인)
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "android:id/button1", 330) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("android:id/button1");
			idle_time_alert_btn.click();
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T04 종료");
	}
}
