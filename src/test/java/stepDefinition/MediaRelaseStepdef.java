package stepDefinition;
import io.cucumber.java.en.When;
import pageFactory.MediaRelaseObjects;
import webMethods.WebElementActions;
import webdriver_Manager.DriverManager;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import constants.Constants1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MediaRelaseStepdef {
	
	public static Logger logs=Logger.getLogger(MediaRelaseStepdef.class.getName());
		@Test(priority = 1)
	    @When("click the alert and handle that alert")
	    public void handleAlert() {
			PageFactory.initElements(DriverManager.driver,MediaRelaseObjects.class);
			WebElementActions.loadUrl(Constants1.URL);
	    	WebElementActions.click(MediaRelaseObjects.alert);
	    }
		
	    @When("mouse over to the media menu")
	    public void moveToMenu() {
	    	WebElementActions.MouseOver(MediaRelaseObjects.mediaMenu);
	    }
	    @When("clcik the photoMenu")
	    public void clickTheSubMenu() {
	    	WebElementActions.click(MediaRelaseObjects.photoMenu);
	
	    }
	    @When("click the relaseYear")
	    public void RelaseYear() {
	    	WebElementActions.waits(10);
	    	WebElementActions.click(MediaRelaseObjects.relaseYear2020);

	    }
	    @And("click the article")
	    public void clickArticle() {
	    	WebElementActions.click(MediaRelaseObjects.article);
	    }
	    @Then("scroll down see image Health")
	    public void Scrolldown() {
	    	logs.info("scrolldown to take screenshot of unavailable images");
	    	WebElementActions.scrollDown();
	    }

	    @When("click the any other realseYear")
	    public void BrokenRelaseYear() {
	    	WebElementActions.click(MediaRelaseObjects.relaseyear2012);
	    	

	    }
	    @And("click the any links for getting image")
	    public void imgLink() {
	    	WebElementActions.click(MediaRelaseObjects.armyExploreImageLink);
	    }
	    @Then("scroll down see image is broken")
	    public void ScrollDown() {
	    	try {
	    	((JavascriptExecutor)DriverManager.driver).executeScript("window.scrollBy('0','600')");
	    	if(WebElementActions.GetImageAttributeVal(MediaRelaseObjects.armyExploreImage)>0){
				assertEquals(0, 0);
			}
	    	else
	    		assertEquals(true, false);
	    	}
	    	catch (Exception e) {
				e.printStackTrace();
			}
	    }

}
