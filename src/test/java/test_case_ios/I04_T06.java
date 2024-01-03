package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;


public class I04_T06 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
		
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void I04_T06_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T06 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		//즐겨찾기 팝업 표시 및 브라우저 접속됨을 확인
		app_func.login_server(driver, "favorite_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "즐겨찾기", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		driver.findElementByAccessibilityId("https://www.naver.com").click();
		
		
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		app_func.sleep(driver, 3);
		if (driver.findElementById("TabBarItemTitle").getText().contains("naver")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "URL 이동됨");
		}
		else {
			assertTrue(false);
		}
		
		//즐겨찾기 버튼 클릭 후 접속 시도
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "즐겨찾기");
		
		app_func.delay(driver, "id", "즐겨찾기", 5);	
		
		driver.findElementByAccessibilityId("확인").click();
		
		app_func.delay(driver, "id", "top icon bookmark", 5);
		
		driver.findElementByAccessibilityId("top icon bookmark").click();
		
		if (app_func.delay(driver, "id", "즐겨찾기", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		driver.findElementByAccessibilityId("https://www.nate.com").click();
		
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		app_func.sleep(driver, 3);
		if (driver.findElementById("TabBarItemTitle").getText().contains("nate")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "URL 이동됨");
		}
		else {
			assertTrue(false);
		}
		
		//즐겨찾기 미등록 계정으로 로그인 시 팝업 및 버튼 없음 확인
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "즐겨찾기");
		
		app_func.delay(driver, "id", "즐겨찾기", 5);	//못찾는 이유 확인 필요
		
		driver.findElementByAccessibilityId("확인").click();
		
		app_func.logout_server(driver);
		
		app_func.connect_server(driver, server_ip, server_port);
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "즐겨찾기", 5) == 0) {
			app_func.sleep(driver, 1);
			assertTrue(false);
		}
		
		if (app_func.delay(driver, "id", "top icon bookmark", 5) == 0) {
			app_func.sleep(driver, 1);
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T06 종료");
	}
}
