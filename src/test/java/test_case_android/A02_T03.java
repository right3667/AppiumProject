package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import resouce.func_appium_android;

public class A02_T03 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());

	public void A02_T03_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T03 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");

		//VPN 접속 후 창 닫기 on
		//setting button
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/setting_menu").click();
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.widget.Button").click();
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_on = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		if (close_window_option_on.getAttribute("checked").equals("false")) {
			close_window_option_on.click();
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫힘 확인
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		app_func.sleep(driver, 3);
		
		if	(app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/setting_menu", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
		}
		
		driver.activateApp("kr.co.soosan.vpn.client.v10");
		
		app_func.logout_server(driver);
		
		//VPN 접속 후 창 닫기 off
		//setting button
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/setting_menu", 5);
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/setting_menu").click();
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.widget.Button").click();
				
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.Switch");
		
		if (close_window_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			close_window_option_off.click();
		}
		

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫히지 않음 확인
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		app_func.sleep(driver, 3);
		
		if	(app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/setting_menu", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T03 종료");
	}
}
