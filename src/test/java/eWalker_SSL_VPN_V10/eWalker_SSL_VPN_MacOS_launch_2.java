package eWalker_SSL_VPN_V10;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;


public class eWalker_SSL_VPN_MacOS_launch_2 {
	
	
	Date date_now = new Date(System.currentTimeMillis());
	AppiumDriver driver;
	//WebDriver driver;
	
	//driver = 
	
	@Test(priority = 0)
	public void I01_T01() {
		driver.executeScript("macos: activateApp", ImmutableMap.of("bundleId", "com.soosanint.ewalker.vpn.mac.v10"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "test");
		try {
			Thread.sleep(2000); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//System.out.println(driver.getPageSource());
		//driver.findElementByIosNsPredicate("value CONTAINS '['").getAttribute("value");
		//driver.findelement
		
		//driver.findElementByAccessibilityId("_NS:155").click();
		//driver.findElement("xpath", "/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXIdentifier='_NS:183']").click();
		//driver.findElementByXPath("/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXIdentifier='_NS:183']").click();
		//driver.findElementByXPath("/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXTitle='  Login' and @AXIdentifier='_NS:155']").click();
		//driver.findElement(By.xpath("/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXTitle='  Login' and @AXIdentifier='_NS:155']")).click();
		//driver.findElementByXPath("/AXApplication[@AXTitle='SVMClient']/AXWindow[@AXTitle='SVMClient' and @AXIdentifier='_NS:8' and @AXSubrole='AXStandardWindow']/AXButton[@AXTitle='  Login' and @AXIdentifier='_NS:155']").click();
	
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
		capabilities.setCapability("deviceName","MacBookPro11,4");
		capabilities.setCapability("automationName","Mac2");
		
		
		try {
			driver = new AppiumDriver (new URL("http://127.0.0.1:4723/"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  @AfterTest
  public void afterTest() {
  }

}
