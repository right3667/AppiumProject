package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class A04_T06 {
	
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
		
	public void A04_T06_case(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T06 실행");
		
		test_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		test_func.connect_server(driver, "172.16.150.21", "443");
		
		//즐겨찾기 팝업 표시 및 브라우저 접속됨을 확인
		test_func.login_server(driver, "favorite_user", "admin123!", 0, 0);
		
		if (test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		MobileElement naver_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		naver_url.click();
		
		test_func.delay(driver, "id", "com.android.chrome:id/url_bar", 5);
		
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
		
		if (test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		MobileElement nate_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		nate_url.click();
		test_func.delay(driver, "id", "com.android.chrome:id/url_bar", 5);
		MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		if (url_bar_2.getText().contains("nate")) {
			driver.terminateApp("com.android.chrome");
		}
		else {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		//즐겨찾기 미등록 계정으로 로그인 시 팝업 및 버튼 없음 확인
		test_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (test_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
			assertTrue(false);
		}
		
		if (test_func.delay(driver, "id", "북마크", 5) == 0) {
			assertTrue(false);
		}
		
		test_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A04_T06 종료");
	}
}
