package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
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

public static void insilization(){
	
	String browserName=prop.getProperty("browser");
	//DesiredCapabilities dr=null;
	//dr=DesiredCapabilities.chrome();
	//dr.setBrowserName("chrome");
	//dr.setPlatform(Platform.WINDOWS);
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","D:/chromedriver/chromedriver.exe");

		//driver =new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"),dr);
<<<<<<< HEAD
		driver=new ChromeDriver();
=======
		//driver=new ChromeDriver();
>>>>>>> 89e310e8aac9a667c5de6ece8a9ce3a2fed46f0f
		
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
