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


public class I03_T05 {
	func_selenium web_func = new func_selenium();
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	String change_port = "445";
	
	String destination = "30.0.0.5";
	
	public void I03_T05_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T05 실행");
		
		
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
		
		if (app_func.login_server(driver, "default_user", "admin123!", 0, 0) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, destination) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		app_func.logout_server(driver);
		
		//사용자 웹 접속 포트 변경
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
				
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		    	
	 	WebDriver webdriver1 = new ChromeDriver(options);
		
		web_func.server_port_setting(webdriver1, server_ip, change_port);
		webdriver1.close();
		
		app_func.sleep(driver, 3);

		if (app_func.connect_server(driver, server_ip, change_port) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.login_server(driver, "default_user", "admin123!", 0, 0) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, destination) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		app_func.logout_server(driver);
		
		//사용자 웹 접속 포트 변경
	 	WebDriver webdriver2 = new ChromeDriver(options);
	 	web_func.server_port_setting(webdriver2, server_ip, server_port);
		webdriver2.close();
		
		if (app_func.connect_server(driver, server_ip, server_port) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T05 종료");
	}
}
