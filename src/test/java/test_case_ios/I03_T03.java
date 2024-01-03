package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;
import resouce.func_selenium;

public class I03_T03 {
	func_selenium web_func = new func_selenium();
	func_appium_ios app_func = new func_appium_ios();
		
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void I03_T03_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T03 실행");

		//웹 설정
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
    	ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	
    	WebDriver webdriver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(webdriver, 10);
		
		String user_id = "pw_expired";
		String old_pw = "admin123!";
		String new_pw = "admin123!!";
		
		web_func.pw_expire(webdriver, server_ip, user_id, old_pw);
		webdriver.close();
		
		app_func.sleep(driver, 3);

		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		app_func.connect_server(driver, server_ip, server_port);
		
		MobileElement tf_login_id = (MobileElement) driver.findElementByAccessibilityId("tf_login_id");
		tf_login_id.clear();
		tf_login_id.sendKeys(user_id);
		MobileElement tf_login_passwd = (MobileElement) driver.findElementByAccessibilityId("tf_login_passwd");
		tf_login_passwd.sendKeys(old_pw);
		MobileElement btn_login_ok = (MobileElement) driver.findElementByAccessibilityId("btn_login_ok");
		btn_login_ok.click();
		app_func.sleep(driver, 2);
		
		//패스워드 변경 테스트
		//1. 비밀번호 변경 화면 표시여부 확인
		if (app_func.delay(driver, "id", "btn_passwd_pp_ok", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시되지 않음");
			assertTrue(false);
		}
		
		//2. 틀린 '기존 패스워드' 입력 시 변경되지 않음 확인
		if (app_func.change_pw(driver, "admin1asd23!!", new_pw, new_pw) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "변경 됨");
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경되지 않음");
		}
				
		//3. '새로운 비밀번호', '다시 입력' 이 서로 다를 경우 변경되지 않음 확인
		if (app_func.change_pw(driver, "admin123!", "admin123!", new_pw) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "변경 됨");
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경되지 않음");
		}
		
		//4. 정상 입력 후 비밀번호 변경 확인
		if (app_func.change_pw(driver, old_pw, new_pw, new_pw) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경되지 않음");
			assertTrue(false);
		}

		app_func.login_server(driver, user_id, new_pw, 0, 0);
		
		app_func.logout_server(driver);
	
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I03_T03 종료");
	}
}
