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

public class A02_T01 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A02_T01_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T01 실행");
		 
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		MobileElement app_setting_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/setting_menu");
		app_setting_btn.click();
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView", 30);
		
		MobileElement host_url_ip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");
		host_url_ip.click();
		app_func.sleep(driver, 1);
		
		MobileElement url_ip_edit = (MobileElement) driver.findElementById("android:id/edit");
		url_ip_edit.clear();
		url_ip_edit.sendKeys("172.16.150.20");
		app_func.sleep(driver, 1);
		
		MobileElement ip_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		ip_confirm_btn.click();
		app_func.sleep(driver, 1);
		
		MobileElement host_port = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
		host_port.click();
		app_func.sleep(driver, 1);
		
		MobileElement port_edit = (MobileElement) driver.findElementById("android:id/edit");
		port_edit.clear();
		port_edit.sendKeys("443");
		app_func.sleep(driver, 1);
		
		MobileElement port_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		port_confirm_btn.click();
		app_func.sleep(driver, 1);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/action_info", 30);
		
		MobileElement enter_ip = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editHost");
		MobileElement enter_port = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPort");
		
		if (enter_ip.getText().equals("172.16.150.20") && enter_port.getText().equals("443")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 주소, 포트가 정상 입력됨");
		}
		else{
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T01 종료");
	}
}
