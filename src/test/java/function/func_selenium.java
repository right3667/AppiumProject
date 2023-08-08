package function;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class func_selenium {
	
	public static void main(String[] args) {
	}
	
	public void login_manager(WebDriver driver, String server_ip) {
		driver.get("https://" + server_ip + ":9000");
    	
    	//
    	driver.findElement(By.id("details-button")).click();
    	driver.findElement(By.id("proceed-link")).click();
        	    	
    	//관리자 로그인
    	//WebElement frames = driver.findElement(By.cssSelector("frame"));
    	frame_mv(driver, "start");
		
    	WebElement manager_id = driver.findElement(By.id("adminid"));
    	manager_id.sendKeys("manager");
    	Actions actions = new Actions(driver);
    	actions.sendKeys(Keys.TAB).sendKeys("admin123!").perform();
    	driver.findElement(By.className("login")).click();
    	
    	try {
    		driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
    	
	}
	
	public void logout_manager(WebDriver driver) {
		frame_mv(driver, "topFrame");
    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[4]/img")).click();
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
	}

	public void sleep(int minute) {
		minute = minute * 1000;
		try {
			Thread.sleep(minute); //1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void encryption_algorithm(WebDriver driver, String name) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "암호 알고리즘 변경: " + name);
		frame_mv(driver, "leftFrame");
    	driver.findElement(By.xpath("//*[@id=\"menu\"]/li[1]/a/img")).click();
    	    	  	
    	frame_mv(driver, "leftFrame");
    	
    	driver.findElement(By.xpath("//div[@id='side']/ul[2]/li[3]/a/img")).click();
    	//driver.findElement(By.xpath("//div[@id='side']/ul[2]/li[4]/a/img")).click(); //xpath 동작되지 않음
    	Actions actions = new Actions(driver);
    	actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform(); 	
    	
    	frame_mv(driver, "mainFrame");
    	if (name == "AES 192") {
    		driver.findElement(By.id("aes192")).click();
    	}
    	else if (name == "AES 256") {
    		driver.findElement(By.id("aes256")).click();
    	}
    	else if (name == "SEED") {
    		driver.findElement(By.id("seed")).click();
    	}
    	else if (name == "ARIA 128") {
    		driver.findElement(By.id("aria128")).click();
    	}
    	else if (name == "ARIA 256") {
    		driver.findElement(By.id("aria256")).click();
    	}
    	else if (name == "LEA 128") {
    		driver.findElement(By.id("lea128")).click();
    	}
    	else if (name == "LEA 256") {
    		driver.findElement(By.id("lea256")).click();
    	}
    	    	
    	driver.findElement(By.xpath("//*[@id=\"sslDefaultForm\"]/div[2]/strong/span")).click();
    	   	
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	//sleep(16);

    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();  	
    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "암호 알고리즘 변경 완료");
		
	}
	
	public void frame_mv(WebDriver driver, String frame_name) {
		driver.switchTo().defaultContent();
		if (frame_name == "asdf"){
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(0);
		}
		else if (frame_name == "start") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
		}
		
		else if (frame_name == "bh01") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(0);
		}
		else if (frame_name == "processFrame") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
		}
		else if (frame_name == "topFrame") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(2);
		}
		else if (frame_name == "area01") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(3);
		}
		else if (frame_name == "footFrame") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(4);
		}
		else if (frame_name == "bh02") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(5);
		}
		else if (frame_name == "leftFrame") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(3);
	    	java.util.List<WebElement> frames3 = driver.findElements(By.tagName("frame"));
			frames3.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(0);
		}
		else if (frame_name == "mainFrame") {
			java.util.List<WebElement> frames1 = driver.findElements(By.tagName("frame"));
			frames1.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
	    	java.util.List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
			frames2.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(3);
	    	java.util.List<WebElement> frames3 = driver.findElements(By.tagName("frame"));
			frames3.addAll(driver.findElements(By.tagName("iframe")));
	    	driver.switchTo().frame(1);
		}
	}
	
	 public void pw_expire(WebDriver driver, String server_ip, String user_id, String old_pw) {
		 System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "패스워드 만료 설정 실행");
			
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			
		 WebDriverManager.chromedriver().setup();
     	//driver.manage().timeouts().implicitlyWait(1,  TimeUnit.SECONDS);
    	//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    	login_manager(driver, server_ip);
    	
    	//[오브젝트 > 사용자] 이동
    	frame_mv(driver, "leftFrame");
    	driver.findElement(By.xpath("//*[@id=\"menu\"]/li[3]/a/img")).click();
    	driver.switchTo().defaultContent();
    	
    	frame_mv(driver, "leftFrame");
    	driver.findElement(By.xpath("//div[@id='side']/ul[2]/li[5]/a/img")).click();
    	driver.switchTo().defaultContent();
    	
    	//find user
    	frame_mv(driver, "mainFrame");
    	driver.findElement(By.id("searchWord")).sendKeys(user_id);
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[7]/fieldset/strong/span/img")).click();
    	
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[3]/table/tbody/tr/td[3]/a")).click();
    	
    	driver.findElement(By.id("pwd")).sendKeys(old_pw);
    	driver.findElement(By.id("pwd_chk")).sendKeys(old_pw);
    	
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[2]/strong/span/img")).click();
    	
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
        
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	//expire user
    	driver.findElement(By.id("searchWord")).sendKeys(user_id);
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[7]/fieldset/strong/span/img")).click();
    	
    	driver.findElement(By.name("checkSid")).click();
    	driver.findElement(By.xpath("//*[@id=\"content-area\"]/div[1]/div/strong[1]/span")).click();
    	
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	driver.switchTo().defaultContent();
    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + " " + "패스워드 만료 설정 완료");
    }
}

