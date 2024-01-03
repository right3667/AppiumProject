package resouce;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class func_appium_mac {

	public static void main(String[] args) {
	}

	public int regist_otp_key(IOSDriver<IOSElement> driver, String id, String pw, String otp_key) {
		
		int result = 1;
		
		delay(driver, "id", "OTP Key 등록", 10);
		driver.findElementByAccessibilityId("OTP Key 등록").click();
		
		delay(driver, "id", "tf_otp_pp_id", 5);
		driver.findElementByAccessibilityId("tf_otp_pp_id").clear();;
		driver.findElementByAccessibilityId("tf_otp_pp_id").sendKeys(id);
		driver.findElementByAccessibilityId("tf_otp_pp_passwd").clear();
		driver.findElementByAccessibilityId("tf_otp_pp_passwd").sendKeys(pw);
		driver.findElementByAccessibilityId("tf_otp_pp_key").clear();
		driver.findElementByAccessibilityId("tf_otp_pp_key").sendKeys(otp_key);
		driver.findElementByAccessibilityId("btn_otp_pp_ok").click();
		
		if (delay(driver, "id", "OTP Key 등록이 완료되었습니다. ", 5) == 0) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		driver.findElementByAccessibilityId("aler_ok").click();
		
		if (result == 1) {
			driver.findElementByAccessibilityId("btn_otp_pp_close").click();
		}
		
		return result;
	}
	
	public int connect_destination_safari (IOSDriver<IOSElement> driver) {
		
		int result = 1;
		
		start_app(driver, "com.apple.mobilesafari", "TabBarItemTitle");
		
		delay(driver, "id", "TabBarItemTitle", 10);
		
		driver.findElementByAccessibilityId("TabBarItemTitle").click();
		sleep(driver, 1);
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
		
		sleep(driver, 3);
		
		try {
			driver.findElementByIosClassChain("**/XCUIElementTypeOther[`label == \"HTML\"`]/XCUIElementTypeTextField").click();
			sleep(driver, 1);
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
			driver.findElementByAccessibilityId("완료").click();
			
			driver.findElementByAccessibilityId("ReloadButton").click();
			
			sleep(driver, 3);
			
			driver.findElementByIosClassChain("**/XCUIElementTypeOther[`label == \"HTML\"`]/XCUIElementTypeTextField").click();
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "목적지 통신됨");
			result = 0;
			
		}catch (Exception e) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "목적지 통신되지 않음");
			result = 1;
		}
		
		driver.terminateApp("com.apple.mobilesafari");
		
		return result;
	}
	
	public int connect_ping_chk (IOSDriver<IOSElement> driver, String host) {
		int result = 1;
		
		start_app(driver, "com.deftapps.ping", "Sent");
		
		driver.findElementByIosClassChain("**/XCUIElementTypeTextField[`value == \"<Hostname or IP address>\"`]").sendKeys(host);
				
		driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"Ping\"`]").click();
		
		if (delay(driver, "id", host, 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + host + " " + "ping 연결 됨");
			result = 0;
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + host + " " + "ping 연결 되지 않음");
			result = 1;
		}
		
		driver.terminateApp("com.deftapps.ping");
		
		return result;
	}
	
	public int login_confirm(IOSDriver<IOSElement> driver, String check) {
		int result;
		
		//로그인 확인
		if (check == "login") {
			try {
				//WebDriverWait wait = new WebDriverWait(driver, 10);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("VPN 연결 종료")));
				driver.findElementByAccessibilityId("VPN 연결 종료");
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그인");
				result = 0;
			}catch (Exception e) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그아웃");
				result = 1;
			}
		}
		
		//로그아웃 확인
		else {
			try {
				driver.findElementByAccessibilityId("VPN 서버 접속");
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
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "'" + bundleid + "'" + " 앱 실행 완료");
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
			
			else if(object_type == "IosClassChain") {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(object_name)));
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + 2);
			}
			
			else if(object_type == "IosNsPredicate") {
				
			}
		}catch (Exception e) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "'" + object_name + "'" + " 객체를 찾지 못했습니다.");
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
		sleep(driver, 1);
		
		MobileElement ip_port_setting = (MobileElement) driver.findElementByAccessibilityId("btn_setting_change");
		ip_port_setting.click();
		sleep(driver, 1);
		
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
			delay(driver, "id", "tf_otp_pp_key", 10);
			
			driver.findElementByAccessibilityId("OTP 전송").click();
			
			start_app(driver, "com.excelsis.querydb", "test");
			
			driver.findElementByAccessibilityId("test").click();
			
			sleep(driver, 2);
			
			driver.findElementByAccessibilityId("select").click();
			
			sleep(driver, 2);
			
			String otp_var = driver.findElementByIosNsPredicate("value CONTAINS '['").getAttribute("value");
			otp_var = otp_var.replace("[", "");
			otp_var = otp_var.replace("]", "");
			
			driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"test\"`]").click();
			
			sleep(driver, 1);
			
			driver.findElementByAccessibilityId("delete").click();
			
			delay(driver, "id", "Result: 1 row(s) affected.", 5);
			
			driver.terminateApp("com.excelsis.querydb");
			
			driver.activateApp("com.soosanint.ewalker.vpn.v10");
			
			delay(driver, "id", "tf_otp_pp_key", 5);
			
			driver.findElementByAccessibilityId("tf_otp_pp_key").sendKeys(otp_var);
			
			driver.findElementByAccessibilityId("btn_otp_pp_ok").click();
			
		}
		
		else if (login_type == 3) {
			delay(driver, "id", "tf_otp_pp_key", 10);
			
			start_app(driver, "com.sgn.SGOTP2Lite", "top icon info white x3");
			
			MobileElement otp_var = (MobileElement) driver.findElementByIosClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeStaticText");
			
			//인증번호 값을 받을 수 없기 때문에 길게 눌러서 클립보드 복사 기능으로 대체
			LongPressOptions longPressOptions = new LongPressOptions();
			longPressOptions.withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(otp_var));
			
			TouchAction action = new TouchAction(driver);
			action.longPress(longPressOptions).release().perform();
			
			delay(driver, "id", "확인", 3);
			driver.findElementByAccessibilityId("확인").click();
			
			driver.terminateApp("com.sgn.SGOTP2Lite");
			
			driver.activateApp("com.soosanint.ewalker.vpn.v10");
			delay(driver, "id", "붙여넣기 허용", 3);
			driver.findElementByAccessibilityId("붙여넣기 허용").click();
			
			delay(driver, "id", "tf_otp_pp_key", 3);
			driver.findElementByAccessibilityId("tf_otp_pp_key").click();
			sleep(driver, 1);
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"붙여넣기\"`]").click();

			driver.findElementByAccessibilityId("확인").click();
		}
		
		else if (login_type == 4) {
			delay(driver, "id", "tf_otp_pp_key", 10);
			
			activate_app(driver, "com.dreammirae.anyauth.ios", "패턴 그리기");
			
			/*
			TouchAction actionOne = new TouchAction(driver);
			actionOne.press(PointOption.point(98, 333)).moveTo(PointOption.point(275, 333)).moveTo(PointOption.point(275, 508)).release();
			actionOne.perform();
			*/
			
			driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"PIN 입력\"`]").click();
			
			sleep(driver, 1);
			
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"1\"`]").click();
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"3\"`]").click();
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"5\"`]").click();
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"7\"`]").click();
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"9\"`]").click();
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"0\"`]").click();
			
			delay(driver, "id", "시간 OTP", 10);
			
			TouchAction actionTwo = new TouchAction(driver);
			actionTwo.tap(PointOption.point(186, 356)).perform();
			
			sleep(driver, 1);
			
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"확인\"`]").click();
			
			driver.terminateApp("com.dreammirae.anyauth.ios");

			driver.activateApp("com.soosanint.ewalker.vpn.v10");
			
			//delay(driver, "id", "붙여넣기 허용", 3);
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "1");
			//driver.findElementByIosClassChain("**/XCUIElementTypeButton[`label == \"붙여넣기 허용\"`]").click();
			//driver.findElementByIosNsPredicate("name CONTAINS '붙여넣기 허용'").click();
			//driver.findElementByAccessibilityId("붙여넣기 허용").click();
			MobileElement allowButton = driver.findElement(MobileBy.AccessibilityId("붙여넣기 허용"));
			allowButton.click();
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "2");
			delay(driver, "id", "tf_otp_pp_key", 3);
			driver.findElementByAccessibilityId("tf_otp_pp_key").click();
			sleep(driver, 1);
			driver.findElementByIosClassChain("**/XCUIElementTypeStaticText[`label == \"붙여넣기\"`]").click();

			driver.findElementByAccessibilityId("확인").click();
			
		}
		
		// 멀티정책 선택
		if (select_policy != 0) {
			delay(driver, "id", "* VPN 서버 접속에 사용할 정책을 선택해주세요.", 30);
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "다중 SSL 정책 로그인 시도: " + select_policy + "번 정책");
			
			MobileElement redirect_policy_select = (MobileElement) driver.findElementByIosClassChain("**/XCUIElementTypeCell[`label == \"cell_policy_list\"`][" + select_policy + "]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
			redirect_policy_select.click();
			
			driver.findElementByAccessibilityId("btn_policy_pp_ok").click();
			
			return result = delay(driver, "id", "Toolbar", 5);
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + a);
			//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + driver.findElementByAccessibilityId("VPN 서버와의 연결이 정상적으로 되었습니다. ").getAttribute("value"));
		}
		
		result = delay(driver, "id", "VPN 서버와의 연결이 정상적으로 되었습니다. ", 5);
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + result);
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
			driver.findElementById("현재 비밀 번호를 입력하시기 바랍니다.");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "현재 비밀 번호를 입력하시기 바랍니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		try {
			driver.findElementById("비밀번호 변경을 실패하였습니다. 기존 비밀번호를 확인하시기 바랍니다.");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "비밀번호 변경을 실패하였습니다. 기존 비밀번호를 확인하시기 바랍니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		try {
			driver.findElementById("새 비밀 번호와 일치하지 않습니다. ");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "새 비밀 번호와 일치하지 않습니다.");
		}catch (Exception e) {
			result = 1;
		}
		
		try {
			driver.findElementByIosNsPredicate("value CONTAINS '비밀번호가 변경되었습니다.'");
			//MobileElement chpw_message = (MobileElement) driver.findElementById("비밀번호가 변경되었습니다. 다시 로그인 해주시기 바랍니다. ");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + "비밀번호가 변경되었습니다. 다시 로그인 해주시기 바랍니다.");
			result = 0;
		}catch (Exception e) {
			result = 1;
		}
		
		delay(driver, "id", "aler_ok", 5);
		driver.findElementByAccessibilityId("aler_ok").click();
		
		return result;
	}
	
	public void logout_server(IOSDriver<IOSElement> driver) {
		MobileElement btn_login_ok = (MobileElement) driver.findElementByAccessibilityId("btn_login_ok");
		btn_login_ok.click();
		sleep(driver, 1);
		
		MobileElement check = (MobileElement) driver.findElementByAccessibilityId("aler_ok");
		check.click();
		sleep(driver, 1);
		//login_confirm(driver, "logout");
	}
}

