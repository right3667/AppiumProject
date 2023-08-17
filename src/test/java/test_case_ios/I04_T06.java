package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class I04_T06 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
		
	public void I04_T06_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T06 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//즐겨찾기 팝업 표시 및 브라우저 접속됨을 확인
		app_func.login_server(driver, "favorite_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "즐겨찾기", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		driver.findElementByAccessibilityId("https://www.naver.com").click();
		
		
		app_func.delay(driver, "id", "TabBarItemTitle", 30);
		
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
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "즐겨찾기", 5) == 0) {
			assertTrue(false);
		}
		
		if (app_func.delay(driver, "id", "top icon bookmark", 5) == 0) {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		/*
		MobileElement naver_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		naver_url.click();
		
		app_func.delay(driver, "id", "com.android.chrome:id/url_bar", 5);
		
		MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		if (url_bar_1.getText().contains("naver")) {
			driver.terminateApp("com.android.chrome");
		}
		else {
			assertTrue(false);
		}
		
		//즐겨찾기 버튼 클릭 후 접속 시도
		MobileElement favorite_btn = (MobileElement) driver.findElementByAccessibilityId("북마크");
		favorite_btn.click();
		
		if (app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		MobileElement nate_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		nate_url.click();
		app_func.delay(driver, "id", "com.android.chrome:id/url_bar", 5);
		MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		if (url_bar_2.getText().contains("nate")) {
			driver.terminateApp("com.android.chrome");
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		//즐겨찾기 미등록 계정으로 로그인 시 팝업 및 버튼 없음 확인
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
			assertTrue(false);
		}
		
		if (app_func.delay(driver, "id", "북마크", 5) == 0) {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		*/
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T06 종료");
	}
}
