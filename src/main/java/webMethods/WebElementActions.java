package webMethods;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver_Manager.DriverManager;

public class WebElementActions {
	
	public static JavascriptExecutor js=(JavascriptExecutor)DriverManager.driver;
	public static Actions act=new Actions(DriverManager.driver);
	public static  void MouseOver(WebElement ele) {
		act.moveToElement(ele).perform();
	}
	public static  void MouseOverAndClick(WebElement ele) {
		act.moveToElement(ele).click().build().perform();
	}
	public static void click(WebElement ele) {
		if(ele.isDisplayed())
		ele.click();
	}
	public static int GetImageAttributeVal(WebElement ele) {
		return Integer.valueOf(ele.getAttribute("naturalWidth"));
	}
	public static void scrollDown() {
		js.executeScript("window.scrollBy('0','200')");
	}
	public static void DropDownSelect(WebElement ele,String value,String type) {
		Select select=new Select(ele);
		if(type.equalsIgnoreCase("Value"))
		select.selectByValue(value);
		else if(type.equalsIgnoreCase("index"))
			select.selectByIndex(Integer.valueOf(value));
		else if(type.equalsIgnoreCase("visibleText"))
			select.selectByVisibleText(value);

	}
	
	public static void waits(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 static boolean  found=false;

		public static  boolean isFileDownloaded(String downloadPath, String fileName) {
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (File file : dir_contents) {
		    	if(file.getName().equalsIgnoreCase(fileName))
		    		found=true;
	 		}
		   return found; 
		    
		}
		public static void Type(WebElement ele,String value) {
			ele.sendKeys(value);
		}
		public static void naviagtion(String naviagtionType) {
			if(naviagtionType.equalsIgnoreCase("back"))
				DriverManager.driver.navigate().back();
			else if(naviagtionType .equalsIgnoreCase("forward"))
				DriverManager.driver.navigate().forward();
			else
				DriverManager.driver.get(naviagtionType);
		}
		public static void loadUrl(String url)
		{
			DriverManager.driver.get(url);
		}
		public static void handleElementNotInteractable(By ele) {
			WebDriverWait wait=new WebDriverWait(DriverManager.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated((ele)));
			
		}
}
