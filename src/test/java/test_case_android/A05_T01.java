package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;
import resouce.func_selenium;


public class A05_T01 {
	
	func_appium_android app_func = new func_appium_android();
	func_selenium web_func = new func_selenium();
		
	Date date_now = new Date(System.currentTimeMillis());
	
	public void A05_T01_case(AndroidDriver<AndroidElement> driver) {
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A05_T01 실행");
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
    	ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	
    	WebDriver webdriver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(webdriver, 10);
		
	    String encryption_algorithm = "AES 192";
	    String server_ip = "172.16.150.20";
	    
	    web_func.login_manager(webdriver, server_ip);
	    web_func.encryption_algorithm(webdriver, encryption_algorithm);
	    web_func.logout_manager(webdriver);	    
	    webdriver.close();
	    
		app_func.sleep(driver, 3);
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//로컬 사용자 로그인
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);

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
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A05_T01 종료");
	}
}
