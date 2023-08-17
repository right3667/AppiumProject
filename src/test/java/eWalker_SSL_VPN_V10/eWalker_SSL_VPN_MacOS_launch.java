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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class eWalker_SSL_VPN_MacOS_launch {
	
	
	Date date_now = new Date(System.currentTimeMillis());
	AppiumDriver driver;

	
	//driver = 
	
	@Test(priority = 0)
	public void I01_T01() {
		driver.get("SVMClient");
        
		try {
			Thread.sleep(2000); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		driver.findElementByXPath("/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXTitle='  Login' and @AXIdentifier='_NS:155']").click();
	
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
	
	@BeforeTest
  	public void beforeTest() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
	  
		capabilities.setCapability("platformName","Mac");
		capabilities.setCapability("deviceName","Mac");
		
		try {
			driver = new AppiumDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
