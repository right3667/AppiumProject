package test_case_android;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;
import resouce.func_selenium;


public class A00 {
	func_selenium web_func = new func_selenium();
	func_appium_android test_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());

	String server_ip = "192.168.35.32";
	String server_port = "443";
	String destination = "30.0.0.5";
	
	String otp_type = "Mirae OTP";
	
	public void A00_test(AndroidDriver<AndroidElement> driver) {
		test_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 실행");
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    
    	WebDriver webdriver = new ChromeDriver(options);
    	
    	test_func.sleep(driver, 1);
    	web_func.login_manager(webdriver, server_ip);
    	
    	while(true) {
    			
	    	web_func.encryption_algorithm(webdriver, "ARIA 256");
	    	web_func.encryption_algorithm(webdriver, "SEED");
    	
    	}

    	/*
    	web_func.logout_manager(webdriver);
		webdriver.close();
		test_func.sleep(driver, 1);
	    */				
		
		
		//web_func.logout_manager(webdriver);
		
		//webdriver.close();
				
		
		
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 종료");
	}
}
