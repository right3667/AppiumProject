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


public class A03_T06 {
	func_selenium web_func = new func_selenium();
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	String destination = "30.0.0.5";
	
	public void A03_T06_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T06 실행");
		
		//앱에서 서버 접속
		app_func.activate_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10:id/action_info"); //start 시 동작되지 않음
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		if (app_func.login_confirm(driver) == 0) {
			app_func.logout_server(driver);
		}
		
		if (app_func.connect_server(driver, server_ip, server_port) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		//업데이트 사용함 설정
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		
	 	WebDriver webdriver1 = new ChromeDriver(options);
		
		web_func.client_update_setting(webdriver1, server_ip, "android", 1);
		webdriver1.close();
		
		app_func.activate_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10:id/alertTitle"); //start 시 동작되지 않음
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		driver.findElementById("android:id/button1").click();
		
		if (app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/action_info", 5) == 0) {
			assertTrue(false);
		}
		else {
		}
		
		if (app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		//업데이트 사용안함 설정
		WebDriver webdriver2 = new ChromeDriver(options);
		web_func.client_update_setting(webdriver2, server_ip, "android", 0);
		webdriver2.close();
		
		app_func.activate_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10:id/action_info"); //start 시 동작되지 않음
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T06 종료");
	}
}
