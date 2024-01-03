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


public class I11_T02 {
	func_selenium web_func = new func_selenium();
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());

	String server_ip = "172.16.150.40";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	String Certification_login_type = "사설인증서";
	
	public void I11_T02_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I11_T02 실행");
		
		//웹 설정
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 방식 사설인증서 설정");
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
		
		ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	WebDriver webdriver = new ChromeDriver(options);
    	
		if (web_func.certification_login_setting(webdriver, server_ip, Certification_login_type) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "사설인증서 설정 완료");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "사설인증서 설정 실패");
		}
		web_func.logout_manager(webdriver);
		webdriver.close();
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		//사설인증서 로그인 시도 시 로그인되지 않음 확인
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.login_confirm(driver, "login") == 0) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I11_T02 종료");
	}
}
