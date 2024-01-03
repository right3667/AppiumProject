package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;


public class I04_T05 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	public void I04_T05_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T05 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		app_func.login_server(driver, "redirect_url_user", "admin123!", 0, 2);
				
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		
		if (driver.findElementById("TabBarItemTitle").getText().contains("naver")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "URL 이동됨");
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		app_func.logout_server(driver);
		
		
		app_func.connect_server(driver, server_ip, server_port);
		app_func.login_server(driver, "redirect_url_user", "admin123!", 0, 1);
		
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		
		if (driver.findElementById("TabBarItemTitle").getText().contains("naver")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "URL 이동됨");
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T05 종료");
	}
}
