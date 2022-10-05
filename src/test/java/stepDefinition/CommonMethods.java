package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import constants.Constants1;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilityPackage.CommonUtils;
import webdriver_Manager.DriverManager;

public class CommonMethods {
	@Before
	public void beforeScenario() {
		try {
			CommonUtils commonUtils = new CommonUtils();
			commonUtils.loadProperty();
			if(DriverManager.getDriver()==null) {
				DriverManager.launchBrowser();
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().get(Constants1.URL);
				CommonUtils.initWebelement();
				getLog();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Logger logs=Logger.getLogger(CommonMethods.class.getName());
	public static Logger getLog() {
	String conf="D:\\project\\TesttingFrameworks\\ArmyCucumber\\src\\test\\resources\\army.properties";
	PropertyConfigurator.configure(conf);
	return logs;
	}
	 int i=0;
	@After
    public void after(Scenario scenario) throws IOException{
			
    		File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            i++;
            if(!scenario .isFailed()) {
    	      scenario .attach(fileContent , "image/png", scenario.getName()+i);
    	      scenario .log(scenario.getName()+"scenario executed");
            }
            else {
            	 scenario .attach(fileContent , "image/png", scenario.getName()+i);
       	      scenario .log(scenario.getName()+"scenario failed");	
            }
      
    }
}
