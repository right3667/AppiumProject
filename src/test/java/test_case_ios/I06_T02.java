package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class I06_T02 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I06_T02_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I06_T02 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.22", "443");
		
		//틀린 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!", "12345678900");
		
		app_func.login_server(driver, "user_mobile_otp", "admin123!", 3, 0);

		if (app_func.login_confirm(driver, "login") == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인됨을 확인
		app_func.connect_server(driver, "172.16.150.22", "443");
		
		app_func.regist_otp_key(driver, "user_mobile_otp", "admin123!", "1234567890");
		
		app_func.login_server(driver, "user_mobile_otp", "admin123!", 3, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I06_T02 종료");
	}
}
