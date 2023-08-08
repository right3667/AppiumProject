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

public class A02_T02 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
		
	public void A02_T02_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T02 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		MobileElement setting_auto_login_on = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_auto_login_on.click();
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement auto_login_option_on = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		//자동로그인 on
		if (auto_login_option_on.getAttribute("checked").equals("false")) {
			auto_login_option_on.click();
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 상태에서 앱 종료 후 로그인되는지 확인");
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/setting_menu");
		
		//MobileElement connect_confirm_btn1 = (MobileElement) driver.findElementById("android:id/button1");
		//connect_confirm_btn1.click();
		
		app_func.sleep(driver, 2);
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 30);
		
		if (app_func.login_confirm(driver) == 1) {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그아웃 상태에서 앱 종료 후 로그인되는지 확인");
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/setting_menu");
		
		//MobileElement connect_confirm_btn2 = (MobileElement) driver.findElementById("android:id/button1");
		//connect_confirm_btn2.click();
		app_func.sleep(driver, 2);
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 30);
		
		if (app_func.login_confirm(driver) == 1) {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		MobileElement setting_auto_login_off = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_auto_login_off.click();
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement auto_login_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		if (auto_login_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			auto_login_option_off.click();
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 상태에서 앱 종료 후 로그인되지 않는지 확인");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/setting_menu");
		app_func.sleep(driver, 2);
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 30);
		
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/setting_menu");
		app_func.sleep(driver, 2);
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 30);
		
		
		if (app_func.login_confirm(driver) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + app_func.login_confirm(driver));
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그아웃 상태에서 앱 종료 후 로그인되지 않는지 확인");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		app_func.logout_server(driver);
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/setting_menu");
		
		if (app_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T02 종료");
	}
}
