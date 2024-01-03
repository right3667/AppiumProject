package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resouce.func_appium_android;
import resouce.func_selenium;

public class A03_T03 {
	func_selenium web_func = new func_selenium();
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	String server_ip = "172.16.150.21";
	String server_port = "443";
	
	public void A03_T03_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T03 실행");
		
		//웹 설정
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		
		
		ChromeOptions options = new ChromeOptions();
    	options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    	
    	WebDriver webdriver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(webdriver, 10);
    	
		String user_id = "pw_expired";
		String old_pw = "admin123!";
		String new_pw = "admin123!!";
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "pw_expired 사용자 패스워드 만료 설정");
				
		web_func.pw_expire(webdriver, server_ip, user_id, old_pw);
		webdriver.close();
		
		app_func.sleep(driver, 1);
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID").sendKeys(user_id);
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword").sendKeys(old_pw);
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect").click();
		/*
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.widget.EditText[1]").sendKeys(user_id);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.widget.EditText[2]").sendKeys(old_pw);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button").click();
		*/
		app_func.sleep(driver, 2);
		//패스워드 변경 테스트
		
		//1. 비밀번호 변경 화면 표시여부 확인
		
		if (app_func.delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/et_oldpw", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시되지 않음");
			assertTrue(false);
		}
		
		//2. 틀린 '기존 패스워드' 입력 시 변경되지 않음 확인 (10.0.0.17 버전에서 버그 존재함)
		app_func.change_pw(driver, "admin1asd23!!", new_pw, new_pw);
		
		//3. '새로운 비밀번호', '다시 입력' 이 서로 다를 경우 변경되지 않음 확인
		
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID").sendKeys(user_id);
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword").sendKeys(old_pw);
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect").click();
		
		/*
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.widget.EditText[1]").sendKeys(user_id);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.widget.EditText[2]").sendKeys(old_pw);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button").click();
		 */
		app_func.sleep(driver, 2);
		app_func.change_pw(driver, old_pw, "admin123!!!", "admin123!");
		
		//4. 정상 입력 후 비밀번호 변경 확인
		app_func.sleep(driver, 2);
		app_func.change_pw(driver, old_pw, new_pw, new_pw);

		app_func.login_server(driver, user_id, new_pw, 0, 0);
		
		app_func.connect_ping_chk(driver, "30.0.0.5");
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A03_T03 종료");
	}
	
	
}
