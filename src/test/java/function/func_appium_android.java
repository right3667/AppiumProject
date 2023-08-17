package function;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class func_appium_android {

	public static void main(String[] args) {
	}
	
	public int regist_otp_key(AndroidDriver<AndroidElement> driver, String id, String pw, String otp_key) {
		
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
	
	public int connect_destination_chrome (AndroidDriver<AndroidElement> driver) {
		
		int result = 1;
		
		start_app(driver, "com.android.chrome", "com.google.android.apps.chrome.Main", "com.android.chrome:id/url_bar");
		
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
		
		return result;
	}
	
	public int connect_ping_chk (AndroidDriver<AndroidElement> driver, String host) {
		int result;
		
		start_app(driver, "com.lipinic.ping", "com.lipinic.ping.MainActivity", "com.lipinic.ping:id/editTextHost");
		
		MobileElement editTextHost = (MobileElement) driver.findElementById("com.lipinic.ping:id/editTextHost");
		editTextHost.sendKeys(host);
		MobileElement btnStart = (MobileElement) driver.findElementById("com.lipinic.ping:id/btnStart");
		btnStart.click();
		
		delay(driver, "id", "com.lipinic.ping:id/txtResult", 30);
		
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
	
	public void change_pw(AndroidDriver<AndroidElement> driver, String oldpw, String chpw1, String chpw2) {
		MobileElement et_oldpw = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_oldpw");
		et_oldpw.sendKeys(oldpw);
		MobileElement et_chpw1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw1");
		et_chpw1.sendKeys(chpw1);
		MobileElement et_chpw2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw2");
		et_chpw2.sendKeys(chpw2);
		MobileElement btn_confirm_chpw = (MobileElement) driver.findElementById("android:id/button1");
		btn_confirm_chpw.click();

		delay(driver, "id", "android:id/button1", 5);
		
		MobileElement chpw_message = (MobileElement) driver.findElementById("android:id/message");
		String message = chpw_message.getText();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + message);
		MobileElement btn_confirm_alert = (MobileElement) driver.findElementById("android:id/button1");
		btn_confirm_alert.click();
	}
	
	public int login_confirm(AndroidDriver<AndroidElement> driver) {
		
		sleep(driver, 3);
		int result;
		try {
			MobileElement button1 = (MobileElement) driver.findElementById("android:id/button1");
			return result = 1;
		}catch (Exception e) {
			
		}
		
		delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 10);
		MobileElement tvTopDesc = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvTopDesc");
		if (tvTopDesc.getText().contains("VPN 서버 접속 중") || tvTopDesc.getText().contains("VPN Server Connected")){
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그인 상태");
			result = 0; //로그인 된 상태
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그아웃 상태");
			result = 1;	//로그인 되지 않은 상태
		}
		return result;
	}
	
	public void logout_server(AndroidDriver<AndroidElement> driver) {
		delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/btnDisconnect", 10);
		sleep(driver, 1);
		
		MobileElement logout_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnDisconnect");
		logout_btn.click();
		
		delay(driver, "id", "android:id/button1", 30);
		
		sleep(driver, 1);
		
		MobileElement unconnect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		unconnect_confirm_btn.click();
		
		delay(driver, "id", "android:id/button1", 30);
		
		sleep(driver, 1);
		
		MobileElement unconnect_success_btn = (MobileElement) driver.findElementById("android:id/button1");
		unconnect_success_btn.click();
	}
	
	public int login_server(AndroidDriver<AndroidElement> driver, String user_id, String user_pw, int login_type, int select_policy) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + user_id + " / " + user_pw);
		int result = 1;
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys(user_id);
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys(user_pw);
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
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
			
			delay(driver, "id", "android:id/message", 10);
			
			MobileElement send_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			send_confirm_btn.click();
			
			start_app(driver, "com.sise15.mysqlviewer", "com.sise15.mysqlviewer.MainActivity","com.sise15.mysqlviewer:id/textView2");
			
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
			
			start_app(driver, "com.sgn.secureguardotplite", "com.sgn.sgotp.activity.SplashActivity","com.sgn.secureguardotplite:id/textOtp");
			
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
			delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]", 30);
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "다중 SSL 정책 로그인 시도: " + select_policy + "번 정책");
			
			MobileElement redirect_policy_select = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[" + select_policy + "]");
			redirect_policy_select.click();
		}

		if (delay(driver, "id", "android:id/message", 2) == 0) {
			MobileElement message = (MobileElement) driver.findElementById("android:id/message");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 메시지 : " + message.getText());
			MobileElement button = (MobileElement) driver.findElementById("android:id/button1");
			button.click();
		}
		else {
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "find toast");
			WebDriverWait waitForToast = new WebDriverWait(driver, 25);
			waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
			String toastMessage = driver.findElementByXPath("/hierarchy/android.widget.Toast").getText();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 메시지 : " + toastMessage);
			result = 0;
		}
		
		
		
		//delay(driver, "id", "android:id/button1", 30);
		/*if (login_confirm(driver) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 완료");
			result = 0;
		}
		else {
			MobileElement message = (MobileElement) driver.findElementById("android:id/message");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 실패: " + message.getText());
			MobileElement button1 = (MobileElement) driver.findElementById("android:id/button1");
			button1.click();
			result = 1;
			
		}
		*/
		
		//MobileElement login_message = (MobileElement) driver.findElementById("android:id/message");
		//String message = login_message.getText();
		//message = message.substring(0, message.indexOf(".")+1);
		
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 메시지: " + message);
		
		//MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		//connect_confirm_btn.click();
		return result;
	}
	
	public void connect_server(AndroidDriver<AndroidElement> driver, String url_ip, String port) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 접속 시도: " + url_ip + " / " + port);
		MobileElement app_setting_btn = (MobileElement) driver.findElementByAccessibilityId("Setting");
		app_setting_btn.click();
		
		delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement host_url_ip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");
		host_url_ip.click();
		sleep(driver, 2);
		
		MobileElement url_ip_edit = (MobileElement) driver.findElementById("android:id/edit");
		url_ip_edit.clear();
		url_ip_edit.sendKeys(url_ip);
		sleep(driver, 2);
		
		MobileElement ip_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		ip_confirm_btn.click();
		sleep(driver, 1);
		
		MobileElement host_port = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
		host_port.click();
		sleep(driver, 1);
		
		MobileElement port_edit = (MobileElement) driver.findElementById("android:id/edit");
		port_edit.clear();
		port_edit.sendKeys(port);
		sleep(driver, 1);
		
		MobileElement port_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		port_confirm_btn.click();
		sleep(driver, 1);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		delay(driver, "id", "kr.co.soosan.vpn.client.v10:id/editHost", 30);
		
		MobileElement server_connect_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnAuth");
		server_connect_btn.click();
		
		delay(driver, "id", "android:id/button1", 30);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 접속 완료");
		
	}
	
	public void activate_app(AndroidDriver<AndroidElement> driver, String app_name, String app_object) {
		driver.activateApp(app_name);
		delay(driver, "id", app_object, 30);
	}
	
	public void start_app(AndroidDriver<AndroidElement> driver, String app_name, String app_activity, String app_object) {
		String activity = driver.currentActivity();
		
		if (activity.contains("subscreen")) {	// for Z flip device 
			driver.terminateApp(app_name);
			activate_app(driver, app_name, app_object);
		}
		
		else {
			driver.startActivity(new Activity(app_name, app_activity));
			delay(driver, "id", app_object, 30);
		}
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + app_name + " 앱 실행 완료");
	}
	
	public int delay(AndroidDriver<AndroidElement> driver, String object_type, String object_name, int minute) {
		
		int result = 1;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, minute);
			
			if(object_type == "id") {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(object_name)));
				result = 0;
			}
			else if(object_type == "xpath") {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(object_name)));
				result = 0;
			}
		}catch (Exception e) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "객체를 찾지 못했습니다.");
			result = 1;
		}
		
		return result;
	}
	
	public void sleep(AndroidDriver<AndroidElement> driver, int minute) {
		minute = minute * 1000;
		try {
			Thread.sleep(minute); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void option_off(AndroidDriver<AndroidElement> driver) {
		sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "옵션 초기화 실행");
		
		start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		MobileElement setting_close_window_off = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_close_window_off.click();
		
		delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.Switch");
		if (close_window_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			close_window_option_off.click();
		}
		
		MobileElement auto_login_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Switch");
		if (auto_login_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			auto_login_option_off.click();
		}
		
		MobileElement session_auto_reconnect_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.Switch");
		if (session_auto_reconnect_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			session_auto_reconnect_option_off.click();
		}
		
		MobileElement rooting_check_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.Switch");
		if (rooting_check_off.getAttribute("checked").equals("false")) {
		}
		else {
			rooting_check_off.click();
		}
	}
	
	
}

