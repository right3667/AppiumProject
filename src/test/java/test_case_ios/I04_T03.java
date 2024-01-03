package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;

public class I04_T03 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void I04_T03_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T03 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		//멀티정책 유저 접속 (redirect url 정책 접속)
		app_func.login_server(driver, "multi_pol_user", "admin123!", 0, 5);
		
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		
		MobileElement TabBarItemTitle = (MobileElement) driver.findElementById("TabBarItemTitle");
		
		if (TabBarItemTitle.getText().contains("naver")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "URL 이동됨");
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T03 종료");
	}
}
