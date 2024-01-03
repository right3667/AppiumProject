package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_android;
import resouce.func_appium_ios;
import resouce.func_selenium;


public class A03_T08 {
	func_selenium web_func = new func_selenium();
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	String change_port = "445";
	
	String destination = "30.0.0.5";
	
	public void A03_T08_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T08 실행");
		
		//앱에서 서버 접속
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		if (app_func.login_confirm(driver) == 0) {
			app_func.logout_server(driver);
		}
		
		if (app_func.connect_server(driver, server_ip, server_port) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.login_server(driver, "default_user", "admin123!", 0, 0) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		if (app_func.login_server(driver, "policy_time_block", "admin123!", 0, 0) == 0) {
			assertTrue(false);
		}
		else {
		}

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T08 종료");
	}
}
