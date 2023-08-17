package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class I07_T03 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I07_T03_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I07_T03 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.42", "443");
		
		app_func.delay(driver, "id", "tf_login_id", 5);
		
		//틀린 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "odb_user" + " / " + "admin123!");
		driver.findElementByAccessibilityId("tf_login_id").sendKeys("odb_user");
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
		app_func.login_server(driver, "odb_user", "admin123!", 2, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.connect_ping_chk(driver, "30.0.0.5");
		
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I07_T03 종료");
	}
}
