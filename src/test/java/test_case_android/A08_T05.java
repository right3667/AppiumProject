package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;
import resouce.func_selenium;



public class A08_T05 {
	func_selenium web_func = new func_selenium();
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.30";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	String otp_type = "Mirae OTP";
	
	public void A08_T05_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A08_T05 실행");
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		//웹 설정
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "미래OTP 웹 설정");
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	WebDriver webdriver = new ChromeDriver(options);
    	
		if (web_func.external_otp_setting(webdriver, server_ip, otp_type) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "미래OTP 웹 설정 완료");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "미래OTP 웹 설정 실패");
		}
		web_func.logout_manager(webdriver);
		webdriver.close();
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.30", "443");
		
		//틀린 OTP 입력 시 AD, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		app_func.login_server(driver, "soosan1", "admin123!", 4, 0);
		
		if (app_func.login_confirm(driver) == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 AD, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		app_func.login_server(driver, "soosan3", "admin123!", 4, 0);
		
		if (app_func.login_confirm(driver) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A08_T05 종료");
	}
}
