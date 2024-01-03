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


public class I03_T04 {
	func_selenium web_func = new func_selenium();
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void I03_T04_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T04 실행");
		
		//앱에서 서버 접속
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		app_func.connect_server(driver, server_ip, server_port);
		
		//웹 서버 시스템 점검 활성화
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
				
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		    	
	 	WebDriver webdriver1 = new ChromeDriver(options);
		
		web_func.sys_inspection(webdriver1, server_ip, 1);
		webdriver1.close();
		
		app_func.sleep(driver, 3);

		if (app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "lb_insp_pp_title") == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "점검 메시지 표시됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "점검 메시지 표시되지 않음");
			assertTrue(false);
		}
		
		//서버 확인 대화상자 및 접속 확인
		driver.findElementByAccessibilityId("확인").click();
		if (app_func.delay(driver, "id", "서버 확인", 3) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 변경 대화상자 표시됨");
			driver.findElementByAccessibilityId("tf_server_pp_ip").clear();
			driver.findElementByAccessibilityId("tf_server_pp_ip").sendKeys("172.16.150.30");
			driver.findElementByAccessibilityId("확인").click();
			
			if (app_func.delay(driver,  "id",  "lb_insp_pp_title", 3) == 0) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 변경되지 않음");
				assertTrue(false);
			}
			else {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 변경됨");
			}
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "점검 메시지 표시되지 않음");
			assertTrue(false);
		}
		
	 	WebDriver webdriver2 = new ChromeDriver(options);
		web_func.sys_inspection(webdriver2, server_ip, 0);
		webdriver2.close();
		
		app_func.sleep(driver, 3);
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.connect_server(driver, server_ip, server_port) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "점검 메시지 표시되지 않음");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "점검 메시지 표시됨");
			assertTrue(false);
		}

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T04 종료");
	}
}
