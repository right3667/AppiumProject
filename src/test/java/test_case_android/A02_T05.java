package test_case_android;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import resouce.func_appium_android;
import io.appium.java_client.TouchAction;


public class A02_T05 {
	
	func_appium_android app_func = new func_appium_android();
	
	Date date_now = new Date(System.currentTimeMillis());

	public void A02_T05_case(AndroidDriver<AndroidElement> driver) {
		app_func.sleep(driver, 3);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 실행");
		
		app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "id", "kr.co.soosan.vpn.client.v10:id/action_info");
		//app_func.start_app(driver, "kr.co.soosan.vpn.client.v10", "kr.co.soosan.vpn.client.v10.MainActivity", "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");

		//E-mail 전송 테스트
		//setting button
		driver.findElementById("kr.co.soosan.vpn.client.v10:id/setting_menu").click();
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.widget.Button").click();
				
		//스크롤 아래로 이동
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(872, 1027)).moveTo(PointOption.point(865, 801)).release().perform();
		
		app_func.delay(driver, "xpath", "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[9]/android.widget.RelativeLayout/android.widget.TextView[1]", 30);
		
		//MobileElement send_mail = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[9]/android.widget.RelativeLayout/android.widget.TextView[1]");
		MobileElement send_mail = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[10]/android.widget.RelativeLayout");
		send_mail.click();

		app_func.delay(driver,  "id", "android:id/title", 5);
		app_func.sleep(driver, 2);
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " +  " -- " + "GMail 실행");
		MobileElement Gmail = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/com.android.internal.widget.ViewPager/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[3]");
		Gmail.click();
				
		app_func.delay(driver,  "id", "com.google.android.gm:id/compose_toolbar", 5);
		
		app_func.sleep(driver, 2);
		
		driver.navigate().back();
		
		if (app_func.delay(driver, "xpath", "//android.widget.FrameLayout[@content-desc=\"텍스트, ewvpn_app_log.txt, 첨부파일 ewvpn_app_log.txt 삭제 버튼\"]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " +  " -- " + "application log 확인");
		}
		else {
			assertTrue(false);
		}
		
		if (app_func.delay(driver, "xpath","//android.widget.FrameLayout[@content-desc=\"텍스트, ewvpn_log.txt, 첨부파일 ewvpn_log.txt 삭제 버튼\"]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]", 5) == 0) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + " -- " + "tunnel log 확인");
		}
		else {
			assertTrue(false);
		}

		driver.navigate().back();				
				
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "TC A02_T05 종료");
	}
}
