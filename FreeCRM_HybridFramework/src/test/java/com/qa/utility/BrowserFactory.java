package com.qa.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver ldriver, String browserName, String appURL) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ldriver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			ldriver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			ldriver = new EdgeDriver();
			
		}else {
			
			System.out.println("We do not support this browser");
		}
		
		ldriver.manage().window().maximize();
		ldriver.get(appURL);
		ldriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return ldriver;
	}
	
	public static void quitBrowser(WebDriver ldriver) {
		ldriver.quit();	
	}

}
