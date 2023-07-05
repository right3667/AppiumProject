package test_case_android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import function.func_selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class A03_T03_webconf {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    
    //func_selenium func = new func_selenium();
    
    func_selenium func = new func_selenium();
    
    //Properties
    public String WEB_DRIVER_ID = "webdriver.chromedriver";
    public String WEB_DRIVER_PATH = "/usr/bin/chromedriver";
    //public String server_ip = "192.168.35.30"; // 테스트
    public String server_ip = "172.16.150.20"; //자동화 실제
    public int server_ip_division = 20;
    public String encryption_algorithm = "SEED";
    
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
    	
    	A03_T03_webconf selTest = new A03_T03_webconf();
        //selTest.encryption_algorithm();
    	
    	selTest.pw_expire();
    }
    
    public void pw_expire() {
    	WebDriverManager.chromedriver().setup();
     	//driver.manage().timeouts().implicitlyWait(1,  TimeUnit.SECONDS);
    	//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    	func.login_manager(driver, server_ip);
    	
    	//[오브젝트 > 사용자] 이동
    	func.frame_mv(driver, "leftFrame");
    	driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a/img")).click();
    	driver.switchTo().defaultContent();
    	
    	func.frame_mv(driver, "leftFrame");
    	driver.findElement(By.xpath("//div[@id='side']/ul[2]/li[5]/a/img")).click();
    	driver.switchTo().defaultContent();
    	
    	//find user
    	func.frame_mv(driver, "mainFrame");
    	driver.findElement(By.id("searchWord")).sendKeys("pw_expired");
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[7]/fieldset/strong/span/img")).click();
    	
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td[3]/a")).click();
    	
    	driver.findElement(By.id("pwd")).sendKeys("admin123!");
    	driver.findElement(By.id("pwd_chk")).sendKeys("admin123!");
    	
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[2]/strong/span/img")).click();
    	
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
        
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	//expire user
    	driver.findElement(By.id("searchWord")).sendKeys("pw_expired");
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[7]/fieldset/strong/span/img")).click();
    	
    	driver.findElement(By.name("checkSid")).click();
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[1]/div/strong[1]/span")).click();
    	
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	driver.switchTo().defaultContent();
		
    	//로그아웃
    	func.logout_manager(driver);

    	/*
        for (WebElement frame : frames0) {
            System.out.println(frame.getAttribute("name"));
    	}
    	
    	java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
        driver.switchTo().frame(1);
    	
            System.out.println(frame.getAttribute("name"));
    	}
        
        	
    	/*TouchAction actionOne = new TouchAction(driver);
		actionOne.press(PointOption.point(184, 968)).moveTo(PointOption.point(904, 968)).moveTo(PointOption.point(904, 1688)).release();
		actionOne.perform();
    	*/
    	
    	
    	
    	//MobileElement app_info_btn = (MobileElement) driver.findElementByAccessibilityId("버전정보");
    	//app_info_btn.click();
    	//System.out.println(driver.getPageSource());
        
      	driver.close();
    }
    public void encryption_algorithm() {
    	WebDriverManager.chromedriver().setup();
     	
    	func.login_manager(driver, server_ip);
    	
        func.encryption_algorithm(driver, encryption_algorithm);
    	
        func.logout_manager(driver);
    }
}

