package stepDefinition;

import action.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class st {
	SignUp sp = new SignUp();

	@SuppressWarnings("deprecation")
	@Given("User navigates to {string}")
	public void getTitle(String url) {
		String t = sp.navigateToPage(System.getProperty(url));
	}

	@When("User enters {string} in {string}")
	public void user_enters_password_in(String input, String object) throws InterruptedException {
		sp.enterText(input, object);
	}
	
	
	
	@When("Clicks on {string}")
	public void clicks_on(String string) throws InterruptedException {
		sp.clickOn(string);
	}

	@Then("Verify text displayed in {string} is {string}")
	public void verify_page_is_displayed(String locator,String text) throws InterruptedException {
		String textDisplayed = sp.getText(locator);
		System.out.println(textDisplayed);
		System.out.println(text);
		Assert.assertEquals(text, textDisplayed);
	}
	
	@Then("Verify page title contains text {string}")
	public void verify_title(String text) throws InterruptedException {
		String title = sp.getPageTitle();
		Assert.assertTrue(title.contains(text));
	}
	
	@Then("User waits for {string} second")
	public void wait(String sec) throws InterruptedException {
		
		Thread.sleep(Integer.parseInt(sec+"000"));
	}
	
	@Then("User enters {string} in {string} and press enter")
	public void pressEnter(String val,String locator) throws InterruptedException {
		sp.enterTextAndPressEnter(val, locator);
	}
	
	@When("User save {string} in {string}")
	public void saveVariable(String value,String var) throws InterruptedException {
		sp.saveVaraible(var,value);
	}
	
	@When("User hits the GET api {string} by replacing {string} and fetches {string} and stores in data")
	public void saveVariable(String api,String replaceVar,String fetchVar)  {
		sp.getAPI(api, replaceVar,fetchVar);;
	}
	
	@Then("User prints the data on the console for the variables {string}")
	public void printVariables(String var) throws InterruptedException {
		sp.printVar(var);
	}
	

}
