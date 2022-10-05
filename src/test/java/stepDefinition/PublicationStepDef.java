package stepDefinition;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import constants.Constants1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageFactory.MediaRelaseObjects;
import pageFactory.PublicationObjects;
import webMethods.WebElementActions;
import webdriver_Manager.DriverManager;

public class PublicationStepDef {
	public static Logger logs=Logger.getLogger(PublicationStepDef.class.getName());
	@Test(priority = 3)
	@When("mouse over to PublicationMenu")
	public void mouseOverToPublication() {
		try {
		logs.info("publication page Factory elements are initiaized");
		PageFactory.initElements(DriverManager.driver, PublicationObjects.class);
		WebElementActions.loadUrl(Constants1.URL);
		WebElementActions.click(MediaRelaseObjects.alert);
		//mouse over the publication menu
		WebElementActions.MouseOver(PublicationObjects.publicationMenu);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("move into BaatCheet Section")
	public void MovetoSubMenu() {
		try {
		WebElementActions.click(PublicationObjects.BaatCheet);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("user select a value {string} from the dropdown is the type of {string}")
	public void SelectDropDown(String indValue,String TypeOfSelection) {
		try {
		//select a  year from the dropdown
		logs.info("select a  year from the dropdown");
		WebElementActions.DropDownSelect(PublicationObjects.yearSelectionDropDown, indValue, TypeOfSelection);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@And("user waits for someTime {string}")
	public void WaitForsomeTime(String time) {
		try {
		logs.info("Document is displayed");
		WebElementActions.waits(Integer.valueOf(time));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
