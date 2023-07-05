package eWalker_SSL_VPN_V10;

import org.testng.annotations.Test;



import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class _eWalker_SSL_VPN_Android {
	
	AndroidDriver<AndroidElement> driver;
	
	Date date_now = new Date(System.currentTimeMillis());
	
	/*
	@Test
	public void R03_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		login_server("pw_expired", "admin123!", 0, 0);
		
		//패스워드 변경 테스트
		
		//1. 비밀번호 변경 화면 표시여부 확인
		if (delay("id", "kr.co.soosan.vpn.client.v10:id/et_oldpw", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시됨");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 화면 표시되지 않음");
			assertTrue(false);
		}
		
		//2. 틀린 '기존 패스워드' 입력 시 변경되지 않음 확인 (10.0.0.17 버전에서 버그 존재함)
		change_pw("admin123!!", "admin123!!", "admin123!!");
		
		//3. '새로운 비밀번호', '다시 입력' 이 서로 다를 경우 변경되지 않음 확인
		login_server("pw_expired", "admin123!", 0, 0);
		change_pw("admin123!", "admin123!!", "admin123!");
		
		//4. 정상 입력 후 비밀번호 변경 확인
		login_server("pw_expired", "admin123!", 0, 0);
		change_pw("admin123!", "admin123!!", "admin123!!");

		login_server("pw_expired", "admin123!!", 0, 0);
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T03 종료");
	}
	*/
	
	/*
	@Test
	public void R01_T00() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC test 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("버전정보");
		app_info_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/tv_sgvpnversion", 30);
		MobileElement version1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tv_sgvpnversion1");
		MobileElement version2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvClientVersion");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "앱 버전 정보 = " + version1.getText() +" " + version2.getText());
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC test 종료");
	}
	*/

	@Test
	public void R01_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R01_T01 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("버전정보");
		app_info_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/tvEwalkerName", 30);
		MobileElement version1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tv_sgvpnversion");
		MobileElement version2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvClientVersion");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "앱 버전 정보 = " + version1.getText() +" " + version2.getText());
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R01_T01 종료");
	}
	
	@Test
	public void R02_T01() {
		sleep(3);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T01 실행");
		    
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		MobileElement app_setting_btn = (MobileElement) driver.findElementByAccessibilityId("Setting");
		app_setting_btn.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement host_url_ip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");
		host_url_ip.click();
		sleep(1);
		
		MobileElement url_ip_edit = (MobileElement) driver.findElementById("android:id/edit");
		url_ip_edit.clear();
		url_ip_edit.sendKeys("172.16.150.20");
		sleep(1);
		
		MobileElement ip_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		ip_confirm_btn.click();
		sleep(1);
		
		MobileElement host_port = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
		host_port.click();
		sleep(1);
		
		MobileElement port_edit = (MobileElement) driver.findElementById("android:id/edit");
		port_edit.clear();
		port_edit.sendKeys("443");
		sleep(1);
		
		MobileElement port_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		port_confirm_btn.click();
		sleep(1);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editHost", 30);
		
		MobileElement enter_ip = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editHost");
		MobileElement enter_port = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPort");
		
		if (enter_ip.getText().equals("172.16.150.20") && enter_port.getText().equals("443")) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 주소, 포트가 정상 입력됨");
		}
		else{
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T01 종료");
	}
	

	@Test
	public void R02_T02() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T02 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");

		MobileElement setting_auto_login_on = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_auto_login_on.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement auto_login_option_on = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Switch");
		
		//자동로그인 on
		if (auto_login_option_on.getAttribute("checked").equals("false")) {
			auto_login_option_on.click();
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//로그인 상태에서 앱 종료 후 로그인되는지 확인
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "android:id/button1");
		
		MobileElement connect_confirm_btn1 = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn1.click();
		
		if (login_confirm() == 1) {
			assertTrue(false);
		}
		
		logout_server();
		
		
		//로그아웃 상태에서 앱 종료 후 로그인되는지 확인
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "android:id/button1");
		
		MobileElement connect_confirm_btn2 = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn2.click();
		
		if (login_confirm() == 1) {
			assertTrue(false);
		}
		
		logout_server();
		
		MobileElement setting_auto_login_off = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_auto_login_off.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement auto_login_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.Switch");
		
		if (auto_login_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			auto_login_option_off.click();
		}
		
		//로그인 상태에서 앱 종료 후 로그인되지 않는지 확인
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		driver.terminateApp("kr.co.soosan.vpn.client.v10");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//로그아웃 상태에서 앱 종료 후 로그인되지 않는지 확인
		
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		logout_server();
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T02 종료");
	}
	
	
	@Test
	public void R02_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");

		//VPN 접속 후 창 닫기 on
		MobileElement setting_close_window_on = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_close_window_on.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_on = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.Switch");
		
		if (close_window_option_on.getAttribute("checked").equals("false")) {
			close_window_option_on.click();
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫힘 확인
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		if	(delay("id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
		}
		
		driver.activateApp("kr.co.soosan.vpn.client.v10");
		
		logout_server();
		
		//VPN 접속 후 창 닫기 off
		MobileElement setting_close_window_off = (MobileElement) driver.findElementByAccessibilityId("Setting");
		setting_close_window_off.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement close_window_option_off = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.Switch");
		
		if (close_window_option_off.getAttribute("checked").equals("false")) {
		}
		else {
			close_window_option_off.click();
		}
		

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		//VPN 접속 후 창 닫히지 않음 확인
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		if	(delay("id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫히지 않음");
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "VPN 화면 닫힘");
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R02_T03 종료");
	}

	
	@Test
	public void R03_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T01 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		login_server("user_mobile_block", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		else{
		}
		
		login_server("default_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
		}
		else{
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T01 종료");
	}
	
	
	@Test
	public void R03_T02() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T02 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		login_server("user_access_block", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		else{
		}
		
		login_server("default_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
		}
		else{
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R03_T02 종료");
	}
	
	
	
	
	@Test
	public void R04_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T01 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		//split user 테스트
		connect_server("172.16.150.21", "443");

		login_server("split_user", "admin123!", 0, 0);
		
		if (connect_ping_chk("google.co.kr") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		//non-split user 테스트
		connect_server("172.16.150.21", "443");
		
		login_server("non_split_user", "admin123!", 0, 0);
		
		if (connect_ping_chk("google.co.kr") == 0) {
			assertTrue(false);
		}
		else {
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T01 종료");
	}
	
	
	@Test
	public void R04_T02() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T02 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		login_server("policy_mobile_block", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		else{
		}
		
		login_server("default_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
		}
		else{
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T02 종료");
	}

	
	
	@Test
	public void R04_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//멀티정책 유저 접속 (redirect url 정책 접속)
		login_server("multi_pol_user", "admin123!", 0, 5);
		
		delay("id", "com.android.chrome:id/url_bar", 30);
		
		MobileElement url_bar = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		if (url_bar.getText().contains("naver")) {
		}
		else {
			assertTrue(false);
		}
		
		driver.terminateApp("com.android.chrome");
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T03 종료");
	}
	

	@Test
	public void R04_T04() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T04 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//idle time 적용 테스트 (약 3분 동안 목적지 접속 후 5분 뒤 종료 여부 확인)
		login_server("idle_time_user", "admin123!", 0, 0);
		
		for(int i=1; i<=10; i++) {
			connect_destination_chrome();
			connect_ping_chk("30.0.0.5");
		}
		
		if (delay("id", "android:id/button1", 310) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("android:id/button1");
			idle_time_alert_btn.click();
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
			assertTrue(false);
		}
		
		//idle time 미적용 테스트 (330 초 동안 종료되지 않음 확인)
		login_server("default_user", "admin123!", 0, 0);
		
		if (delay("id", "android:id/button1", 330) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("android:id/button1");
			idle_time_alert_btn.click();
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T04 종료");
	}

	
	
	@Test
	public void R04_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T05 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//redirect url 접속됨을 확인
		login_server("redirect_url_user", "admin123!", 0, 2);
		
		if (delay("id", "com.android.chrome:id/url_bar", 5) == 0) {
			MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
			
			if (url_bar_1.getText().contains("naver")) {
			}
			else {
				assertTrue(false);
			}
		}
		else {
			assertTrue(false);
		}
		
		driver.terminateApp("com.android.chrome");
		
		logout_server();
		
		//redirect url 접속되지 않음 확인
		login_server("redirect_url_user", "admin123!", 0, 1);
		
		if (delay("id", "com.android.chrome:id/url_bar", 5) == 0) {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T05 종료");
	}

	
	
	@Test
	public void R04_T06() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T06 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//즐겨찾기 팝업 표시 및 브라우저 접속됨을 확인
		login_server("favorite_user", "admin123!", 0, 0);
		
		if (delay("id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		MobileElement naver_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
		naver_url.click();
		
		delay("id", "com.android.chrome:id/url_bar", 5);
		
		MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		if (url_bar_1.getText().contains("naver")) {
			driver.terminateApp("com.android.chrome");
		}
		else {
			assertTrue(false);
		}
		
		//즐겨찾기 버튼 클릭 후 접속 시도
		MobileElement favorite_btn = (MobileElement) driver.findElementByAccessibilityId("북마크");
		favorite_btn.click();
		
		if (delay("id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
		}
		else {
			assertTrue(false);
		}
		
		MobileElement nate_url = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
		nate_url.click();
		delay("id", "com.android.chrome:id/url_bar", 5);
		MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		if (url_bar_2.getText().contains("nate")) {
			driver.terminateApp("com.android.chrome");
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		//즐겨찾기 미등록 계정으로 로그인 시 팝업 및 버튼 없음 확인
		login_server("default_user", "admin123!", 0, 0);
		
		if (delay("id", "kr.co.soosan.vpn.client.v10:id/alertTitle", 5) == 0) {
			assertTrue(false);
		}
		
		if (delay("id", "북마크", 5) == 0) {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T06 종료");
	}

	
	@Test
	public void R04_T07() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T07 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//고유값 차단 사용자 로그인되지 않음 확인
		login_server("device_deny_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//고유값 허용 사용자 로그인됨을 확인
		login_server("device_accept_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T07 종료");
	}

	
	
	
	@Test
	public void R04_T08() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T08 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//ip 차단 사용자 로그인되지 않음 확인
		login_server("ip_deny_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//ip 허용 사용자 로그인됨을 확인
		login_server("ip_accept_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T08 종료");
	}

	
	
	
	@Test
	public void R04_T09() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T09 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//per app 정책 적용 확인(ping 앱에서 목적지 통신되지 않음 확인)
		login_server("per_app_user", "admin123!", 0, 0);
		
		if (connect_destination_chrome() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		logout_server();
		
		//모든 앱에서 통신됨을 확인 (chrome, ping)
		connect_server("172.16.150.21", "443");
		
		login_server("default_user", "admin123!", 0, 0);
		
		if (connect_destination_chrome() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R04_T09 종료");
	}

	
	
	@Test
	public void R06_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T01 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.21", "443");
		
		//로컬 사용자 로그인
		login_server("default_user", "admin123!", 0, 0);

		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T01 종료");
	}
	
	

	@Test
	public void R06_T02() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T02 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.22", "443");
		
		//틀린 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		regist_otp_key("user_mobile_otp", "admin123!", "12345678900");
		
		login_server("user_mobile_otp", "admin123!", 3, 0);

		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, 모바일) 사용자 로그인됨을 확인
		regist_otp_key("user_mobile_otp", "admin123!", "1234567890");
		
		login_server("user_mobile_otp", "admin123!", 3, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T02 종료");
	}

	@Test
	public void R06_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.22", "443");
		
		// ID/PW 정상일 경우 변경됨을 확인
		if (regist_otp_key("user_mobile_otp", "admin123!", "1234567890") == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경됨을 확인");
		}
		else {
			assertTrue(false);
		}
		
		// ID가 틀릴 경우 변경되지 않음 확인
		if (regist_otp_key("user_mobile_otp2", "admin123!", "1234567890") == 0) {
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경되지 않음 확인");
		}
		
		// PW가 틀릴 경우 변경되지 않음 확인
		if (regist_otp_key("user_mobile_otp", "admin123!!", "1234567890") == 0) {
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "OTP Key 변경되지 않음 확인");
		}
		
		/*
		// OTP 키 값이 빈 값인 경우 초기화됨 (현재 동작되지 않음)
		if (regist_otp_key("user_mobile_otp", "admin123!!", "1234567890") == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "초기화 됨");
		}
		else {
			
			assertTrue(false);
		}
		*/
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T03 종료");
	}
	
	
	@Test
	public void R06_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T05 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.41", "443");
		
		//틀린 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "default_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("default_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		sleep(1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		delay("id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, sms) 사용자 로그인됨을 확인
		login_server("default_user", "admin123!", 2, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T05 종료");
	}

	
	@Test
	public void R06_T06() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T06 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.23", "443");
		
		//틀린 OTP 입력 시 로컬, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		login_server("soosan1", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 로컬, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		login_server("soosan3", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R06_T06 종료");
	}
	
	@Test
	public void R07_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T01 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.24", "443");
		
		//DB 사용자 로그인
		login_server("odb_user", "admin123!", 0, 0);

		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T01 종료");
	}
	

	@Test
	public void R07_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.42", "443");
		
		//틀린 OTP 입력 시 DB, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "odb_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("odb_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		sleep(1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		delay("id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 DB, OTP(내부, sms) 사용자 로그인됨을 확인
		login_server("odb_user", "admin123!", 2, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T03 종료");
	}

	

	@Test
	public void R07_T04() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T04 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.25", "443");
		
		//틀린 OTP 입력 시 DB, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		regist_otp_key("odb_user", "admin123!", "12345678900");
		
		login_server("odb_user", "admin123!", 3, 0);

		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 DB, OTP(내부, 모바일) 사용자 로그인됨을 확인
		regist_otp_key("odb_user", "admin123!", "1234567890");
		
		login_server("odb_user", "admin123!", 3, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T04 종료");
	}

	
	
	
	@Test
	public void R07_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T05 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.26", "443");
		
		//틀린 OTP 입력 시 DB, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		login_server("soosan1", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 DB, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		login_server("soosan3", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R07_T05 종료");
	}
	
	

	@Test
	public void R08_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T01 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.27", "443");
		
		//AD 사용자 로그인
		login_server("ad_user", "admin123!", 0, 0);

		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T01 종료");
	}
	
	

	@Test
	public void R08_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.43", "443");
		
		//틀린 OTP 입력 시 AD, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "ad_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("ad_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		sleep(1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		delay("id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 AD, OTP(내부, sms) 사용자 로그인됨을 확인
		login_server("ad_user", "admin123!", 2, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T03 종료");
	}

	
	
	@Test
	public void R08_T04() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T04 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.28", "443");
		
		//틀린 OTP 입력 시 AD, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		regist_otp_key("ad_user", "admin123!", "12345678900");
		
		login_server("ad_user", "admin123!", 3, 0);

		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 AD, OTP(내부, 모바일) 사용자 로그인됨을 확인
		regist_otp_key("ad_user", "admin123!", "1234567890");
		
		login_server("ad_user", "admin123!", 3, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T04 종료");
	}

	
	
	@Test
	public void R08_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T05 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.30", "443");
		
		//틀린 OTP 입력 시 AD, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		login_server("soosan1", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 AD, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		login_server("soosan3", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R08_T05 종료");
	}
	
	
	@Test
	public void R09_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T01 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.31", "443");
		
		//RADIUS 사용자 로그인
		login_server("radius_user", "admin123!", 0, 0);

		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T01 종료");
	}

	
	@Test
	public void R09_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.44", "443");
		
		//틀린 OTP 입력 시 RADIUS, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "radius_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("radius_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		sleep(1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		delay("id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 RADIUS, OTP(내부, sms) 사용자 로그인됨을 확인
		login_server("radius_user", "admin123!", 2, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T03 종료");
	}

	
	
	@Test
	public void R09_T04() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T04 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.32", "443");
		
		//틀린 OTP 입력 시 RADIUS, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		regist_otp_key("radius_user", "admin123!", "12345678900");
		
		login_server("radius_user", "admin123!", 3, 0);

		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 RADIUS, OTP(내부, 모바일) 사용자 로그인됨을 확인
		regist_otp_key("radius_user", "admin123!", "1234567890");
		
		login_server("radius_user", "admin123!", 3, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T04 종료");
	}

	
	
	@Test
	public void R09_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T05 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.33", "443");
		
		//틀린 OTP 입력 시 RADIUS, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		login_server("soosan1", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 RADIUS, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		login_server("soosan3", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R09_T05 종료");
	}

	
	
	@Test
	public void R10_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T01 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.34", "443");
		
		//LDAP 사용자 로그인
		login_server("ldap_user", "admin123!", 0, 0);

		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T01 종료");
	}
	

	
	@Test
	public void R10_T03() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T03 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.45", "443");
		
		//틀린 OTP 입력 시 LDAP, OTP(내부, sms) 사용자 로그인되지 않음 확인
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + "ldap_user" + " / " + "admin123!");
		MobileElement user_id_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editUserID");
		user_id_edit.sendKeys("ldap_user");
		MobileElement user_pw_edit = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editPassword");
		user_pw_edit.sendKeys("admin123!");
		MobileElement login_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		login_btn.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 20);
		sleep(1);
		
		MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
		editOTPKey.sendKeys("112233");
		
		MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		otp_confirm_btn.click();
		
		delay("id", "android:id/button1", 10);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 LDAP, OTP(내부, sms) 사용자 로그인됨을 확인
		login_server("ldap_user", "admin123!", 2, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T03 종료");
	}

	
	
	
	@Test
	public void R10_T04() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T04 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.35", "443");
		
		//틀린 OTP 입력 시 LDAP, OTP(내부, 모바일) 사용자 로그인되지 않음 확인
		regist_otp_key("ldap_user", "admin123!", "12345678900");
		
		login_server("ldap_user", "admin123!", 3, 0);

		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 LDAP, OTP(내부, 모바일) 사용자 로그인됨을 확인
		regist_otp_key("ldap_user", "admin123!", "1234567890");
		
		login_server("ldap_user", "admin123!", 3, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T04 종료");
	}
	
	
	
	@Test
	public void R10_T05() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T05 실행");
		
		if (connect_ping_chk("30.0.0.5") == 0) {
			assertTrue(false);
		}
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.36", "443");
		
		//틀린 OTP 입력 시 LDAP, OTP(내부, 미래OTP) 사용자 로그인되지 않음 확인
		login_server("soosan1", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		//정상 OTP 입력 시 LDAP, OTP(내부, 미래OTP) 사용자 로그인됨을 확인
		login_server("soosan3", "admin123!", 4, 0);
		
		if (login_confirm() == 0) {
		}
		else {
			assertTrue(false);
		}
		
		if (connect_ping_chk("30.0.0.5") == 0) {
		}
		else {
			assertTrue(false);
		}
		
		logout_server();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R10_T05 종료");
	}
	

	@Test
	public void R11_T01() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R11_T01 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.20", "443");
		
		//공인인증서 로그인 시도 시 로그인되지 않음 확인
		login_server("default_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R11_T01 종료");
	}
	
	
	@Test
	public void R11_T02() {
		sleep(3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R11_T02 실행");
		
		start_app("kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "kr.co.soosan.vpn.client.v10:id/action_info");
		
		connect_server("172.16.150.40", "443");
		
		//사설인증서 로그인 시도 시 로그인되지 않음 확인
		login_server("default_user", "admin123!", 0, 0);
		
		if (login_confirm() == 0) {
			assertTrue(false);
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC R11_T02 종료");
	}
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	*/
	
	
	public int regist_otp_key(String id, String pw, String otp_key) {
		
		int result = 1;
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/btnRegistOTPKey", 10);
		MobileElement btnRegistOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnRegistOTPKey");
		btnRegistOTPKey.click();
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editUserID", 10);
		
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
		
		delay("id", "android:id/button1", 10);
		
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
	
	public int connect_destination_chrome () {
		
		int result = 1;
		
		start_app("com.android.chrome", "com.google.android.apps.chrome.Main", "com.android.chrome:id/url_bar");
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("옵션 더보기");
		el1.click();
		
		delay("id", "com.android.chrome:id/new_incognito_tab_menu_id", 5);
		
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("새 시크릿 탭");
		el2.click();
		
		delay("id", "com.android.chrome:id/url_bar", 5);
		
		MobileElement url_bar_1 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		url_bar_1.click();
		url_bar_1.sendKeys("30.0.0.5");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		if (delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.TextView[1]", 10) == 0) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		MobileElement url_bar_2 = (MobileElement) driver.findElementById("com.android.chrome:id/url_bar");
		
		url_bar_2.click();
		url_bar_2.sendKeys("30.0.0.5/test");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		if (delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.TextView[1]", 10) == 0) {
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
	
	public int connect_ping_chk (String host) {
		int result;
		start_app("com.lipinic.ping", "com.lipinic.ping.MainActivity", "com.lipinic.ping:id/editTextHost");
		
		MobileElement editTextHost = (MobileElement) driver.findElementById("com.lipinic.ping:id/editTextHost");
		editTextHost.sendKeys(host);
		MobileElement btnStart = (MobileElement) driver.findElementById("com.lipinic.ping:id/btnStart");
		btnStart.click();
		
		delay("id", "com.lipinic.ping:id/txtResult", 30);
		
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
	
	public void change_pw(String oldpw, String chpw1, String chpw2) {
		MobileElement et_oldpw = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_oldpw");
		et_oldpw.sendKeys(oldpw);
		MobileElement et_chpw1 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw1");
		et_chpw1.sendKeys(chpw1);
		MobileElement et_chpw2 = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/et_chpw2");
		et_chpw2.sendKeys(chpw2);
		MobileElement btn_confirm_chpw = (MobileElement) driver.findElementById("android:id/button2");
		btn_confirm_chpw.click();

		delay("id", "android:id/button1", 5);
		
		MobileElement chpw_message = (MobileElement) driver.findElementById("android:id/message");
		String message = chpw_message.getText();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "비밀번호 변경 메시지: " + message);
		MobileElement btn_confirm_alert = (MobileElement) driver.findElementById("android:id/button1");
		btn_confirm_alert.click();
	}
	
	public int login_confirm() {
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/tvTopDesc", 10);
		
		MobileElement tvTopDesc = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/tvTopDesc");
		
		int result;
		
		if (tvTopDesc.getText().equals("VPN 서버 접속")){
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그아웃 상태");
			result = 1;	//로그인 되지 않은 상태
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 확인: 로그인 상태");
			result = 0; //로그인 된 상태
		}
		return result;
	}
	
	public void logout_server() {
		delay("id", "kr.co.soosan.vpn.client.v10:id/btnDisconnect", 10);
		sleep(1);
		
		MobileElement logout_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnDisconnect");
		logout_btn.click();
		
		delay("id", "android:id/button1", 30);
		
		sleep(1);
		
		MobileElement unconnect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		unconnect_confirm_btn.click();
		
		delay("id", "android:id/button1", 30);
		
		sleep(1);
		
		MobileElement unconnect_success_btn = (MobileElement) driver.findElementById("android:id/button1");
		unconnect_success_btn.click();
	}
	
	public void login_server(String user_id, String user_pw, int login_type, int select_policy) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 시도: " + user_id + " / " + user_pw);
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
			sleep(1);
			delay("id", "kr.co.soosan.vpn.client.v10:id/textinput_helper_text", 10);
			
			MobileElement btnIssueOTPNumber = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnIssueOTPNumber");
			btnIssueOTPNumber.click();
			
			delay("id", "android:id/contentPanel", 10);
			
			MobileElement send_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			send_confirm_btn.click();
			
			start_app("com.sise15.mysqlviewer", "com.sise15.mysqlviewer.MainActivity","com.sise15.mysqlviewer:id/textView2");
			
			MobileElement textView2 = (MobileElement) driver.findElementById("com.sise15.mysqlviewer:id/textView2");
			textView2.click();
			
			delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView", 30);
			
			sleep(1);
			
			MobileElement table_select = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView");
			table_select.click();
			
			delay("id", "com.sise15.mysqlviewer:id/query", 30);
			
			sleep(1);
			
			MobileElement query_edit = (MobileElement) driver.findElementById("com.sise15.mysqlviewer:id/query");
			query_edit.sendKeys("select * from smstest");
			MobileElement done = (MobileElement) driver.findElementByAccessibilityId("Done");
			done.click();
			
			delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[1]", 30);
			
			sleep(1);
			
			MobileElement otp_key_db = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[1]");
			String otpvar = otp_key_db.getText().replace("[", "");
			otpvar = otpvar.replace("]", "");
			
			query_edit.clear();
			query_edit.sendKeys("delete from smstest");
			done.click();
			
			driver.terminateApp("com.sise15.mysqlviewer");
			
			delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			sleep(1);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
			
		}
		
		else if (login_type == 3) {
			delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			start_app("com.sgn.secureguardotplite", "com.sgn.sgotp.activity.SplashActivity","com.sgn.secureguardotplite:id/textOtp");
			
			MobileElement otp_var = (MobileElement) driver.findElementById("com.sgn.secureguardotplite:id/textOtp");
			String otpvar = otp_var.getText();

			driver.terminateApp("com.sgn.secureguardotplite");
			
			delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
		}
		
		else if (login_type == 4) {
			delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			activate_app("com.dreammirae.anyauth.android", "com.dreammirae.anyauth.android:id/txt_pattern_info");
			
			TouchAction actionOne = new TouchAction(driver);
			actionOne.press(PointOption.point(184, 968)).moveTo(PointOption.point(904, 968)).moveTo(PointOption.point(904, 1688)).release();
			actionOne.perform();
			
			MobileElement otp_key_mirae = (MobileElement) driver.findElementById("com.dreammirae.anyauth.android:id/otp");
			String otpvar = otp_key_mirae.getText().replace(" ", "");
			
			driver.terminateApp("com.dreammirae.anyauth.android");

			delay("id", "kr.co.soosan.vpn.client.v10:id/editOTPNumber", 10);
			
			MobileElement editOTPKey = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/editOTPNumber");
			editOTPKey.sendKeys(otpvar);
			
			MobileElement otp_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
			otp_confirm_btn.click();
			
		}
		
		// 멀티정책 선택
		if (select_policy != 0) {
			delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]", 30);
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "다중 SSL 정책 로그인 시도: " + select_policy + "번 정책");
			
			MobileElement redirect_policy_select = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[" + select_policy + "]");
			redirect_policy_select.click();
		}
		
		delay("id", "android:id/button1", 30);
		
		sleep(1);
		
		MobileElement login_message = (MobileElement) driver.findElementById("android:id/message");
		String message = login_message.getText();
		message = message.substring(0, message.indexOf(".")+1);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그인 메시지: " + message);
		
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
	}
	
	public void connect_server(String url_ip, String port) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "서버 접속 시도: " + url_ip + " / " + port);
		MobileElement app_setting_btn = (MobileElement) driver.findElementByAccessibilityId("Setting");
		app_setting_btn.click();
		
		delay("xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView", 30);
		
		MobileElement host_url_ip = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");
		host_url_ip.click();
		sleep(2);
		
		MobileElement url_ip_edit = (MobileElement) driver.findElementById("android:id/edit");
		url_ip_edit.clear();
		url_ip_edit.sendKeys(url_ip);
		sleep(2);
		
		MobileElement ip_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		ip_confirm_btn.click();
		sleep(1);
		
		MobileElement host_port = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
		host_port.click();
		sleep(1);
		
		MobileElement port_edit = (MobileElement) driver.findElementById("android:id/edit");
		port_edit.clear();
		port_edit.sendKeys(port);
		sleep(1);
		
		MobileElement port_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		port_confirm_btn.click();
		sleep(1);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		delay("id", "kr.co.soosan.vpn.client.v10:id/editHost", 30);
		
		MobileElement server_connect_btn = (MobileElement) driver.findElementById("kr.co.soosan.vpn.client.v10:id/btnConnect");
		server_connect_btn.click();
		
		delay("id", "android:id/button1", 30);
		MobileElement connect_confirm_btn = (MobileElement) driver.findElementById("android:id/button1");
		connect_confirm_btn.click();
		
	}
	
	public void activate_app(String app_name, String app_object) {
		driver.activateApp(app_name);
		delay("id", app_object, 30);
	}
	
	public void start_app(String app_name, String app_activity, String app_object) {
		driver.startActivity(new Activity(app_name, app_activity));
		delay("id", app_object, 30);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + app_name + " 앱 실행 완료");
	}
	
	public int delay(String object_type, String object_name, int minute) {
		
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
	
	public void sleep(int minute) {
		minute = minute * 1000;
		try {
			Thread.sleep(minute); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
  	public void beforeTest() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
	  
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName","SM-G991N");
		capabilities.setCapability("uuid","R3CRC0MAAKN");
		capabilities.setCapability("platformversion","13");
	  
		try {
			driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
