package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.gherkin.model.Feature;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import util.Base;

public class Hooks extends Base {

	@Before
	public void beforeScenario(Scenario s) throws IOException {
		System.out.println("*********Start of Scenario***********");
		System.out.println("Scenario Name "+s.getName());
		//setUp();
	}

	@After
	public void afterScenario(Scenario s) {
		System.out.println("*********End of Scenario*************");
		//tearDown();
	}
	
	@BeforeStep
	 public void beforeStep(Scenario scenario){
	 }
	
	@AfterStep
	 public void addScreenshot(Scenario scenario){
		
	       final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	       scenario.attach(screenshot, "image/png", "image"); 
	 }
	
	
}
