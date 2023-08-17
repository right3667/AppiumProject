package eWalker_SSL_VPN_V10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class web_test {
 
    public static void main(String[] args) {
 
    	web_test selTest = new web_test();
        selTest.crawl();    
    }
    
    //WebDriver
    private WebDriver driver;
   
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chromedriver";
    public static final String WEB_DRIVER_PATH = "/usr/bin/chromedriver";
    
    //크롤링 할 URL
    private String base_url;
    
    public web_test() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://192.168.35.30";
        String latestVersion = WebDriverManager.chromedriver().getDownloadedDriverVersion();
        System.out.println("Latest ChromeDriver version: " + latestVersion);

    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            System.out.println("test");
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            //driver.close();
        }
 
    }
 
}
