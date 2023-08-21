package eWalker_SSL_VPN_V10;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import test_case_ios.*;


public class eWalker_SSL_VPN_iOS_launch {
	
	IOSDriver<IOSElement> driver;
	Date date_now = new Date(System.currentTimeMillis());
	
	@Test(priority = 0)
	public void I01_T01() {
		I01_T01 launch_test = new I01_T01();
		launch_test.I01_T01_case(driver);
	}
	
	@Test(priority = 1)
	public void I02_T01() {
		I02_T01 launch_test = new I02_T01();
		launch_test.I02_T01_case(driver);
	}
	
	@Test(priority = 2)
	public void I02_T02() {
		I02_T02 launch_test = new I02_T02();
		launch_test.I02_T02_case(driver);
	}

	@Test(priority = 3)
	public void I03_T01() {
		I03_T01 launch_test = new I03_T01();
		launch_test.I03_T01_case(driver);
	}
	
	@Test(priority = 4)
	public void I03_T02() {
		I03_T02 launch_test = new I03_T02();
		launch_test.I03_T02_case(driver);
	}
	
	
	@Test(priority = 5)
	public void I03_T03() {
		I03_T03 launch_test = new I03_T03();
		launch_test.I03_T03_case(driver);
	}
	
	
	@Test(priority = 5)
	public void I04_T01() {
		I04_T01 launch_test = new I04_T01();
		launch_test.I04_T01_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T02() {
		I04_T02 launch_test = new I04_T02();
		launch_test.I04_T02_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T03() {
		I04_T03 launch_test = new I04_T03();
		launch_test.I04_T03_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T04() {
		I04_T04 launch_test = new I04_T04();
		launch_test.I04_T04_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T05() {
		I04_T05 launch_test = new I04_T05();
		launch_test.I04_T05_case(driver);
	}

	@Test(priority = 5)
	public void I04_T06() {
		I04_T06 launch_test = new I04_T06();
		launch_test.I04_T06_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T07() {
		I04_T07 launch_test = new I04_T07();
		launch_test.I04_T07_case(driver);
	}
	
	@Test(priority = 5)
	public void I04_T08() {
		I04_T08 launch_test = new I04_T08();
		launch_test.I04_T08_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T01() {
		I05_T01 launch_test = new I05_T01();
		launch_test.I05_T01_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T02() {
		I05_T02 launch_test = new I05_T02();
		launch_test.I05_T02_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T03() {
		I05_T03 launch_test = new I05_T03();
		launch_test.I05_T03_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T04() {
		I05_T04 launch_test = new I05_T04();
		launch_test.I05_T04_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T05() {
		I05_T05 launch_test = new I05_T05();
		launch_test.I05_T05_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T06() {
		I05_T06 launch_test = new I05_T06();
		launch_test.I05_T06_case(driver);
	}
	
	@Test(priority = 5)
	public void I05_T07() {
		I05_T07 launch_test = new I05_T07();
		launch_test.I05_T07_case(driver);
	}
	
	@Test(priority = 5)
	public void I06_T01() {
		I06_T01 launch_test = new I06_T01();
		launch_test.I06_T01_case(driver);
	}
	
	
	@Test(priority = 5)
	public void I06_T02() {
		I06_T02 launch_test = new I06_T02();
		launch_test.I06_T02_case(driver);
	}
	
	@Test(priority = 5)
	public void I06_T03() {
		I06_T03 launch_test = new I06_T03();
		launch_test.I06_T03_case(driver);
	}
	
	@Test(priority = 5)
	public void I06_T05() {
		I06_T05 launch_test = new I06_T05();
		launch_test.I06_T05_case(driver);
	}
	
	@Test(priority = 5)
	public void I06_T06() {
		I06_T06 launch_test = new I06_T06();
		launch_test.I06_T06_case(driver);
	}
	
	@Test(priority = 5)
	public void I07_T01() {
		I07_T01 launch_test = new I07_T01();
		launch_test.I07_T01_case(driver);
	}
	
	@Test(priority = 5)
	public void I07_T03() {
		I07_T03 launch_test = new I07_T03();
		launch_test.I07_T03_case(driver);
	}	
	
	@Test(priority = 5)
	public void I07_T04() {
		I07_T04 launch_test = new I07_T04();
		launch_test.I07_T04_case(driver);
	}	
	
	@Test(priority = 5)
	public void I07_T05() {
		I07_T05 launch_test = new I07_T05();
		launch_test.I07_T05_case(driver);
	}
	
	@Test(priority = 5)
	public void I08_T01() {
		I08_T01 launch_test = new I08_T01();
		launch_test.I08_T01_case(driver);
	}
	
	@Test(priority = 5)
	public void I08_T03() {
		I08_T03 launch_test = new I08_T03();
		launch_test.I08_T03_case(driver);
	}
	
	@Test(priority = 5)
	public void I08_T04() {
		I08_T04 launch_test = new I08_T04();
		launch_test.I08_T04_case(driver);
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
	  
		capabilities.setCapability("platformName","ios");
		capabilities.setCapability("deviceName","SOOSAN iPhone");
		capabilities.setCapability("udid","00008101-001C65D43630001E");
		capabilities.setCapability("automationName","xcuitest");
	  
		try {
			driver = new IOSDriver<IOSElement> (new URL("http://127.0.0.1:4723/"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
