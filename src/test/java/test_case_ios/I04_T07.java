package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class I04_T07 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I04_T07_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T07 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//고유값 차단 사용자 로그인되지 않음 확인
		app_func.login_server(driver, "device_deny_user", "admin123!", 0, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
			assertTrue(false);
		}
		
		app_func.connect_server(driver, "172.16.150.21", "443");
				
		//고유값 허용 사용자 로그인됨을 확인
		app_func.login_server(driver, "device_accept_user", "admin123!", 0, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T07 종료");
	}
}
