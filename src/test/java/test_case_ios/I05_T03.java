package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import function.func_appium_ios;
import function.func_selenium;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class I05_T03 {
	
	func_appium_ios app_func = new func_appium_ios();
	func_selenium web_func = new func_selenium();
		
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I05_T03_case(IOSDriver<IOSElement> driver) {
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I05_T03 실행");
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
    	ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	
    	WebDriver webdriver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(webdriver, 10);
		
	    String encryption_algorithm = "ARIA 128";
	    String server_ip = "172.16.150.20";
	    
	    web_func.login_manager(webdriver, server_ip);
	    web_func.encryption_algorithm(webdriver, encryption_algorithm);
	    web_func.logout_manager(webdriver);	    
	    webdriver.close();
	    
		app_func.sleep(driver, 3);
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//로컬 사용자 로그인
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);

		if (app_func.login_confirm(driver, "login") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.connect_ping_chk(driver, "30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I05_T03 종료");
	}
}
