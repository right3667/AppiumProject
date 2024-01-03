package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;


public class I09_T01 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.31";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	public void I09_T01_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I09_T01 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		//RADIUS 사용자 로그인
		app_func.login_server(driver, "radius_user", "admin123!", 0, 0);

		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, destination) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I09_T01 종료");
	}
}
