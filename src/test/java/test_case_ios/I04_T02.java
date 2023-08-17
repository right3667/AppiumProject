package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import function.func_selenium;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class I04_T02 {
	
	func_appium_ios app_func = new func_appium_ios();
	func_selenium web_func = new func_selenium();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I04_T02_case(IOSDriver<IOSElement> driver) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T02 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		if (app_func.login_server(driver, "policy_mobile_block", "admin123!", 0, 0) == 0) {
			assertTrue(false);
		}
		else{
		}
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		if (app_func.login_server(driver, "default_user", "admin123!", 0, 0) == 0) {
		}
		else{
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T02 종료");
	}
}
