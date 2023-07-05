package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A04_T09 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A04_T09_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T09 실행");
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		//per app 정책 적용 확인(ping 앱에서 목적지 통신되지 않음 확인)
		test_func.login_server(driver, "per_app_user", "admin123!", 0, 0);
		
		if (test_func.connect_destination_chrome(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (test_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		//모든 앱에서 통신됨을 확인 (chrome, ping)
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		test_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (test_func.connect_destination_chrome(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (test_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T09 종료");
	}
}
