package test_case_mac;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;


import function.func_appium_ios;
import function.func_selenium;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class M04_T01 {
	
	func_appium_ios app_func = new func_appium_ios();
	func_selenium web_func = new func_selenium();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I04_T01_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T01 실행");
		
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.sleep(driver, 5);
		
		
		
		
		/*
		//split user 테스트
		app_func.connect_server(driver, "172.16.150.21", "443");

		app_func.login_server(driver, "split_user", "admin123!", 0, 0);
		
		if (app_func.connect_ping_chk(driver, "google.co.kr") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		//non-split user 테스트
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "non_split_user", "admin123!", 0, 0);
		
		if (app_func.connect_ping_chk(driver, "google.co.kr") == 0) {
			assertTrue(false);
		}
		else {
		}
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		*/
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T01 종료");
	}
}
