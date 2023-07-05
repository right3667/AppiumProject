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
		while (true) {
			I02_T02 launch_test = new I02_T02();
			launch_test.I02_T02_case(driver);
		}
	}

	@Test(priority = 3)
	public void I03_T01() {
		I03_T01 launch_test = new I03_T01();
		launch_test.I03_T01_case(driver);
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
			driver = new IOSDriver<IOSElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
