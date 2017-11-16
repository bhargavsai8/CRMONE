package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.TestUtil;
import com.crm.qa.utility.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eDriver;
	public static WebEventListener weblistener;
	public static Logger log;
	
	
	public BaseClass() 
	{
		log =  Logger.getLogger("devpinoyLogger");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
	//	String path = System.getProperty("user.dir");
		if(browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"\\chromedriver.exe");
			driver=new ChromeDriver();
		}
				
		
		eDriver = new EventFiringWebDriver(driver);
		weblistener = new WebEventListener();
		eDriver.register(weblistener);
		driver=eDriver;
		
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pagelod,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}
