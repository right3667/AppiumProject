package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class A03_T03 {
	
	func_appium_android test_func = new func_appium_android();
	
	A03_T03_webconf test = new A03_T03_webconf();
	
	Date date_now = new Date(System.currentTimeMillis());

	public void A03_T03_case(AndroidDriver<AndroidElement> driver) {
		
		test.pw_expire();
		
		test_func.sleep(driver, 3);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T03 실행");
		
		
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		MobileElement user_id_edit1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit1.sendKeys("pw_expired");
		MobileElement user_pw_edit1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit1.sendKeys("admin123!");
		MobileElement login_btn1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn1.click();
		test_func.sleep(driver, 2);
		//패스워드 변경 테스트
		
		//1. 비밀번호 변경 화면 표시여부 확인
		
		if (test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/et_oldpw", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시되지 않음");
			assertTrue(false);
		}
		
		//2. 틀린 '기존 패스워드' 입력 시 변경되지 않음 확인 (10.0.0.17 버전에서 버그 존재함)
		test_func.change_pw(driver, "admin123!!", "admin123!!", "admin123!!");
		
		//3. '새로운 비밀번호', '다시 입력' 이 서로 다를 경우 변경되지 않음 확인
		MobileElement user_id_edit2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit2.sendKeys("pw_expired");
		MobileElement user_pw_edit2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit2.sendKeys("admin123!");
		MobileElement login_btn2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn2.click();
		test_func.sleep(driver, 2);
		test_func.change_pw(driver, "admin123!", "admin123!!", "admin123!");
		
		//4. 정상 입력 후 비밀번호 변경 확인
		test_func.sleep(driver, 2);
		test_func.change_pw(driver, "admin123!", "admin123!!", "admin123!!");

		test_func.login_server(driver, "pw_expired", "admin123!!", 0, 0);
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T03 종료");
	}
	
	
}
