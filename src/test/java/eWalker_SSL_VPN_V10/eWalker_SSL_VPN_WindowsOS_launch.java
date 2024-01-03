package eWalker_SSL_VPN_V10;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;


public class eWalker_SSL_VPN_WindowsOS_launch {
	
	
	Date date_now = new Date(System.currentTimeMillis());
	WindowsDriver driver;

	
	//driver = 
	
	@Test(priority = 0)
	public void I01_T01() {
		//driver.get("C:\\Windows\\System32\\notepad.exe");
        
		
		
		try {
			Thread.sleep(2000); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
	
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
		capabilities.setCapability("app", "C:\\\\Windows\\\\System32\\\\notepad.exe");
		capabilities.setCapability("platformName","Windows");
		capabilities.setCapability("platformVersion","10");
		capabilities.setCapability("deviceName", "DESKTOP-HFMB9S6");
		
		try {
			driver = new WindowsDriver (new URL("http://127.0.0.1:4723/"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
