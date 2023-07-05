package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class A02_T03 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());

	public void A02_T03_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T03 실행");
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");

		//VPN 접속 후 창 닫기 on
		MobileElement setting_close_window_on = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_close_window_on.click();
		
		test_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_on = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		if (close_window_option_on.getAttribute("checked").equals("false")) {
			close_window_option_on.click();
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫힘 확인
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		test_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		test_func.sleep(driver, 3);
		
		if	(test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
		}
		
		driver.activateApp("kr.co.soosan.vpn.client.v10");
		
		test_func.logout_server(driver);
		
		//VPN 접속 후 창 닫기 off
		MobileElement setting_close_window_off = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_close_window_off.click();
		
		test_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		if (close_window_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			close_window_option_off.click();
		}
		

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫히지 않음 확인
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		test_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		test_func.sleep(driver, 3);
		
		if	(test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T03 종료");
	}
}
