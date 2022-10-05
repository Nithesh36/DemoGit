package webdriver_Manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import constants.Constants1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	static Logger logger=Logger.getLogger(DriverManager.class);
	public  static WebDriver driver=null;
	public static void launchBrowser() {
		try {
			switch (Constants1.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				logger.info("Launching "+Constants1.BROWSER);
				driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching "+Constants1.BROWSER);
				driver=new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				logger.info("Launching "+Constants1.BROWSER);
				driver=new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				logger.info("Launching "+Constants1.BROWSER);
				driver=new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				logger.info("Launching "+Constants1.BROWSER);
				driver=new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
