package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;


public class I06_T05 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.41";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	public void I06_T05_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I06_T05 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		app_func.delay(driver, "id", "tf_login_id", 5);
		
		//틀린 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "default_user" + " / " + "admin123!");
		driver.findElementByAccessibilityId("tf_login_id").sendKeys("default_user");
		driver.findElementByAccessibilityId("tf_login_passwd").sendKeys("admin123!");
		driver.findElementByAccessibilityId("btn_login_ok").click();
		
		app_func.delay(driver, "id", "tf_otp_pp_key", 20);
		
		driver.findElementByAccessibilityId("tf_otp_pp_key").sendKeys("112233");
		driver.findElementByAccessibilityId("btn_otp_pp_ok").click();
		
		app_func.sleep(driver, 3);
		
		if (app_func.login_confirm(driver, "login") == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인됨을 확인
		app_func.login_server(driver, "default_user", "admin123!", 2, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.connect_ping_chk(driver, destination);
		
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I06_T05 종료");
	}
}
