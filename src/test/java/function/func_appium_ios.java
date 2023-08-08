package function;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;

public class func_appium_ios {

	public static void main(String[] args) {
	}

	
	
	public int regist_otp_key(IOSDriver<IOSElement> driver, String id, String pw, String otp_key) {
		
		int result = 1;
		
		delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/btnRegistOTPKey", 10);
		MobileElement btnRegistOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnRegistOTPKey");
		btnRegistOTPKey.click();
		
		delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editUserID", 10);
		
		MobileElement editUserID = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		editUserID.clear();
		editUserID.sendKeys(id);
		MobileElement editPassword = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		editPassword.clear();
		editPassword.sendKeys(pw);
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPKey");
		editOTPKey.clear();
		editOTPKey.sendKeys(otp_key);
		
		MobileElement reg_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		reg_confirm_btn.click();
		
		delay(driver, "id", "android:id/button1", 10);
		
		MobileElement confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		MobileElement confirm_msg = (MobileElement) driver.findElementById("android:id/message");
		if (confirm_msg.getText().contains("등록하였습니다.")) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		confirm_btn.click();

		return result;
	}
	
	public int connect_destination_safari (IOSDriver<IOSElement> driver) {
		
		int result = 1;
		
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "1");
		
		start_app(driver, "com.apple.mobilesafari", "TabBarItemTitle");
		
		driver.findElementByAccessibilityId("TabBarItemTitle").click();
		driver.findElementByAccessibilityId("delete").click();
		driver.findElementByAccessibilityId("more").click();
		
		driver.findElementByAccessibilityId("3").click();
		driver.findElementByAccessibilityId("0").click();
		driver.findElementByAccessibilityId(".").click();
		driver.findElementByAccessibilityId("0").click();
		driver.findElementByAccessibilityId(".").click();
		driver.findElementByAccessibilityId("0").click();
		driver.findElementByAccessibilityId(".").click();
		driver.findElementByAccessibilityId("5").click();
		driver.findElementByAccessibilityId("Go").click();
		
		if (delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.TextView[1]", 10) == 0) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		
		/*
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("옵션 더보기");
		el1.click();
		
		delay(driver, "id", "com.android.chrome:id/new_incognito_tab_menu_id", 5);
		
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("새 시크릿 탭");
		el2.click();
		
		delay(driver, "id", "com.android.chrome:id/url_bar", 5);
		
		MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		url_bar_1.click();
		url_bar_1.sendKeys("30.0.0.5");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		if (delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.TextView[1]", 10) == 0) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		url_bar_2.click();
		url_bar_2.sendKeys("30.0.0.5/test");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		if (delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.TextView[1]", 10) == 0) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		if (result == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "chrome 목적지 연결됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "chrome 목적지 연결되지 않음");
		}
		
		driver.terminateApp("com.android.chrome");
		*/
		return result;
	}
	
	public int connect_ping_chk (AndroidDriver<AndroidElement> driver, String host) {
		int result;
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		//start_app(driver, "com.deftapps.ping", "btn info blue");
		
		MobileElement editTextHost = (MobileElement) driver.findElementById("com.lipinic.ping:id/editTextHost");
		editTextHost.sendKeys(host);
		MobileElement btnStart = (MobileElement) driver.findElementById("com.lipinic.ping:id/btnStart");
		btnStart.click();
		
		//delay(driver, "id", "com.lipinic.ping:id/txtResult", 30);
		
		MobileElement txtResult = (MobileElement) driver.findElementById("com.lipinic.ping:id/txtResult");
		if (txtResult.getText().contains("icmp")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + host + " ping 연결됨");
			result = 0;
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + host + " ping 연결되지 않음");
			result = 1;
		}
		
		driver.terminateApp("com.lipinic.ping");
		
		return result;
	}
	
	public int login_confirm(IOSDriver<IOSElement> driver, String check) {
		int result;
		
		if (check == "login") {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("VPN 연결 종료")));
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그인");
				result = 0;
			}catch (Exception e) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그아웃");
				result = 1;
			}
		}
		else {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("VPN 서버 접속")));
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그아웃");
				result = 0;
			}catch (Exception e) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그인");
				result = 1;
			}
		}
		
		return result;
	}
	
	
	public void activate_app(IOSDriver<IOSElement> driver, String app_name, String app_object) {
		driver.activateApp(app_name);
		delay(driver, "id", app_object, 30);
	}
	
	public void start_app(IOSDriver<IOSElement> driver, String bundleid, String app_object) {
		//미래 otp: com.dreammirae.anyauth.ios
		//eWalker ssl vpn v10: com.soosanint.ewalker.vpn.v10
		driver.terminateApp(bundleid);
		
		driver.activateApp(bundleid);
		delay(driver, "id", app_object, 30);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + bundleid + " 앱 실행 완료");
	}
	
	public int delay(IOSDriver<IOSElement> driver, String object_type, String object_name, int minute) {
		
		int result = 0;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, minute);
			
			if(object_type == "id") {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(object_name)));
			}
			else if(object_type == "xpath") {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object_name)));
			}
		}catch (Exception e) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "객체를 찾지 못했습니다.");
			result = 1;
		}
		
		return result;
	}
	
	public void sleep(IOSDriver<IOSElement> driver, int minute) {
		minute = minute * 1000;
		try {
			Thread.sleep(minute); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void connect_server(IOSDriver<IOSElement> driver, String url_ip, String port) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 접속 시도: " + url_ip + " / " + port);
				
		MobileElement app_setting_btn = (MobileElement) driver.findElementByAccessibilityId("btn setting blue");
		app_setting_btn.click();
		
		MobileElement ip_port_setting = (MobileElement) driver.findElementByAccessibilityId("btn_setting_change");
		ip_port_setting.click();
		
		MobileElement tf_server_pp_ip = (MobileElement) driver.findElementByAccessibilityId("tf_server_pp_ip");
		tf_server_pp_ip.clear();
		tf_server_pp_ip.sendKeys(url_ip);
		MobileElement tf_server_pp_port = (MobileElement) driver.findElementByAccessibilityId("tf_server_pp_port");
		tf_server_pp_port.clear();
		tf_server_pp_port.sendKeys(port);
		MobileElement btn_server_pp_ok = (MobileElement) driver.findElementByAccessibilityId("btn_server_pp_ok");
		btn_server_pp_ok.click();
		MobileElement Back = (MobileElement) driver.findElementByAccessibilityId("Back");
		Back.click();
		
		delay(driver, "id", "btn info blue", 30);
		
	}
	
	public int login_server(IOSDriver<IOSElement> driver, String user_id, String user_pw, int login_type, int select_policy) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + user_id + " / " + user_pw);
		int result = 1;
		MobileElement tf_login_id = (MobileElement) driver.findElementByAccessibilityId("tf_login_id");
		tf_login_id.clear();
		tf_login_id.sendKeys(user_id);
		MobileElement tf_login_passwd = (MobileElement) driver.findElementByAccessibilityId("tf_login_passwd");
		tf_login_passwd.sendKeys(user_pw);
		MobileElement btn_login_ok = (MobileElement) driver.findElementByAccessibilityId("btn_login_ok");
		btn_login_ok.click();
		
		//로그인 형태
		if (login_type == 0) {
		}
		
		else if (login_type == 1) {
			
		}
		
		else if (login_type == 2) {
			sleep(driver, 1);
			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/textinput_helper_text", 10);
			
			MobileElement btnIssueOTPNumber = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnIssueOTPNumber");
			btnIssueOTPNumber.click();
			
			delay(driver, "id", "android:id/contentPanel", 10);
			
			MobileElement send_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			send_confirm_btn.click();
			
			//start_app(driver, "com.sise15.mysqlviewer", "com.sise15.mysqlviewer.MainActivity","com.sise15.mysqlviewer:id/textView2");
			
			MobileElement textView2 = (MobileElement) driver.findElementById("com.sise15.mysqlviewer:id/textView2");
			textView2.click();
			
			delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView", 30);
			
			sleep(driver, 1);
			
			MobileElement table_select = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView");
			table_select.click();
			
			delay(driver, "id", "com.sise15.mysqlviewer:id/query", 30);
			
			sleep(driver, 1);
			
			MobileElement query_edit = (MobileElement) driver.findElementById("com.sise15.mysqlviewer:id/query");
			query_edit.sendKeys("select * from smstest");
			MobileElement done = (MobileElement) driver.findElementByAccessibilityId("Done");
			done.click();
			
			delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[1]", 30);
			
			sleep(driver, 1);
			
			MobileElement otp_key_db = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[1]");
			String otpvar = otp_key_db.getText().replace("[", "");
			otpvar = otpvar.replace("]", "");
			
			query_edit.clear();
			query_edit.sendKeys("delete from smstest");
			done.click();
			
			driver.terminateApp("com.sise15.mysqlviewer");
			
			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			sleep(driver, 1);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
			
		}
		
		else if (login_type == 3) {
			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			//start_app(driver, "com.sgn.secureguardotplite", "com.sgn.sgotp.activity.SplashActivity","com.sgn.secureguardotplite:id/textOtp");
			
			MobileElement otp_var = (MobileElement) driver.findElementById("com.sgn.secureguardotplite:id/textOtp");
			String otpvar = otp_var.getText();

			driver.terminateApp("com.sgn.secureguardotplite");
			
			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
		}
		
		else if (login_type == 4) {
			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			activate_app(driver, "com.dreammirae.anyauth.android", "com.dreammirae.anyauth.android:id/txt_pattern_info");
			
			TouchAction actionOne = new TouchAction(driver);
			actionOne.press(PointOption.point(184, 968)).moveTo(PointOption.point(904, 968)).moveTo(PointOption.point(904, 1688)).release();
			actionOne.perform();
			
			MobileElement otp_key_mirae = (MobileElement) driver.findElementById("com.dreammirae.anyauth.android:id/otp");
			String otpvar = otp_key_mirae.getText().replace(" ", "");
			
			driver.terminateApp("com.dreammirae.anyauth.android");

			delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
			
		}
		
		// 멀티정책 선택
		if (select_policy != 0) {
			delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]", 30);
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "다중 SSL 정책 로그인 시도: " + select_policy + "번 정책");
			
			MobileElement redirect_policy_select = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[" + select_policy + "]");
			redirect_policy_select.click();
		}
		
		result = login_confirm(driver, "login");
		return result;
	}
	
	public int change_pw(IOSDriver<IOSElement> driver, String oldpw, String chpw1, String chpw2) {
		int result = 1;
		MobileElement et_oldpw = (MobileElement) driver.findElementById("tf_passwd_pp_current");
		et_oldpw.sendKeys(oldpw);
		MobileElement et_chpw1 = (MobileElement) driver.findElementById("tf_passwd_pp_new");
		et_chpw1.sendKeys(chpw1);
		MobileElement et_chpw2 = (MobileElement) driver.findElementById("tf_passwd_pp_check_new");
		et_chpw2.sendKeys(chpw2);
		MobileElement btn_confirm_chpw = (MobileElement) driver.findElementById("btn_passwd_pp_ok");
		btn_confirm_chpw.click();

		//delay(driver, "id", "확인", 5);
		
		try {
			MobileElement chpw_message = (MobileElement) driver.findElementById("현재 비밀 번호를 입력하시기 바랍니다.");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "현재 비밀 번호를 입력하시기 바랍니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		try {
			MobileElement chpw_message = (MobileElement) driver.findElementById("비밀번호 변경을 실패하였습니다. 기존 비밀번호를 확인하시기 바랍니다.");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "비밀번호 변경을 실패하였습니다. 기존 비밀번호를 확인하시기 바랍니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		try {
			MobileElement chpw_message = (MobileElement) driver.findElementById("새 비밀 번호와 일치하지 않습니다. ");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "새 비밀 번호와 일치하지 않습니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		/* 해당 메시지를 아이폰에서 찾지 못하여 확인 버튼 클릭 후 다른 엘리먼트로 확인
		try {
			MobileElement chpw_message = (MobileElement) driver.findElementById("비밀번호가 변경되었습니다. 다시 로그인 해주시기 바랍니다. ");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "비밀번호가 변경되었습니다. 다시 로그인 해주시기 바랍니다.");
			result = 0;
		}catch (Exception e) {
			result = 1;
		}
		*/
				
		TouchAction actionOne = new TouchAction(driver);
		actionOne.tap(PointOption.point(185, 450)).perform(); //아이디 존재하지 않아 임시 버튼 클릭
		
		MobileElement chpw_check = (MobileElement) driver.findElementById("btn info blue");
		if (chpw_check.isDisplayed() == true) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "비밀번호가 변경되었습니다. 다시 로그인 해주시기 바랍니다.");
			result = 0;
		}
		else {
			result = 1;
		}
		
		/*
		MobileElement btn_confirm_alert = (MobileElement) driver.findElementById("확인");
		btn_confirm_alert.click();
		*/
		
		return result;
	}
	
	public void logout_server(IOSDriver<IOSElement> driver) {
		MobileElement btn_login_ok = (MobileElement) driver.findElementByAccessibilityId("btn_login_ok");
		btn_login_ok.click();
		
		
		MobileElement check = (MobileElement) driver.findElementByAccessibilityId("확인");
		check.click();
		sleep(driver, 1);
		//login_confirm(driver, "logout");
	}
}

