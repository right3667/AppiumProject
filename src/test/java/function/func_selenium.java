package function;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
    	wait.until(ExpectedConditions.alertIsPresent());
    	driver.switchTo().alert().accept();
    	
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
	
}

