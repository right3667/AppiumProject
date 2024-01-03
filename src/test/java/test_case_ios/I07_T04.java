package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import resouce.func_appium_ios;


public class I07_T04 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.25";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	public void I07_T04_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I07_T04 실행");

		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		//틀린 OTP 입력 시 DB, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		app_func.regist_otp_key(driver, "odb_user", "admin123!", "12345678900");
		
		app_func.login_server(driver, "odb_user", "admin123!", 3, 0);

		if (app_func.login_confirm(driver, "login") == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 DB, OTP(내부, 모바일) 사용자 로그인됨을 확인
		app_func.regist_otp_key(driver, "odb_user", "admin123!", "1234567890");
		
		app_func.login_server(driver, "odb_user", "admin123!", 3, 0);
		
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
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I07_T04 종료");
	}
}
