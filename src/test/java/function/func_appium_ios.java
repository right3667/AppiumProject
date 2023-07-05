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
	

	
	public void change_pw(IOSDriver<IOSElement> driver, String oldpw, String chpw1, String chpw2) {
		MobileElement et_oldpw = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_oldpw");
		et_oldpw.sendKeys(oldpw);
		MobileElement et_chpw1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw1");
		et_chpw1.sendKeys(chpw1);
		MobileElement et_chpw2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw2");
		et_chpw2.sendKeys(chpw2);
		MobileElement btn_confirm_chpw = (MobileElement) driver.findElementById("android:id/button2");
		btn_confirm_chpw.click();

		delay(driver, "id", "android:id/button1", 5);
		
		MobileElement chpw_message = (MobileElement) driver.findElementById("android:id/message");
		String message = chpw_message.getText();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + message);
		MobileElement btn_confirm_alert = (MobileElement) driver.findElementById("android:id/button1");
		btn_confirm_alert.click();
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
	
	public void login_server(IOSDriver<IOSElement> driver, String user_id, String user_pw, int login_type, int select_policy) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + user_id + " / " + user_pw);
		MobileElement tf_login_id = (MobileElement) driver.findElementByAccessibilityId("tf_login_id");
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
		
		/*delay(driver, "id", "허용", 30);
		
		MobileElement allow = (MobileElement) driver.findElementByAccessibilityId("허용");
		allow.click();
		
		delay(driver, "id", "9", 30);
		
		MobileElement iphone_pw = (MobileElement) driver.findElementByAccessibilityId("9");
		iphone_pw.click();
		iphone_pw.click();
		iphone_pw.click();
		iphone_pw.click();
		*/
		login_confirm(driver, "login");
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

