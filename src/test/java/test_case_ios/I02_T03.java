package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import resouce.func_appium_ios;

public class I02_T03 {
	
	func_appium_ios app_func = new func_appium_ios();
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I02_T03_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T03 실행");

		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "top icon info");
		
		if (app_func.login_confirm(driver, "login") == 0) {
			app_func.logout_server(driver);
		}
		
		//Email 전송 테스트
		driver.findElementByAccessibilityId("btn setting blue").click();;
		app_func.delay(driver, "id", "btn_setting_log_send", 5);
		app_func.sleep(driver, 1);
		
		driver.findElementByAccessibilityId("btn_setting_log_send").click();
		
		app_func.sleep(driver, 1);

		driver.findElementByIosClassChain("**/XCUIElementTypeCell[`label == \"Mail\"`]/XCUIElementTypeOther/XCUIElementTypeImage").click();
		
		//scroll down
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		driver.executeScript("mobile: scroll", scrollObject);
		
		try {
			String vpn_app_log = driver.findElementByIosNsPredicate("name contains 'ewsvpn_ios_app.log'").getAttribute("name");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그 파일 확인: " + vpn_app_log);
			String vpn_daemon_log = driver.findElementByIosNsPredicate("name contains 'ewsvpn_ios_daemon.log'").getAttribute("name");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그 파일 확인: " + vpn_daemon_log);
		}catch (Exception e) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그 존재하지 않음");
			assertTrue(false);
		}
		
		try {
			String vpn_app_old_log = driver.findElementByIosNsPredicate("name contains 'ewsvpn_ios_app_old.log'").getAttribute("name");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그 파일 확인: " + vpn_app_old_log);
			String vpn_daemon_old_log = driver.findElementByIosNsPredicate("name contains 'ewsvpn_ios_daemon_old.log'").getAttribute("name");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "로그 파일 확인: " + vpn_daemon_old_log);
			
			vpn_app_old_log = vpn_app_old_log.replaceAll("[^0-9]", "");
			int app_old_num = Integer.parseInt(vpn_app_old_log);
			vpn_daemon_old_log = vpn_daemon_old_log.replaceAll("[^0-9]", "");
			int daemon_old_num = Integer.parseInt(vpn_daemon_old_log);
			
			if (app_old_num >= 50 || daemon_old_num >= 50) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "5mb 이상이므로 old 파일 생성됨");
			}
			else {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "5mb 미만으로 old 파일 생성되지 않아야 함");
				assertTrue(false);
			}
		}catch (Exception e){
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "old 파일 존재하지 않음");
		}
		
		driver.findElementByAccessibilityId("Mail.cancelSendButton").click();
		driver.findElementByAccessibilityId("Mail.compose.popoverAlert.deleteDraft").click();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T03 종료");
		
	}
}