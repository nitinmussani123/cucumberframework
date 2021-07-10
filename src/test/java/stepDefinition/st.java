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
		System.out.println("INSIDE");
		String t = sp.navigateToPage(System.getProperty(url));
		Assert.assertTrue(t.contains("Sign"));
	}

	@When("User enters {string} in {string}")
	public void user_enters_password_in(String input, String object) throws InterruptedException {
		sp.enterText(input, object);
	}
	
	@When("Generate random valid email id and store in {string}")
	public void user_enters_password_in(String var) throws InterruptedException {
		sp.generateValidUsernameAndSave(var);
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
	
	@Then("Verify user is navigate to new page and verify text in {string} is {string}")
	public void verify_navigation_to_page(String locator,String text) throws InterruptedException {
		String textDisplayed = sp.navigateToPageAndVerifyText(locator);
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
	
	@Then("Pop up window is displayed")
	public void pp() throws InterruptedException {
		
		sp.popUpHandle();
	}
	

}
