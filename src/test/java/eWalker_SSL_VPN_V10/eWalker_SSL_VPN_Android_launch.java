package eWalker_SSL_VPN_V10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import test_case_android.*;

public class eWalker_SSL_VPN_Android_launch {
	
	AndroidDriver<AndroidElement> driver;
	Date date_now = new Date(System.currentTimeMillis());
	
	
/*
	@Test(priority = 1)
	public void A00() {
		A00 launch_test = new A00();
		launch_test.A00_test(driver);
	}
*/	
	
	@Test(priority = 0)
	public void A01_T01() {
		A01_T01 launch_test = new A01_T01();
		launch_test.A01_T01_case(driver);
	
	}
	
	@Test(priority = 1)
	public void A02_T01() {
		A02_T01 launch_test = new A02_T01();
		launch_test.A02_T01_case(driver);
	}
	
	@Test(priority = 2)
	public void A02_T02() {
		A02_T02 launch_test = new A02_T02();
		launch_test.A02_T02_case(driver);
	}
	
	@Test(priority = 3)
	public void A02_T03() {
		A02_T03 launch_test = new A02_T03();
		launch_test.A02_T03_case(driver);
	}
	
	@Test(priority = 3)
	public void A02_T05() {
		A02_T05 launch_test = new A02_T05();
		launch_test.A02_T05_case(driver);
	}
	
	@Test(priority = 4)
	public void A03_T01() {
		A03_T01 launch_test = new A03_T01();
		launch_test.A03_T01_case(driver);
	}
	
	@Test(priority = 5)
	public void A03_T02() {
		A03_T02 launch_test = new A03_T02();
		launch_test.A03_T02_case(driver);
	}
	
	@Test(priority = 6)
	public void A03_T03() {
		A03_T03 launch_test = new A03_T03();
		launch_test.A03_T03_case(driver);
	}
	
	/*
	@Test(priority = 6)
	public void A03_T04() {
		A03_T04 launch_test = new A03_T04();
		launch_test.A03_T04_case(driver);
	}
	*/
	
	@Test(priority = 6)
	public void A03_T05() {
		A03_T05 launch_test = new A03_T05();
		launch_test.A03_T05_case(driver);
	}
	
	@Test(priority = 6)
	public void A03_T06() {
		A03_T06 launch_test = new A03_T06();
		launch_test.A03_T06_case(driver);
	}
	
	@Test(priority = 6)
	public void A03_T07() {
		A03_T07 launch_test = new A03_T07();
		launch_test.A03_T07_case(driver);
	}
	
	@Test(priority = 6)
	public void A03_T08() {
		A03_T08 launch_test = new A03_T08();
		launch_test.A03_T08_case(driver);
	}
		
	
	@Test(priority = 6)
	public void A04_T01() {
		A04_T01 launch_test = new A04_T01();
		launch_test.A04_T01_case(driver);
	}
	
	@Test(priority = 7)  // 정책 차단이면 서버 접속 정보로 이동함 
	public void A04_T02() {
		A04_T02 launch_test = new A04_T02();
		launch_test.A04_T02_case(driver);
	}
	
	@Test(priority = 8) //다중 정책 
	public void A04_T03() {
		A04_T03 launch_test = new A04_T03();
		launch_test.A04_T03_case(driver);
	}
	
	@Test(priority = 9)
	public void A04_T04() {
		A04_T04 launch_test = new A04_T04();
		launch_test.A04_T04_case(driver);
	}

	@Test(priority = 10)
	public void A04_T05() {
		A04_T05 launch_test = new A04_T05();
		launch_test.A04_T05_case(driver);
	}
	
	@Test(priority = 11)
	public void A04_T06() {
		A04_T06 launch_test = new A04_T06();
		launch_test.A04_T06_case(driver);
	}
	
	@Test(priority = 12)	// 디바이스 차단이면 서버 접속 정보로 이동함 
	public void A04_T07() {
		A04_T07 launch_test = new A04_T07();
		launch_test.A04_T07_case(driver);
	}
	
	@Test(priority = 13)	// ip 차단이면 서버 접속 정보로 이동함
	public void A04_T08() {
		A04_T08 launch_test = new A04_T08();
		launch_test.A04_T08_case(driver);
	}
	
	@Test(priority = 14)
	public void A04_T09() {
		A04_T09 launch_test = new A04_T09();
		launch_test.A04_T09_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T01() {
		A05_T01 launch_test = new A05_T01();
		launch_test.A05_T01_case(driver);
	}

	@Test(priority = 14)
	public void A05_T02() {
		A05_T02 launch_test = new A05_T02();
		launch_test.A05_T02_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T03() {
		A05_T03 launch_test = new A05_T03();
		launch_test.A05_T03_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T04() {
		A05_T04 launch_test = new A05_T04();
		launch_test.A05_T04_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T05() {
		A05_T05 launch_test = new A05_T05();
		launch_test.A05_T05_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T06() {
		A05_T06 launch_test = new A05_T06();
		launch_test.A05_T06_case(driver);
	}
	
	@Test(priority = 14)
	public void A05_T07() {
		A05_T07 launch_test = new A05_T07();
		launch_test.A05_T07_case(driver);
	}
	
	@Test(priority = 15)
	public void A06_T01() {
		A06_T01 launch_test = new A06_T01();
		launch_test.A06_T01_case(driver);
	}
	
	@Test(priority = 16)
	public void A06_T02() {
		A06_T02 launch_test = new A06_T02();
		launch_test.A06_T02_case(driver);
	}
	
	@Test(priority = 17)
	public void A06_T03() {
		A06_T03 launch_test = new A06_T03();
		launch_test.A06_T03_case(driver);
	}

	@Test(priority = 18)

	public void A06_T05() {
		A06_T05 launch_test = new A06_T05();
		launch_test.A06_T05_case(driver);
	}
	
	@Test(priority = 19)
	public void A06_T06() {
		A06_T06 launch_test = new A06_T06();
		launch_test.A06_T06_case(driver);
	}
	
	@Test(priority = 20)
	public void A07_T01() {
		A07_T01 launch_test = new A07_T01();
		launch_test.A07_T01_case(driver);
	}
	
	@Test(priority = 21)
	public void A07_T03() {
		A07_T03 launch_test = new A07_T03();
		launch_test.A07_T03_case(driver);
	}
	
	@Test(priority = 22)
	public void A07_T04() {
		A07_T04 launch_test = new A07_T04();
		launch_test.A07_T04_case(driver);
	}
	
	@Test(priority = 23)
	public void A07_T05() {
		A07_T05 launch_test = new A07_T05();
		launch_test.A07_T05_case(driver);
	}
	
	@Test(priority = 24)
	public void A08_T01() {
		A08_T01 launch_test = new A08_T01();
		launch_test.A08_T01_case(driver);
	}
	
	@Test(priority = 25)
	public void A08_T04() {
		A08_T04 launch_test = new A08_T04();
		launch_test.A08_T04_case(driver);
	}
	
	@Test(priority = 26)
	public void A08_T05() {
		A08_T05 launch_test = new A08_T05();
		launch_test.A08_T05_case(driver);
	}
	
	@Test(priority = 27)
	public void A09_T01() {
		A09_T01 launch_test = new A09_T01();
		launch_test.A09_T01_case(driver);
	}
	
	@Test(priority = 28)
	public void A09_T03() {
		A09_T03 launch_test = new A09_T03();
		launch_test.A09_T03_case(driver);
	}
	
	@Test(priority = 29)
	public void A09_T04() {
		A09_T04 launch_test = new A09_T04();
		launch_test.A09_T04_case(driver);
	}
	
	@Test(priority = 30)
	public void A09_T05() {
		A09_T05 launch_test = new A09_T05();
		launch_test.A09_T05_case(driver);
	}
	
	@Test(priority = 31)
	public void A10_T01() {
		A10_T01 launch_test = new A10_T01();
		launch_test.A10_T01_case(driver);
	}
	
	@Test(priority = 32)
	public void A10_T03() {
		A10_T03 launch_test = new A10_T03();
		launch_test.A10_T03_case(driver);
	}
	
	@Test(priority = 33)
	public void A10_T04() {
		A10_T04 launch_test = new A10_T04();
		launch_test.A10_T04_case(driver);
	}
	
	@Test(priority = 34)
	public void A10_T05() {
		A10_T05 launch_test = new A10_T05();
		launch_test.A10_T05_case(driver);
	}
	
	@Test(priority = 35)
	public void A11_T01() {
		A11_T01 launch_test = new A11_T01();
		launch_test.A11_T01_case(driver);
	}
	
	@Test(priority = 36)
	public void A11_T02() {
		A11_T02 launch_test = new A11_T02();
		launch_test.A11_T02_case(driver);
	}
	
	@BeforeTest
	public void beforeTest() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
	  
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("deviceName","SM-G991N");
		//capabilities.setCapability("platformversion","12");
		//HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		//browserstackOptions.put("enableBiometric", "true");
		
		
		try {
			driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//func_appium_android reset = new func_appium_android();
		//reset.option_off(driver);
  }

	@AfterTest
  	public void afterTest() {
	}

}
