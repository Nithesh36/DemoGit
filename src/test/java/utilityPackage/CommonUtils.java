package utilityPackage;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import constants.Constants1;
import pageFactory.MediaRelaseObjects;
import webdriver_Manager.DriverManager;

public class CommonUtils {
	static Logger logger=Logger.getLogger(CommonUtils.class);
	Properties properties=new Properties();
	public  void loadProperty() {
		
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constants1.URL= properties.getProperty("url");
		Constants1.BROWSER= properties.getProperty("browser");
		Constants1.REPORT=properties.getProperty("reportConfigPath");
	}
	public static void initWebelement() {
//		PageFactory.initElements(DriverManager.getDriver(), MediaRelaseObjects.class);
//		PageFactory.initElements(DriverManager.getDriver(),Women.getInstance());
//		PageFactory.initElements(DriverManager.getDriver(), Men.getInstance());
//		PageFactory.initElements(DriverManager.getDriver(), Accessories.getInstance());
	}
		//This method is used for wait page some time
		public static void waitTime(int s) {
			try {
				TimeUnit.SECONDS.sleep(s);
			} catch (InterruptedException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}

}
