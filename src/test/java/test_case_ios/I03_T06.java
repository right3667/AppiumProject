package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;
import resouce.func_selenium;


public class I03_T06 {
	func_selenium web_func = new func_selenium();
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	String destination = "30.0.0.5";
	
	public void I03_T06_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T06 실행");
		
		//앱에서 서버 접속
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		if (app_func.connect_server(driver, server_ip, server_port) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		//업데이트 사용함 설정
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		
	 	WebDriver webdriver1 = new ChromeDriver(options);
		
		web_func.client_update_setting(webdriver1, server_ip, "ios", 1);
		webdriver1.close();
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "업데이트 가능");
		
		driver.findElementByAccessibilityId("aler_cancel").click();
		
		if (app_func.delay(driver, "id", "btn info blue", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "업데이트 가능");
		
		driver.findElementByAccessibilityId("aler_ok").click();
		
		if (app_func.delay(driver, "IosClassChain", "**/XCUIElementTypeStaticText[`label == \\\"eWalker SSL VPN\\\"`]", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		//업데이트 사용안함 설정
		WebDriver webdriver2 = new ChromeDriver(options);
		web_func.client_update_setting(webdriver2, server_ip, "ios", 0);
		webdriver2.close();
		
		if (app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T06 종료");
	}
}
