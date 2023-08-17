package test_case_ios;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class I04_T04 {
	
	func_appium_ios app_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I04_T04_case(IOSDriver<IOSElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T04 실행");
		
		app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		app_func.connect_server(driver, "172.16.150.21", "443");
		
		//idle time 적용 테스트 (약 3분 동안 목적지 접속 후 5분 뒤 종료 여부 확인)
		app_func.login_server(driver, "idle_time_user", "admin123!", 0, 0);
		
		
		for(int i=1; i<=5; i++) {
			app_func.connect_destination_safari(driver);
			app_func.connect_ping_chk(driver, "30.0.0.5");
		}
		
		//app_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		app_func.activate_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		if (app_func.delay(driver, "id", "IDLE TIME 설정으로 인해 VPN 서버와의 연결이 종료되었습니다.", 600) == 0) { //5분 설정하였지만 아이폰 이슈로 10분까지 유예
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("aler_ok");
			idle_time_alert_btn.click();
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
			assertTrue(false);
		}
		
		//idle time 미적용 테스트 (330 초 동안 종료되지 않음 확인)
		app_func.login_server(driver, "default_user", "admin123!", 0, 0);
		
		if (app_func.delay(driver, "id", "IDLE TIME 설정으로 인해 VPN 서버와의 연결이 종료되었습니다.", 330) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시됨");
			MobileElement idle_time_alert_btn = (MobileElement) driver.findElementById("aler_ok");
			idle_time_alert_btn.click();
			assertTrue(false);
		}
		else {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "idle time 메시지 표시되지 않음");
		}
		
		app_func.logout_server(driver);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I04_T04 종료");
	}
}
