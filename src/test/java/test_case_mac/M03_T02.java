package test_case_mac;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;

public class M03_T02 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I03_T02_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T02 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		//try policy block
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		if (app_func.login_server(driver, "user_access_block", "admin123!", 0, 0) == 0) {
			assertTrue(false);
		}
		else{
		}
		
		if (app_func.login_server(driver, "default_user", "admin123!", 0, 0) == 0) {
		}
		else{
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T02 종료");
	}
}
