package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class I03_T01 {
	
	func_appium_ios test_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I03_T01_case(IOSDriver<IOSElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T01 실행");
		
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		test_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		MobileElement app_setting_btn1 = (MobileElement) driver.findElementByAccessibilityId("btn setting blue");
		app_setting_btn1.click();
		
		MobileElement Back1 = (MobileElement) driver.findElementByAccessibilityId("Back");
		Back1.click();
		test_func.delay(driver, "id", "btn info blue", 30);
		
		//로그인 상태에서 앱 종료 후 로그인되는지 확인
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		test_func.login_server(driver, "auto_login_test", "admin123!", 0, 0);
		
		test_func.logout_server(driver);
		
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		
		test_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		//user_mobile_block
		int temp1 = test_func.login_confirm(driver, "login");
		if (temp1 == 1) {
			assertTrue(false);
		}
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T01 종료");
	}
}
