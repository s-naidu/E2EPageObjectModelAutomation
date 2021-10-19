package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	//browserstack setup
	//public static final String USERNAME = "sudarshan30";
	//public static final String AUTOMATE_KEY = "fZAL6pfg3KtkyYCuw1ye";
	//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	//selenium grid congig
	//public static DesiredCapabilities dr=null;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	
public TestBase(){
	
	try{
		
		prop=new Properties();
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
	      prop.load(fp);
	      
	}catch (FileNotFoundException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
		}
}

public static void insilization() throws MalformedURLException{
	
	String browserName=prop.getProperty("browser");
	
	//selenium grid setup
	//DesiredCapabilities dr=null;
	//dr=DesiredCapabilities.chrome();
	//dr.setBrowserName("chrome");
	//dr.setPlatform(Platform.WINDOWS);
	
	//browser stack
	//DesiredCapabilities caps=new DesiredCapabilities();
	//caps.setCapability("browser", "chrome");
	//caps.setCapability("browser_version", "94.0");
	//caps.setCapability("os", "Windows");
	//caps.setCapability("os_version", "10");
	//caps.setCapability("build", "browserstack-build-1");
	
	//caps.setCapability("name", "Thread 1");
	
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","D:/chromedriver/chromedriver.exe");

		//selenium grid setup
		//driver =new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"),dr);
		//driver =new RemoteWebDriver(new URL(URL),caps);
		//driver =new RemoteWebDriver(new java.net.URL(URL),caps);

		driver=new ChromeDriver();
		
	}else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "D:/geckodriver-v0.30.0-win64/geckodriver.exe");	
		driver = new FirefoxDriver(); 
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}

}
