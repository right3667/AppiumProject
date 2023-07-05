package test_case_ios;

import java.text.SimpleDateFormat;
import java.util.Date;

import function.func_appium_ios;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class I02_T01 {
	
	func_appium_ios test_func = new func_appium_ios();
	
	Date date_now = new Date(System.currentTimeMillis());
	
	public void I02_T01_case(IOSDriver<IOSElement> driver) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T01 실행");
		
		test_func.sleep(driver, 3);
		driver.terminateApp("com.soosanint.ewalker.vpn.v10");
		test_func.start_app(driver, "com.soosanint.ewalker.vpn.v10", "btn info blue");
		
		test_func.connect_server(driver, "172.16.150.20", "443");
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC I02_T01 종료");
	}
}
