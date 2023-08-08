package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A04_T05 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A04_T05_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T05 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//redirect url 접속됨을 확인
		app_func.login_server(driver, "redirect_url_user", "admin123!", 0, 2);
		
		if (app_func.delay(driver, "id", "com.android.chrome:id/url_bar", 10) == 0) {
			MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
			
			if (url_bar_1.getText().contains("naver")) {
			}
			else {
				assertTrue(false);
			}
		}
		else {
			assertTrue(false);
		}
		
		driver.terminateApp("com.android.chrome");
		
		app_func.logout_server(driver);
		
		//redirect url 접속됨을 확인
		app_func.login_server(driver, "redirect_url_user", "admin123!", 0, 1);
		
		if (app_func.delay(driver, "id", "com.android.chrome:id/url_bar", 10) == 0) {
			MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
			
			if (url_bar_2.getText().contains("naver")) {
			}
			else {
				assertTrue(false);
			}
		}
		else {
			assertTrue(false);
		}
		
		driver.terminateApp("com.android.chrome");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T05 종료");
	}
}
